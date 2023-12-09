package com.GW.JJOFFICE.JJOFFICE.admin.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface AdminPageRepository {
    List<Map<String, Object>> getEmployeeList();
}
