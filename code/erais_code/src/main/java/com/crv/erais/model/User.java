package com.crv.erais.model;

import lombok.Data;

/**
 * @author zph
 * @date 2019-08-21
 */
@Data
public class User {

    private String userAccount;//员工账号
    private String userName;
    private String password;
    private String deptName;//部门名称
    private String statusDesc;//是否在职状态描述
    private String companyName;
    private String roles;
    private String userId;
    private String jobDesc;
    private String politicDesc;
    private String mobilePhone;
    private String email;
    private String deptCode; //部门编码
    private String statusCode;//是否在职编码
}
