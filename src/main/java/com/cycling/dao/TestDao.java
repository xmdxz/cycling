package com.cycling.dao;

import com.cycling.dto.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author xpdxz
 * @ClassName TestDao
 * @Description TODO
 * @Date 2021/9/25 20:28
 * @Version 1.0
 */

public interface TestDao {

    @Select("select * from t_student")
    List<Student> getStudentList();
}
