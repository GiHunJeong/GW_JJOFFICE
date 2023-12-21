package com.GW.JJOFFICE.JJOFFICE.admin.employee.service.Impl;

import com.GW.JJOFFICE.JJOFFICE.admin.employee.repository.EmployeeRepository;
import com.GW.JJOFFICE.JJOFFICE.admin.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    @Override
    public int getEmployeeListTotal(Map<String, Object> map) {
        return employeeRepository.getEmployeeListTotal(map);
    }

    @Override
    public List<Map<String, Object>> getEmployeeList(Map<String, Object> map) {
        return employeeRepository.getEmployeeList(map);
    }

    @Override
    public String setEmployeeOneDel(Map<String, Object> map) {
        String result = "";
        try {
            employeeRepository.setEmployeeOneDel(map);
            result = "정상적으로 삭제 되었습니다.";
        } catch (Exception e) {
            result = "삭제에 실패했습니다.";
        }
        return result;
    }
}
