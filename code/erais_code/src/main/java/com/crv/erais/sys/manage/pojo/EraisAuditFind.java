package com.crv.erais.sys.manage.pojo;

import com.crv.erais.model.BaseEntity;
import lombok.Data;

/**
 *审计发现的实体类
 */
@Data
public class EraisAuditFind extends BaseEntity {
    //审计事项发现ID
    private String find;
    //审计事项发现性质
    private String nature;
    //审计事项分析
    private String analys;
    //审计事项发现影响
    private String risk;
    //审计事项发现
    private String recommend;
    //审计事项发现备注
    private String remark;
    //审计事项发现流水号
    private String numbber;
    //审计事项发现ID
    private String findid;
    //审计事项ID
    private String eventId;


}