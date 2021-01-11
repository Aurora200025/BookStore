package com.zzh.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzh.entity.Book;
import com.zzh.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Aurora
 * @Date 2021/1/9 13:13
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookServiceImplTest {

    @Resource
    private BookService service;

    @Test
    public void paging() {
        IPage<Book> iPage = service.paging(2L, "quantity", 0, 30);
        List<Book> list = iPage.getRecords();
        for (Book book : list) {
            System.out.println(book.getBookId() + " : " + book.getBookName());
        }
        System.out.println("总页数：" + iPage.getPages());
        System.out.println("总记录数：" + iPage.getTotal());
    }

}
