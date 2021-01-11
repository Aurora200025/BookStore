package com.zzh.service.Impl;

import com.zzh.entity.Member;
import com.zzh.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * @Author Aurora
 * @Date 2021/1/10 13:14
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MemberServiceImplTest {

    @Resource
    private MemberService memberService;

    @Test
    public void createMember() {
        memberService.createMember("123456", "123456", "测试");

    }
}
