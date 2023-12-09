package com.GW.JJOFFICE.JJOFFICE.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String empName;
    private String empLoginId;
    private String empLoginPw;
    private String empLoginPwChk;
    private String empSn;
    private String empPhone;
    private String empAddr;
    private String empAddrDetail;
    private String empAddrZipcode;
    private String empPhoto;
    private String useYn;
    private String regDate;
    private String regEmpSn;
    private String modDate;
    private String modEmpSn;
    private String delDate;
    public EmployeeDto(SignUpDto signUpDto) {
        this.empName = signUpDto.getEmpName();
        this.empLoginId = signUpDto.getEmpLoginId();
        this.empLoginPw = signUpDto.getEmpLoginPw();
        this.empLoginPwChk = signUpDto.getEmpLoginPwChk();
        this.empSn = signUpDto.getEmpSn();
        this.empPhone = signUpDto.getEmpPhone();
        this.empAddr = signUpDto.getEmpAddr();
        this.empAddrDetail = signUpDto.getEmpAddrDetail();
        this.empAddrZipcode = signUpDto.getEmpAddrZipcode();
        this.empPhoto = signUpDto.getEmpPhoto();
        this.regEmpSn = signUpDto.getRegEmpSn();
    }
}
