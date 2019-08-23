package com.crv.erais.sys.manage.controller;

import com.crv.erais.sys.manage.pojo.EraisDict;
import com.crv.erais.sys.manage.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 11:16
 */
@RestController
@RequestMapping("/dict/")
public class DictController {
    //数据字典接口
    @Autowired
    private DictService dictService;
    /*
    控制器的处理 数据字典
     */
    @RequestMapping("findAll")
    public List<EraisDict> findAll(){
        List<EraisDict> dictList = dictService.findAll();
        return dictList;
    }

}
