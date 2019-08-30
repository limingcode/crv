package com.crv.erais.sys.manage.controller;

import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.common.utils.UUIDUtils;
import com.crv.erais.model.common.Result;
import com.crv.erais.sys.manage.pojo.EraisTemplate;
import com.crv.erais.sys.manage.service.EraisTemplateService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/29 20:40
 * 模板管理类型控制器
 */
@RestController
@RequestMapping("/template/")
public class EraisTemplateController {

    private static final Logger logger = LoggerFactory.getLogger(EraisTemplateController.class);
   @Autowired
    private EraisTemplateService eraisTemplateService;
   @RequestMapping("page")
    public Result getLsit(EraisTemplate eraisTemplate){

       TableDataInfo page = eraisTemplateService.page(eraisTemplate);
       if(page!=null){
           Result.success(page);
       }
       return Result.success(page);

   }

    /**
     * 系统模板的保存新增
     * @param eraisTemplate
     * @return
     */
    @RequestMapping("save")
    public Result save(EraisTemplate eraisTemplate){
        String s=UUIDUtils.getUUID();
        eraisTemplate.setId(s);
        int insert = eraisTemplateService.insert(eraisTemplate);
        return  Result.success("成功插入："+insert);
    }
}
