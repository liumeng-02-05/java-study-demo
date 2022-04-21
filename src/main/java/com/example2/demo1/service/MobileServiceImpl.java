package com.example2.demo1.service;
import com.example2.demo1.mapper.MobileMapper;
import com.example2.demo1.model.MobileModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MobileServiceImpl implements MobileService {
    @Autowired
    private MobileMapper mobileMapper;

    @Override
    public PageInfo<MobileModel> queryAll(int pageCode, int pageSize) {
        //分页查询
        PageHelper.startPage(pageCode,pageSize);
        List<MobileModel> bookList= mobileMapper.findAll();
        PageInfo<MobileModel> pageInfo = new PageInfo<MobileModel>(bookList);

        return pageInfo;
    }
}
