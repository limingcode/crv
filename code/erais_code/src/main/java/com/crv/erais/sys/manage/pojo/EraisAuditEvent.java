package com.crv.erais.sys.manage.pojo;

import lombok.Data;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 11:37
 */
@Data
public class EraisAuditEvent {
    /**
     * "number" VARCHAR2(32 BYTE) NULL ,
     * "audit_event" VARCHAR2(255 BYTE) NULL ,
     * "event_class" VARCHAR2(255 BYTE) NULL ,
     * "apply_project" VARCHAR2(255 BYTE) NULL ,
     * "apply_monad" VARCHAR2(255 BYTE) NULL ,
     * "monad_level" VARCHAR2(255 BYTE) NULL ,
     * "must_project" VARCHAR2(255 BYTE) NULL ,
     * "manage_class" VARCHAR2(255 BYTE) NULL ,
     * "status" VARCHAR2(32 BYTE) NULL,
     * "remark" VARCHAR2(32 BYTE) NULL
     */
    //流水号
    private String number;
    //审计事项
    private String auditEvent;
    //审计事项分类
    private String eventClass;
    //适用项目类型
    private String applyProject;
    //适用单位
    private String applyMonad;
    //被审单位层级
    private String monadLevel;
    //是否必审项
    private String mustProject;
    //风险管理分类
    private String manageClass;
    //启用状态
    private String status;
    //备注
    private String remark;
}
