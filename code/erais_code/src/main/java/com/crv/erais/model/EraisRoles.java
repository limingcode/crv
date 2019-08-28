package com.crv.erais.model;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class EraisRoles extends BaseEntity implements Serializable {

    /**
     * ID 
     */
    @NotEmpty  ( message = "唯一标识 ID 不能为空")
    private String id;
    
    /**
     * 角色名称 
     */
    @NotEmpty( message = "角色名称不能为空")
    private String roleName;
    
    /**
     * 角色编码 
     */
    @NotEmpty  ( message = "角色编码不能为空")
    private String roleCode;
    
    /**
     * 父角色ID 
     */
    private String roleParent;

    /**
     * 父角色名称
     */
    private String parentRoleName;


    /**
     * 状态 1启用  2 禁用 
     */
<<<<<<< HEAD
    @NotEmpty  ( message = "状态不能为空")
    private Integer status =1;
=======
    private Integer status ;
>>>>>>> a577cdc70f21af6be6195da512eb9a8ad0a02829
    
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
     * 角色授权的菜单字符串 
     */
<<<<<<< HEAD
    private String menuAuthority;
    
=======
    @NotEmpty  ( message = "菜单字符串不能为空 ")
    private String menuAuthority;

>>>>>>> a577cdc70f21af6be6195da512eb9a8ad0a02829
    /**
     * 操作 
     */
    private String operation;
<<<<<<< HEAD
=======

    /**排序**/
    private Integer sort ;
>>>>>>> a577cdc70f21af6be6195da512eb9a8ad0a02829
    

}

