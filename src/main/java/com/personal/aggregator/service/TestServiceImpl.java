package com.personal.aggregator.service;

import com.personal.aggregator.entity.TestEntity;
import com.personal.aggregator.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {
    @Autowired
    private TestRepository testRepository;
    public void test(){
        TestEntity entity = new TestEntity();
        entity.setName("String a");
        testRepository.save(entity);
    }
}
