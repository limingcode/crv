package com.crv.erais.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crv.erais.model.User;
import com.crv.erais.model.common.Result;
import com.crv.erais.model.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
@RequestMapping("/crv")
public class DepController {
    @Autowired
    private RestTemplate template;

    /**
     * 查询组织机构
     * @return Result
     */
    @GetMapping("/dep/getListByParentId")
    public Result getListByParentId(@RequestParam("parentId") String parentId){
        JSONObject depResult = JSONObject.parseObject(
                template.getForObject("http://10.239.16.30:18081/upm/dept/list?parentId="+parentId,String.class));
        if (depResult.getInteger("code")==0){
            return Result.success(depResult.toJSONString());
        }else {
            return Result.failure(1,"查询组织机构失败");
        }
    }
}
