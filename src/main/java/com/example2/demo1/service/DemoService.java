package com.example2.demo1.service;

import com.example2.demo1.mapper.DemoMapper;
import com.example2.demo1.model.DemoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    private DemoMapper demoMapper;

    public DemoModel get(int id) {
        return demoMapper.get(id);
    }
}
