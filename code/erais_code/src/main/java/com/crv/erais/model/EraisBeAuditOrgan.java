package com.crv.erais.model;

import java.math.BigDecimal;
import java.io.Serializable;

import com.crv.erais.common.utils.Excel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 被审计机构
 */
@Data
public class EraisBeAuditOrgan extends BaseEntity implements Serializable{

    /**
     * id 
     */
    @NotEmpty  ( message = "唯一标识 ID 不能为空")
    private String id;
    
    /**
     * topDepartmentId 
     */
    @NotEmpty  ( message = "上级部门ID 不能为空")
    private String topDepartmentId;
    /**
     * 上级部门名称
     */
    @Excel(column = "A", name = "上级部门名称")
    private String topDepartmentName;
    /**
     * departmentName 
     */
    @Excel(column = "B", name = "部门名称")
    @NotEmpty  ( message = "部门名称不能为空")
    private String departmentName;
    
    /**
     * status 
     */
    @Excel(column = "D", name = "状态")
    @NotEmpty  ( message = "状态不能为空")
    private Integer status;
    
    /**
     * createPro 
     */
    private String createPro;
    
    /**
     * sort 
     */
    @NotEmpty  ( message = "排序不能为空")
    @Excel(column = "E", name = "排序")
    private Integer sort;
    
    /**
     * code 
     */
    @Excel(column = "C", name = "部门编号")
    private String code;
    
    /**
     * createTime 
     */
    private Date createTime;
    
    /**
     * updatePro 
     */
    private String updatePro;
    
    /**
     * updateTime 
     */
    private Date updateTime;
    
    /**
     * dataSource
     * 默认为ERAIS 系统
     */
    @NotEmpty( message = "数据来源不能为空")
    private String dataSource;
    

}

