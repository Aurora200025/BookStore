package com.zzh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzh.entity.Test;

/**
 * @Author Aurora
 * @Date 2021/1/8 13:54
 * @Version 1.0
 */
public interface TestMapper extends BaseMapper<Test> {

    public void insert();
}
