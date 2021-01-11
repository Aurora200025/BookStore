package com.zzh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzh.entity.Book;

/**
 * @Author Aurora
 * @Date 2021/1/9 13:00
 * @Version 1.0
 */
public interface BookMapper extends BaseMapper<Book> {
    /**
     * 更新图书评分
     */
    public void updateEvaluation();
}
