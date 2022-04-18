package com.example2.demo1.controller;

import com.example2.demo1.common.BaseResult;
import com.example2.demo1.exceptions.MyException;
import com.example2.demo1.model.DemoModel;
import com.example2.demo1.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type2")
public class demo {
    @Autowired
    DemoService demoService;

    @RequestMapping("/demo")
    public DemoModel index(int id) {
        DemoModel testModel = demoService.get(id);
        return testModel;
    }

    @GetMapping("/test")
    public BaseResult test() {
        int[] arr = {1,2,4};
        return BaseResult.success("获取接口成功",arr);
    }

    @GetMapping("/demoError")
    public void testExt() {
        throw  new MyException();
    }

}
