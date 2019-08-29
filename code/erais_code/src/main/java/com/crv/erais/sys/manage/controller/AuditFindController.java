package com.crv.erais.sys.manage.controller;

import com.crv.erais.common.StringUtils;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.model.common.Result;
import com.crv.erais.sys.manage.pojo.EraisAuditEvent;
import com.crv.erais.sys.manage.pojo.EraisAuditFind;
import com.crv.erais.sys.manage.service.EventFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/27 20:55
 * 审计事项的发现控制
 */
@RestController
@RequestMapping("/audit/find")
public class AuditFindController {
    //注入对应的service
    @Autowired
    private EventFindService service;

    /**
     * 查询所有的发现审计事项
     * @param eraisAuditFind  发现的对象
     * @return
     */
    @RequestMapping("list")
    public Result findEvent(EraisAuditFind eraisAuditFind) {
        TableDataInfo event = service.findEvent(eraisAuditFind);
        if (event == null) {
            throw new IllegalArgumentException("数据初始化为空！！");
        }
        return Result.success(eraisAuditFind);
    }

    /**
     * 保存审计事项保存
     *
     * @return
     */
    @RequestMapping("save")
    public Result save(EraisAuditFind eraisAuditFind) {
        int row = service.save(eraisAuditFind);

        return Result.success(eraisAuditFind);
    }
    @RequestMapping("delete")
    public Result delete(String findid) {
        int delete = service.delete(findid);
        if (delete<0){
            throw new IllegalArgumentException("记录不存在");
        }
        return Result.success("删除ok！！");
    }
    /**
     * 单独删除一条审计发现数据
     * @param findid
     * @return
     */
    @RequestMapping("deleteBatch")
    public Result deleteBatch(String findid) {
        List<String> strings = StringUtils.strSplit(findid);
        int row = service.deleteBatch(strings);
        return   Result.success("成功删除"+row);
    }

    /**
     * 发现的更新操作
     * @param finid
     * @return
     */
    @RequestMapping("update")
   public Result update(EraisAuditFind finid){
        int update = service.update(finid);
        if (update<0){
            throw  new IllegalArgumentException("更新失败！！");
        }
        return Result.success();
    }


}
