package com.zzh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzh.entity.Test;
import com.zzh.mapper.TestMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Aurora
 * @Date 2021/1/8 15:26
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MybatisPlusTest {

    @Autowired
    private TestMapper mapper;

    @org.junit.Test
    public void testInsert() {
        Test test = new Test();
        test.setContent("Mybatis-plus测试");
        mapper.insert(test);
    }

    @org.junit.Test
    public void testUpdate() {
        Test test = mapper.selectById(2);
        test.setContent("Mybatis plus测试1");
        mapper.updateById(test);
    }

    @org.junit.Test
    public void testDelete() {
        mapper.deleteById(1);
    }

    @org.junit.Test
    public void testSelect() {
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tid", 2);
        System.out.println(mapper.selectList(queryWrapper));
    }

}
