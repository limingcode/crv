package com.crv.erais.model;

import lombok.Data;

import java.util.Date;
@Data
public class EraisAuditOrgan extends BaseEntity{
    private String id;

    private String name;

    private String chargeId;

    private String charge;

    private String topOrganId;

    private String phone;

    private Integer status;

    private String createPro;

    private Integer sort;

    private String code;

    private Date createTime;

    private String updatePro;

    private Date updateTime;

}
