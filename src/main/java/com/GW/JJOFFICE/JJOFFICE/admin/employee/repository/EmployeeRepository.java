package com.GW.JJOFFICE.JJOFFICE.admin.employee.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface EmployeeRepository {
    int getEmployeeListTotal(Map<String, Object> map);
    List<Map<String, Object>> getEmployeeList(Map<String, Object> map);
    void setEmployeeOneDel(Map<String, Object> map);
}
