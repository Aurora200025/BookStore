package com.zzh.service.Impl;

import com.zzh.entity.Category;
import com.zzh.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Aurora
 * @Date 2021/1/9 11:14
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CategoryServiceImplTest {

    @Resource
    private CategoryService service;


    @Test
    public void testSelectAll() {
        List<Category> list = service.selectAll();
        System.out.println(list);
    }
}
