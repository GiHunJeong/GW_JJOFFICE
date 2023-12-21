package com.GW.JJOFFICE.JJOFFICE.admin.employee.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    int getEmployeeListTotal(Map<String, Object> map);
    /**
     * 어드민 사원 목록 조회
     * @return
     */
    List<Map<String, Object>> getEmployeeList(Map<String, Object> map);
}
