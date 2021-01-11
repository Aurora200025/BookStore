package com.zzh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzh.entity.*;
import com.zzh.service.BookService;
import com.zzh.service.CategoryService;
import com.zzh.service.EvaluationService;
import com.zzh.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;

/**
 * @Author Aurora
 * @Date 2021/1/9 11:20
 * @Version 1.0
 * 图书控制器
 */
@Controller
public class BookController {

    @Resource
    private CategoryService categoryService;
    @Resource
    private BookService bookService;
    @Resource
    private EvaluationService evaluationService;
    @Resource
    private MemberService memberService;

    /**
     * @return 返回index.ftl页面--显示首页
     */
    @GetMapping("/")
    public ModelAndView showIndex() {
        ModelAndView mav = new ModelAndView("/index");
        List<Category> categoryList = categoryService.selectAll();
        mav.addObject("categoryList", categoryList);
        return mav;
    }

    /**
     * 分页查询图书列表
     *
     * @param p 分页号
     * @return 分页对象
     */
    @GetMapping("/books")
    @ResponseBody
    public IPage<Book> selectBook(Long categoryId, String order, Integer p) {
        if (p == null) {
            p = 1;
        }
        return bookService.paging(categoryId, order, p, 10);
    }

    @GetMapping("/book/{id}")
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    //当前方法不需要事务
    public ModelAndView showDetail(@PathVariable("id") Long id, HttpSession session) {
        Book book = bookService.selectById(id);
        List<Evaluation> evaluationList = evaluationService.selectByBookId(id);
        Member member = (Member) session.getAttribute("loginMember");
        ModelAndView mav = new ModelAndView("/detail");
        if (member != null) {
            //获取会员阅读状态
            MemberReadState memberReadState = memberService.selectMemberReadState(member.getMemberId(), id);
            mav.addObject("memberReadState", memberReadState);
        }
        mav.addObject("book", book);
        mav.addObject("evaluationList", evaluationList);
        return mav;
    }
}
