package com.hello.quickstart.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface QuickMapper {
    HashMap<String, Object> findById(HashMap<String, Object> paramMap);
    void regItem(HashMap<String, Object> paramMap);
}
