// 배포에서 볼 때, 눈으로 보기 위한 컨트롤러

package com.estate.back.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @Value("${deploy.env}")
    private String DEPLOY_ENV;

    @GetMapping("/")
    public String serverCheck() {
        return DEPLOY_ENV + "환경에서 실행 중...";
    }

}
