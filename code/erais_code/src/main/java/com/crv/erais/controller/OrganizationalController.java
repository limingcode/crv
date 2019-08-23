package com.crv.erais.controller;

import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.model.Organizational;
import com.crv.erais.model.common.Result;
import com.crv.erais.service.OrganizationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取组织机构
 */
@RestController
@RequestMapping("/crv/organizational")
public class OrganizationalController {
    /**
     * jw
     */
    @Autowired
	private OrganizationalService orgService;

    /**
     * 查询所有信息。
     * @return Result
     */
    @GetMapping("/getList")
    public Result getList( ){
    	List<Organizational> list = orgService.getListOrg();
        return Result.success(list);
    }
    /**
     * 分页查询
     * @param pageSize 数量
     * @param pageNum  页码数
     * @return Result
     */
    @GetMapping("/pageList")
    public Result pageList(@RequestParam(value="pageSize" ) int pageSize, @RequestParam(value="pageNum") int pageNum ){
        Organizational org = new Organizational();
        org.setPageNum(pageNum);
        org.setPageSize(pageSize);
        TableDataInfo info =  orgService.pageList(org);
        return Result.success(info);
    }
}

