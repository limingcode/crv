package com.crv.erais.sys.manage.controller;

import com.crv.erais.common.StringUtils;
import com.crv.erais.common.exception.BusinessException;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.controller.EraisBeAuditOrganController;
import com.crv.erais.model.EraisUsers;
import com.crv.erais.model.common.Result;
import com.crv.erais.sys.manage.pojo.EraisAuditEvent;
import com.crv.erais.sys.manage.service.AuditEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/27 16:59
 * 审计事项的相关操作
 */
@RequestMapping("/event/")
@RestController
public class EraisAuditEventController {
    private static final Logger logger = LoggerFactory.getLogger(EraisBeAuditOrganController.class);
    @Autowired
    private AuditEventService auditEventService;


    /**
     * 查看审计事项的列表
     * @param event
     * @return
     */
    @RequestMapping("list")
    public Result findAll(EraisAuditEvent event) {
        TableDataInfo list = auditEventService.selectByExample(event);
        if (list == null) {
            return Result.failure(201, "查询失败!!");
        }
        return Result.success(event);
    }

    /**
     * 添加审计相关控制层
     *
     * @param event 审计对象
     * @return
     */
    @RequestMapping("add")
    public Result add(EraisAuditEvent event) {
            try {
                int add = auditEventService.add(event);
                if (add < 0) {
                    return Result.failure(201, "新增失败!!");
                }
            }catch (Exception e){
                BusinessException cause  = (BusinessException) e;
                String msg = cause.getErrMsg();
                if (org.apache.commons.lang3.StringUtils.isEmpty(msg)){
                    msg = "保存失败";
                }
            }
        return Result.success(event);
    }

    /**
     *审计事项的单个删除
     * @param eventid
     * @return
     */

    @RequestMapping(value = "delete")
    public Result delete(String eventid) {
        int row = auditEventService.deleteByPrimaryKey(eventid);
        if (row < 0) {
            throw new IllegalArgumentException("记录不存在！！");
        }
        return Result.success("删除行"+row);

    }

    /**
     * 审计事项的批量删除
     * @param ids
     * @return
     */

    @GetMapping("deleteBatch")
    public Result deleteBatch(@RequestParam(value = "ids")String ids) {
        try {
            if (org.apache.commons.lang3.StringUtils.isEmpty(ids)) {
                return Result.failure(1,"请求列表为空");
            }
            List<String> idsList = StringUtils.strSplit(ids);
            auditEventService.deleteBeach(idsList);
        }catch (Exception e){
            e.getMessage();
            logger.error("删除角色失败"+e.getMessage());
            return Result.failure(1,"删除角色失败");
        }
        return Result.success();
    }

    /**
     * 审计事项发现的更新
     * @param enentid  更新发现id
     * @return
     */
    @RequestMapping("update")
    public Result update(EraisAuditEvent enentid) {
        try {
            int update = auditEventService.update(enentid);
            if (update < 0) {
                throw new IllegalArgumentException("更新异常！！！");
            }
        }catch (Exception e){
            BusinessException cause  = (BusinessException) e;
            String msg = cause.getErrMsg();
            if (org.apache.commons.lang3.StringUtils.isEmpty(msg)){
                msg = "保存失败";
            }
            return  Result.failure(1,msg);
        }


        return Result.success("更新成功！！");
    }
    @GetMapping("/updateStatus/")
    public Result updateStatus(@RequestParam("id") String id, @RequestParam("status")  int status) {
        EraisAuditEvent eraisAuditEvent = new EraisAuditEvent();
        eraisAuditEvent.setId(id);
        eraisAuditEvent.setStatus(status);
        auditEventService.updateStatus(eraisAuditEvent);

        return Result.success();
    }

}
