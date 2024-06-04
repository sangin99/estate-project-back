package com.estate.back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.estate.back.dto.response.ResponseCode;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.dto.response.ResponseMessage;

import lombok.Getter;

// 로그인 Response Body DTO 
@Getter
public class SignInResponseDto extends ResponseDto {

    private String accessToken;
    private int expires;

    // '성공'에 대한 생성자
    private SignInResponseDto(String accessToken) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.accessToken = accessToken;
        this.expires = 10 * 60 * 60;    // 만료시간 초 단위 표현(시간 * 분 * 초)
    }

    public static ResponseEntity<SignInResponseDto> success (String accessToken) {
        SignInResponseDto responseBody = new SignInResponseDto(accessToken);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
}
