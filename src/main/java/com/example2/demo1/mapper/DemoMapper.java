package com.example2.demo1.mapper;

import com.example2.demo1.model.DemoModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public interface DemoMapper {
    DemoModel get(int id);
}
