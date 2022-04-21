package com.example2.demo1.service;

import com.example2.demo1.model.MobileModel;
import com.github.pagehelper.PageInfo;

public interface MobileService {
    PageInfo<MobileModel> queryAll(int pageCode, int pageSize);
}
