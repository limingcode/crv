package com.crv.erais.model;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class EraisPlan extends BaseEntity implements Serializable {

    /**
     * 主键ID 
     */
    private String id;
    
    /**
     * 计划名称 
     */
    @NotEmpty( message = "计划名称不能为空")
    private String planName;
    
    /**
     * 计划编号 
     */
    @NotEmpty( message = "计划编码不能为空")
    private String planCode;
    
    /**
     * 计划类型 
     */
    @NotEmpty( message = "计划类型不能为空")
    private String type;
    
    /**
     * 年份 
     */
    @NotEmpty( message = "年份不能为空")
    private String year;
    
    /**
     * 审核状态 1：草稿,2：待审核，3：已审核 
     */
    private Integer status;
    
    /**
     * 创建人 
     */
    private String createPro;
    
    /**
     * 维护人 
     */
    @NotEmpty( message = "维护不能为空")
    private String maintainPeople;
    
    /**
     * 维护人ID 
     */
    private String maintainPeopleId;
    
    /**
     * 创建时间/维护时间 
     */
    private Date createTime;
    
    /**
     * 更新时间 
     */
    private Date updateTime;
    

}

