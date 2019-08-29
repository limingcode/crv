package com.crv.erais.sys.manage.controller;

import com.crv.erais.common.StringUtils;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.model.common.Result;
import com.crv.erais.sys.manage.common.JsonResult;
import com.crv.erais.sys.manage.pojo.EraisAuditEvent;
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
 * 字典相关控制
 */
@RestController
@RequestMapping("/dict/")
public class DictController {
    //数据字典接口
    @Autowired
    private DictService dictService;

    /**
     * 查看数据字典列表 只显示父级节点信息
     * @param eraisDict  父级对象
     * @return
     */
    @RequestMapping("list")
    public TableDataInfo findByParentId(EraisDict eraisDict){
       TableDataInfo byParentId = dictService.findByParentId(eraisDict);

        return byParentId;
    }

    /**
     * 新增父级节点对象
     * @param eraisDict  数据字典对象
     * @return
     */

    @RequestMapping("save")
    public Result add(EraisDict eraisDict){

        int add = dictService.add(eraisDict);

        if (add<0){
            return Result.failure(201,"新增失败！！");
        }
       return Result.success(eraisDict);

    }

    /**
     * 编辑更新数据字典
     * @param eraisDict  更新对象
     * @return
     */
    @RequestMapping("update")
    public Result update(EraisDict eraisDict){
        int update = dictService.update(eraisDict);
        if (update<0)
            throw new IllegalArgumentException("更改字典失败!!");
        if (StringUtils.isNull(eraisDict))
            throw new IllegalArgumentException("更改对象不能为空！！");
        return Result.success(eraisDict);
    }

    /**
     * 查询父节点的下的所有子节点
     * @param eraisDict  子节点对象
     * @return
     */
    @RequestMapping("eudit")
    public Result eudit(EraisDict eraisDict){
          EraisDict list =dictService.eudit(eraisDict);
       return Result.success(list);

    }


}
