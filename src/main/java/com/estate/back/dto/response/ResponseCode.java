package com.estate.back.dto.response;

// 200 성공 : SU / Success.
// 400 필수 데이터 미입력 : VF / Validation Failed.
// 400 중복된 아이디 : DI / Duplicated Id.
// 400 중복된 이메일 : DE / Duplicated Email.
// 401 로그인 정보 불일치 : SF / Sign in Failed.
// 401 인증 실패 : AF / Authentication Failed.
// 500 토큰 생성 실패 : TF / Token creation Failed.
// 500 이메일 전송 실패 : MF / Mail send  Failed.
// 500 데이터베이스 오류 : DBE / Database Error.

// Response 의 공통된 Code 값
public interface ResponseCode {
    String SUCCESS = "SU";
    String VALIDATION_FAILED = "VF";
    String DUPLICATED_ID = "DI";
    String DUPLICATED_EMAIL = "DE";
    String NO_EXIST_BOARD = "NB";
    String WRITTEN_COMMENT = "WC";
    String SIGN_IN_FAILED = "SF";
    String AUTHENTICATION_FAILED = "AF";
    String AUTHORIZATION_FAILED = "AF";
    String NOT_FOUND = "NF";
    String TOKEN_CREATION_FAILED = "TF";
    String MAIL_SEND_FAILED = "MF";
    String DATABASE_ERROR = "DBE";
}
