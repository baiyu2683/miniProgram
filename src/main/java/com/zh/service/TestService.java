package com.zh.service;

import com.zh.domain.TestPO;
import com.zh.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zh2683
 */
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    @Cacheable()
    List<TestPO> listAll() {
        return testMapper.listAll();
    }
}
