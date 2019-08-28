package com.crv.erais.model;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;

@Data
public class EraisUsersRoles extends BaseEntity implements Serializable {

    /**
     * 唯一编码 
     */
    private String id;
    
    /**
     * 用户ID 
     */
    private String userId;
    
    /**
     * 角色ID 
     */
    private String roleId;
    

}

