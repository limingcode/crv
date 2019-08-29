package com.crv.erais.sys.manage.pojo;

import com.crv.erais.model.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * 审计事项实体类
 */
@Data
public class EraisAuditEvent extends BaseEntity {
    //审计事项ID
    private String eventid;
    //审计事项流水号
    private String numberr;
    //审计事项事件
    private String event;
    //审计事项类型
    private String classs;
    //审计事项项目
    private String project;
    //审计单位
    private String monad;
    //审计单位级别
    private String monadlevel;
    //是否是必审项目
    private String mustproject;
    //管理分类
    private String manageclas;
    //审计事项状态
    private String status;
    //审计事项备注
    private String remark;
    //审计事项发现点
    private List<EraisAuditFind> eraisAuditFindList;
    //审计事项关注点
    private List<EraisAuditFocus> leraisAuditFocuList;

}