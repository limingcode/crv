package com.crv.erais.sys.manage.service;

import com.crv.erais.sys.manage.pojo.EraisAuditEvent;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 11:45
 * 审计事项管理业务操作..
 */
public interface AuditEventService {
    //审计事项接口
    int addEuditEvent(EraisAuditEvent auditEvent);
}
