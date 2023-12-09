package com.GW.JJOFFICE.JJOFFICE.admin.service;

import java.util.List;
import java.util.Map;

public interface AdminPageService {
    /**
     * 어드민 사원 목록 조회
     * @return
     */
    List<Map<String, Object>> getEmployeeList();
}
