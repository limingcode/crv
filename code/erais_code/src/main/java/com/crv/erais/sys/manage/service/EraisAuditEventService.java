package com.crv.erais.sys.manage.service;

import com.crv.erais.sys.manage.pojo.EraisAuditEvent;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 11:45
 * 审计事项管理业务操作..
 */
public interface EraisAuditEventService {
    //审计事项接口
    List<EraisAuditEvent> selectAll();

    //审计事项的添加
    int insert(EraisAuditEvent record);

    //数据事项的单个删除
    public void delete(Integer id);
    public void deleteBatch(Integer[] ids);

}
