package com.crv.erais.sys.manage.controller;

import com.crv.erais.sys.manage.common.JsonResult;
import com.crv.erais.sys.manage.pojo.EraisAuditEvent;
import com.crv.erais.sys.manage.service.EraisAuditEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 15:52
 * 设计事项的实现业务逻辑
 */
@RestController
@RequestMapping("/audit/event/")
public class AuditEventController {
//    @Autowired
//    Autowiredprivate EraisAuditEventService eraisAuditEventService;
//    @RequestMapping("selectAll")
//    public List<EraisAuditEvent> selectAll(){
//               return eraisAuditEventService.selectAll();
//    }
//    @RequestMapping(value = "add")
//    public JsonResult add(EraisAuditEvent event){
//        int row = eraisAuditEventService.insert(event);
//        if (row<0){
//            throw new IllegalArgumentException("新增审计事项失败！！");
//        }
//        return new JsonResult("新增审计事项成功");
//    }
//
//    //审计事项的单个删除
//    @ResponseBody
//    @RequestMapping("delete/{id}")
//    public void delete(@PathVariable Integer id) {
//        eraisAuditEventService.delete(id);
//    }
//    //审计事项的批量删除
//    @ResponseBody
//    @RequestMapping("delete/{ids}")
//    public JsonResult deletes(@PathVariable Integer[] ids) {
//        //前端传送一个用逗号隔开的id字符串，后端用数组接收，springMVC就可以完成自动转换成数组
//        eraisAuditEventService.deleteBatch(ids);
//        return new JsonResult(ids);
//
//    }


}
