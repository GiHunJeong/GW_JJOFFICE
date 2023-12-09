package com.GW.JJOFFICE.JJOFFICE.auth.repository;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthRepository {
    EmployeeDto findByEmpId(@Param("emp_login_id") String empId);
}
