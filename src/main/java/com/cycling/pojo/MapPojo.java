package com.cycling.pojo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2021/11/10 19:56
 */
public class MapPojo {
    double[] centre;//中心点数组

    List<double[]> line;//路径数组

    String time; //时长

    String longs;//长度

    String[] tags;//标签

    public MapPojo() {
        this.centre = new double[2];
        this.line = new LinkedList<double[]>(){
            @Override
            public String toString() {
                Iterator<double[]> it = iterator();
                if (! it.hasNext())
                    return "[]";

                StringBuilder sb = new StringBuilder();
                sb.append('[');
                for (;;) {
                    double[] e = it.next();
                    sb.append("[");
                    sb.append(e[0]);
                    sb.append(",");
                    //System.out.println(e[1]);
                    sb.append(e[1]);
                    sb.append("]");
                    //sb.append(e == this ? "(this Collection)" : e);
                    if (! it.hasNext())
                        return sb.append(']').toString();
                    sb.append(',').append(' ');
                }
            }
        };
    }

    public double[] getCentre() {
        return centre;
    }

    public void setCentre(double[] centre) {
        this.centre = centre;
    }

    public String getLine() {
        return line.toString();
    }

    public void setLine(double[] point) {
        this.line.add(point);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLongs() {
        return longs;
    }

    public void setLongs(String longs) {
        this.longs = longs;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Mappojo{" +
                "centre=" + Arrays.toString(centre) +
                ", line=" + line +
                ", time='" + time + '\'' +
                ", longs='" + longs + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
    public String toJsonString(){
        String s ="";


        return s;
    }
}
