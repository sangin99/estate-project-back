package com.estate.back.repository.resultSet;

public interface GetLocalDataResultSet {
    // 조회 결과를 받을 수 있는
    String getYearMonth();
    Integer getSale();
    Integer getLease();
    Integer getMonthRent();
}

// 해당하는 속성 값을 JPA 가 스스로 만든다(생성자 , setter) > get'' 을 통해 가져올 수 있다! 