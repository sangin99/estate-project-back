package com.estate.back.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.estate.back.dto.response.ResponseDto;

// Request 의 데이터 유효성 검사에서 발생하는 예외 처리 (Controller 작업 중 발생하는 예외 처리)

@RestControllerAdvice
public class CustomExceptionHandler {
    
    // RequestBody 의 데이터 유효성 검사 중 발생하는 예외 핸들링
    // - MethodArgumentNotValidException : 유효하지 않는 데이터
    // - HttpMessageNotReadableException : RequestBody 가 없어서 유효성 검사를 못할 때
    @ExceptionHandler({
        MethodArgumentNotValidException.class,
        HttpMessageNotReadableException.class
    })
    public ResponseEntity<ResponseDto> validationExceptionHandler(
        Exception exception
    ) {
        exception.printStackTrace();
        return ResponseDto.validationFailed();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ResponseDto> noHandlerFoundExceptionHandler(
        Exception exception
    ) {
        exception.printStackTrace();
        return ResponseDto.notFound();

    }
}
