package com.GW.JJOFFICE.JJOFFICE.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
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
    private String regEmpSn;
    private String role;
}
