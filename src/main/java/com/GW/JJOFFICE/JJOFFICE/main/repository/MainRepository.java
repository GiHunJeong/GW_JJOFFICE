package com.GW.JJOFFICE.JJOFFICE.main.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MainRepository {
    List<Map<String, Object>> getTestSelect();
    Map<String, Object> getTestOne(Map<String, Object> map);
}
