package com.crv.erais.model;

import com.crv.erais.common.tools.OrderByExpressionTool;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 实体基类
 *
 * @author jw
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 排序方式
     */
    private String isAsc;
    /**
     * 排序列
     */
    private String orderByColumn;
    public String getIsAsc() {
        return isAsc;
    }

    public void setIsAsc(String isAsc) {
        this.isAsc = isAsc;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    /**
     * 搜索值
     */
    private String searchValue;

    /**
     * 创建者名称
     */
    private String createUserName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 按创建时间--从 ****开始到 *** ----
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeBegin;
    /**
     * 按创建时间--从 ****开始到 ***结束 ----
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeEnd;

    /**
     * 按更新时间--从 ****开始到 *** ----
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTimeBegin;
    /**
     * 按更新时间--从 ****开始到 ***结束 ----
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTimeEnd;
    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 创建者名称
     */
    private String updateUserName;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 页码
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Integer pageNum;

    /**
     * 每页记录条数
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Integer pageSize;

    /**
     * 排序字段集合
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Map<String, String> orderByColumnMap;

    /**
     * 排序表达式
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String orderByExpression;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, String> getOrderByColumnMap() {
        return orderByColumnMap;
    }

    public void setOrderByColumnMap(Map<String, String> orderByColumnMap) {
        this.orderByColumnMap = orderByColumnMap;
    }

    public void setOrderByExpression(String orderByExpression) {
        this.orderByExpression = orderByExpression;
    }

    public String getOrderByExpression() {
        return OrderByExpressionTool.getOrderByExpression(getOrderByColumnMap());
    }
}

