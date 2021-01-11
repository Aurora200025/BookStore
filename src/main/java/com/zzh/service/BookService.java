package com.zzh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzh.entity.Book;

/**
 * @Author Aurora
 * @Date 2021/1/9 13:01
 * @Version 1.0
 */
public interface BookService {
    /**
     * 分页查询图书
     */
    IPage<Book> paging(Long categoryId, String order, Integer page, Integer rows);

    /**
     * 根据bookId查询图书对象
     * @param bookId bookId
     * @return 图书对象
     */
    Book selectById(Long bookId);

    /**
     * 更新图书评分
     */
    public void updateEvaluation();
}
