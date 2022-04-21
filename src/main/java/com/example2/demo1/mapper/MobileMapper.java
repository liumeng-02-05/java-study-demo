package com.example2.demo1.mapper;

import com.example2.demo1.model.MobileModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MobileMapper  {
    List<MobileModel> findAll();
}
