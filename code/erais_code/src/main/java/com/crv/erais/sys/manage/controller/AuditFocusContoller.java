package com.crv.erais.sys.manage.controller;

import com.crv.erais.common.StringUtils;
import com.crv.erais.model.common.Result;
import com.crv.erais.sys.manage.pojo.EraisAuditFocus;
import com.crv.erais.sys.manage.service.EventFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/28 10:29
 * 审计事项关注点控制用户的请求
 */
@RestController
@RequestMapping("/audit/focus/")
public class AuditFocusContoller {
    //注入审计关注点service
    @Autowired
    private EventFocusService eventFocusService;

    /**
     * 新增审计事项
     * @param eraisAuditFocus
     * @return
     */
    @RequestMapping("save")
    public Result save(EraisAuditFocus eraisAuditFocus){
        int save = eventFocusService.save(eraisAuditFocus);
        return Result.success(eraisAuditFocus);
    }

    /**
     * 批量删除
     * @param findid
     * @return
     */
    @RequestMapping("deleteBatch")
    public Result deleteBatch(String findid) {
        List<String> strings = StringUtils.strSplit(findid);
        int row = eventFocusService.deleteBatch(strings);
        return   Result.success("成功删除"+row);
    }

    /**
     * 更新操作
     * @param eraisAuditFocus
     * @return
     */
    @RequestMapping("update")
    public Result update(EraisAuditFocus eraisAuditFocus){
        //更新审计关注
        int update = eventFocusService.update(eraisAuditFocus);
        if (update<0){
            throw  new IllegalArgumentException("更新失败！！");
        }
        return Result.success();
    }
    @RequestMapping("delete")
    public Result delete(String focusid) {
        List<String> strings = StringUtils.strSplit(focusid);
        int row = eventFocusService.delete(focusid);
        return   Result.success("成功删除"+row);
    }



}
