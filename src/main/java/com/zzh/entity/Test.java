package com.zzh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author Aurora
 * @Date 2021/1/8 15:19
 * @Version 1.0
 */
@TableName("test1")
public class Test {

    @TableField("tid")
    @TableId(type = IdType.AUTO)
    private Integer tid;
    @TableField("content")
    private String content;

    public Test() {}
    public Test(Integer tid, String content) {
        this.tid = tid;
        this.content = content;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Test{" +
                "tid=" + tid +
                ", content='" + content + '\'' +
                '}';
    }
}
