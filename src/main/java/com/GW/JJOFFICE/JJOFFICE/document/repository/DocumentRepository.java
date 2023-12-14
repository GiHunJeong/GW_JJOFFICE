package com.GW.JJOFFICE.JJOFFICE.document.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface DocumentRepository {
    int getDocBoxTotal(Map<String, Object> map);
    List<Map<String, Object>> getDocBoxList(Map<String, Object> map);
    Map<String, Object> getDocInfoOne(String docSn);
}
