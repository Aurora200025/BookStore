package com.zzh.service.Impl;

import com.zzh.entity.Evaluation;
import com.zzh.service.EvaluationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;


/**
 * @Author Aurora
 * @Date 2021/1/10 11:46
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EvaluationServiceImplTest {

    @Resource
    private EvaluationService evaluationService;

    @Test
    public void selectByBookId() {
        List<Evaluation> list = evaluationService.selectByBookId(1L);
        for (Evaluation evaluation : list) {
            System.out.println(evaluation);
        }
    }
}
