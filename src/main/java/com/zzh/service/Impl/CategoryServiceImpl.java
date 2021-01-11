package com.zzh.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzh.entity.Category;
import com.zzh.mapper.CategoryMapper;
import com.zzh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.java2d.cmm.CMSManager;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Aurora
 * @Date 2021/1/9 11:10
 * @Version 1.0
 */
@Service("categoryService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper mapper;

    /**
     * @return 查询所有图书分类
     */
    @Override
    public List<Category> selectAll() {
        return mapper.selectList(new QueryWrapper<>());
    }
}
