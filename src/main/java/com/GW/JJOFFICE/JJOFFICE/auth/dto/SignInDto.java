package com.GW.JJOFFICE.JJOFFICE.auth.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    private String empLoginId;
    private String empLoginPw;
    public SignInDto(EmployeeDto employeeDto) {
        this.empLoginId = employeeDto.getEmpLoginId();
        this.empLoginPw = employeeDto.getEmpLoginPw();
    }
}
