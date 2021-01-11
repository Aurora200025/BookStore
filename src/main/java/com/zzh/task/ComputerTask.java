package com.zzh.task;

import com.zzh.service.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author Aurora
 * @Date 2021/1/11 13:26
 * @Version 1.0
 * 完成数据的计算操作--定时器 完成自动计算任务
 */
@Component
public class ComputerTask {

    @Resource
    private BookService bookService;

    /**
     * 任务调度
     */
    @Scheduled(cron = "0 * * * * ?")
    public void updateEvaluation() {
        bookService.updateEvaluation();
        System.out.println("已更新所有图书评分");
    }
}
