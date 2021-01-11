package com.zzh.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author Aurora
 * @Date 2021/1/8 14:11
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestServiceTest {

    @Autowired
    private TestService service;

    @Test
    public void batchImport() {
        service.batchImport();
        System.out.println("注入成功");
    }

    @Test
    public void testHeap() {
        long l1 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long l2 = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("-Xms : " + l1 + "M");
        System.out.println("-Xmx : " + l2 + "M");
        System.out.println("系统内存大小为：" + l1 * 64.0 / 1024 + "G");
        System.out.println();
    }
}
