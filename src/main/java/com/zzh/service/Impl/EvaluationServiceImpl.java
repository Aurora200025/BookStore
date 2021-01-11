package com.zzh.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzh.entity.Book;
import com.zzh.entity.Evaluation;
import com.zzh.entity.Member;
import com.zzh.mapper.BookMapper;
import com.zzh.mapper.EvaluationMapper;
import com.zzh.mapper.MemberMapper;
import com.zzh.service.BookService;
import com.zzh.service.EvaluationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Aurora
 * @Date 2021/1/10 11:30
 * @Version 1.0
 */
@Service("evaluationService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class EvaluationServiceImpl implements EvaluationService {

    @Resource
    private EvaluationMapper evaluationMapper;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Evaluation> selectByBookId(Long bookId) {
        Book book = bookMapper.selectById(bookId);
        QueryWrapper<Evaluation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_id", bookId);
        queryWrapper.eq("state", "enable");
        queryWrapper.orderByDesc("create_time");
        List<Evaluation> evaluationList = evaluationMapper.selectList(queryWrapper);
        for (Evaluation evaluation : evaluationList) {
            Member member = memberMapper.selectById(evaluation.getMemberId());
            evaluation.setMember(member);
            evaluation.setBook(book);
        }
        return evaluationList;
    }
}
