package com.GW.JJOFFICE.JJOFFICE.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "set")
public class ResponseDto<D> {
    private boolean result;
    private String message;
    private D data;
    public static <D> ResponseDto<D> setSuccess(String message, D data) {
        //return new ResponseDto<D>(true, message, data); staticName 을 붙이지 않았을 경우
        return ResponseDto.set(true, message, data);
    }
    public static <D> ResponseDto<D> setFailed(String message) {
        return ResponseDto.set(false, message, null);
    }
}
