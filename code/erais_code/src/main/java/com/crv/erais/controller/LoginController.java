package com.crv.erais.controller;

import com.alibaba.fastjson.JSONObject;
import com.crv.erais.model.User;
import com.crv.erais.model.common.Result;
import com.crv.erais.model.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zph
 * @date 2019-08-21
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private RestTemplate template;

    @GetMapping
    public Result login(String userAccount ){
       User user = new User();
        JSONObject userResult = JSONObject.parseObject(template.getForObject("http://10.239.16.30:18081/upm/login/queryUser?password=sub&userAccount="+userAccount,String.class));

        if (userResult.getInteger("code")==0){
            //登陆成功
            JSONObject userJson = userResult.getJSONObject("data");
            user.setUserAccount(userJson.getString("userAccount"));
            user.setUserName(userJson.getString("userName"));
            return Result.success(user);
        }else {
            return Result.failure(ResultCode.USER_NOT_EXIST,userResult.getString("msg"));
        }
    }
}
