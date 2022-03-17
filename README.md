


# 秒杀系统的总结实现(单机秒杀)

**实现基本工具：**redis -------->rabbitMq----------->dao

**基本问题：**只是列出一些最基本的问题，当然还有其他的问题，比如接口安全性等等

1. 瞬时涌入大量请求，导致服务器卡死瘫痪
2. 大量用户同时请求削减库存，导致超卖问题

**压测结果：**

使用了Jmeter进行压测，具体测试流程不在赘述，直接贴出结果，同时抢购50件

1. 瞬时500并发

   次数：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110235_5ce98f1d_8620885.png "屏幕截图.png")

   库存：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110241_04df244a_8620885.png "屏幕截图.png")

   订单：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110248_61e7d05c_8620885.png "屏幕截图.png")

   订单是否重复？执行语句 **select count(*) from participation group by limit_activity_id,user_id;**

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110256_18f457dd_8620885.png "屏幕截图.png")

   

2. 瞬时5000并发

   次数：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110302_964751ef_8620885.png "屏幕截图.png")

   库存：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110311_88bae093_8620885.png "屏幕截图.png")

   订单：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110318_b3d65a19_8620885.png "屏幕截图.png")

   是否重复：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110323_ebe91116_8620885.png "屏幕截图.png")

3. 瞬时10000并发

   次数：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110329_286d4c33_8620885.png "屏幕截图.png")

   库存：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110335_dcc307e5_8620885.png "屏幕截图.png")

   订单：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110342_3aff7faa_8620885.png "屏幕截图.png")

   是否重复：

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110353_87816be7_8620885.png "屏幕截图.png")

4. 20000次也测试过，么有问题，但是电脑差点报废

**解决方案：**

1. 该方法目前技术栈无法完善解决，只了解到使用nginx的漏桶进行限流，以及先进入rabbitmq进行削峰

2. 主要解决库存问题，防止库存出现错误

   **主要流程：**本项目是一个骑行APP项目，出现秒杀是因为，项目业务中有一个限时活动奖励的模块，冠军可得丰厚的奖励，限时开启，限时结束。主要就是让本应该mysql进行抗压的操作，转移到redis进行，redis本身具有速度快，抗压能力高，操作命令都是原子性的特点，所以很合适不过，通过redis预减库存，预减成功后，将其加入RabbitMq队列中，使用消费者操作数据库，并加上事务，主要防守手段就是层层判断筛选过滤漏网之鱼。

   #### 数据库

   ###### 表名：limit_activity   (限时活动表)

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110701_f431c921_8620885.png "屏幕截图.png")
   ###### 表名：price (奖品) 

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110707_f043b261_8620885.png "屏幕截图.png")

   ###### 表名：participation  (参加人员表,类似于商品订饭表)

   ![输入图片说明](https://images.gitee.com/uploads/images/2022/0317/110712_5637298d_8620885.png "屏幕截图.png")
  
   #### 存在的问题

   1. 很明显，只解决了秒杀中最核心的库存问题，保证不超卖，不遗留，但是其他的优化什么的没有做，这里就不做赘述，优化方案过于高级，目前不在本人的技术范围内。
   2. 有一个浪费资源的问题，请看秒杀接口中，我为了保证原子性，并没有对存入redis的三个key进行过期操作，清理等，久而久之就会导致占用内存，甚至会占用过多，解决办法也很简单。你可以在发布秒杀任务的时候，定义一个定时任务，在秒杀任务结束时，清除相关的key。

   ## Redis组合原子操作的原子性的理解(单机redis的理解，分布式的不同的redis肯定不适用！)

   ```java
   //他为什么是原子性呢，使用if包裹，decr本身是原子性的，这是这里的字节码，无论某个线程在哪一行阻塞，都不会导致不安全
   //LCONST_1 //这里是读操作，你阻塞不阻塞。和我没关系
   //INVOKESTATIC com/cycling/utils/RedisUtil.decr (Ljava/lang/String;J)J //这里一定是串行，redis单命令保证原子性
   //LCONST_0 //这里同样是读
   //LCMP  // 这里是比较大小，那为什么这里阻塞也没有关系，因为走到这里，比较的双方已经固定，并且，预减decr操作是串行，保证原子性，他的结果一定不一样，就是1001个线程执行了预检，1001个结果也一定不同，不可能会得到两个一样的数据。如果此时有1000个库存，那只会有最后的第1001个库存会进来。而在第1000次之后的所有请求，他都会进来，并且是顺序进来
   if (RedisUtil.decr(activityKey, 1) < 0) {
       // 那如果第1000次后来的线程中，有一个在这里阻塞了呢？确实会存在这个问题，但是，无论你阻塞了多少个，你上一个decr语句已经执行，也就是说，你进来多少次我减多少次。假如有十个线程进来，发现都预检之后都小于0，都会进来，但其中几个在这里被阻塞了，那又有什么关系，我现在库存已经被预减了，库存就是-10，你别的线程再怎么加也只能加一，并且他incr也是原子性，所以最后属于自己的那份还是得自己来加回来。
       RedisUtil.incr(activityKey, 1);
       //库存不足
       return 0;
   }
   ```

   但是，只有这种情况可以保证原子性，也就是原子加减并原子获取

   ```java
   //这就不是原子性了
   String old = RedisUtil.get(key);
   //假如两个线程同时执行，第一个线程执行到这里阻塞住了，第二个线程获取old之后发现也为null，也走到了这里，此时第二个线程判断后将newValue赋值为1，第一个线程恢复运行，后面就不再赘述。
   String newValue = old == null ? 1 : old + 1;
   RedisUtil.set(key,newValue)
   
   ```

   

