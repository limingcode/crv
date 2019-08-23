package com.crv.erais.controller;

import com.crv.erais.model.common.Result;
import com.crv.erais.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zph
 * @date 2019-08-21
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public Result testList(){
       return Result.success(testService.testList());
    }
}
