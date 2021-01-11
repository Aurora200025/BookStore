package com.zzh.service;

import com.zzh.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Aurora
 * @Date 2021/1/8 14:09
 * @Version 1.0
 */

@Service
public class TestService {

    @Autowired
    private TestMapper mapper;

    @Transactional
    public void batchImport() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
//                throw new RuntimeException("预期外异常");
            }
            mapper.insert();
        }
    }
}
