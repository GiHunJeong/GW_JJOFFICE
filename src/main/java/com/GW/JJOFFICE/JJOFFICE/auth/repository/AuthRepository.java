package com.GW.JJOFFICE.JJOFFICE.auth.repository;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuthRepository {
    EmployeeDto findByEmpId(String empId);
}
