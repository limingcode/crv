package com.crv.erais.model;

import java.math.BigDecimal;
import java.io.Serializable;

import com.crv.erais.common.utils.Phone;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
public class EraisUsers extends BaseEntity implements Serializable {

    /**
     * ID 
     */
    @NotEmpty  ( message = "唯一标识 ID 不能为空")
    private String id;
    
    /**
     * 员工ID/LDAPID 
     */
    @NotEmpty( message = "员工ID不能为空")
    private String userId;
    
    /**
     * 姓名 
     */
    @NotEmpty  ( message = "员工姓名不能为空")
    private String userName;
    
    /**
     * 所属机构ID 
     */
    @NotEmpty  ( message = "所属机构不能为空")
    private String auditBelong;
    
    /**
     * 状态 1启用  2 禁用 
     */
    private Integer status;
    
    /**
     * 创建人 
     */
    private String createPro;
    
    /**
     * 创建时间 
     */
    private Date createTime;
    
    /**
     * 更新人 
     */
    private String updatePro;
    
    /**
     * 更新时间 
     */
    private Date updateTime;
    
    /**
     * 手机号码 
     */
    @NotEmpty  ( message = "手机号不能为空")
    @Phone
    private String phone;
    
    /**
      *岗位名称
     */
    private String jobName;
    
    /**
     * 岗位级别 
     */
    private String jobLevel;
    /**
     * 办公室电话
     */
    private String  officePhone;

    /**
     * 员工邮箱
     */
    @Email
    private String empEmail;
    /**
     * 用户所属组织机构名称
     */
    private  String depName;

    /**
     * 用户对应的角色集合
     */
    private List<EraisUsersRoles> usersRolesList;
}

