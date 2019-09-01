package com.crv.erais.sys.manage.service;

import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.model.EraisUsers;
import com.crv.erais.sys.manage.pojo.EraisAuditEvent;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 11:45
 * 审计事项管理业务操作..
 */
public interface AuditEventService {
    //查询
    TableDataInfo selectByExample(EraisAuditEvent example);

    //新增
    int add(EraisAuditEvent event);

    //删除
    int deleteByPrimaryKey(String eventid);

    //批量删除
    int deleteBeach(List<String> ids);

    //更新对应的审计事项
    int update(EraisAuditEvent eventid);
    void updateStatus(EraisAuditEvent eraisAuditEvent);
}
