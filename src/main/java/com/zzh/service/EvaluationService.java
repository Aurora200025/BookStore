package com.zzh.service;

import com.zzh.entity.Evaluation;

import java.util.List;

/**
 * @Author Aurora
 * @Date 2021/1/10 11:28
 * @Version 1.0
 */
public interface EvaluationService {
    /**
     * 按照图书编号查询有效短评
     * @param bookId 图书编号
     * @return 评论列表
     */
    List<Evaluation> selectByBookId(Long bookId);
}
