package com.crv.erais.sys.manage.pojo;

import com.crv.erais.model.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * 审计数据字典实体类
 */
@Data
public class EraisDict extends BaseEntity {
    //字典名称
    private String name;
    //字典编码
    private String code;
    //字典排序
    private String sort;
    //字典状态
    private String status;
    //字典备注
    private String remark;
    //字典id
    private String id;
    //字典上级ID
    private String parentid;
    //关联子节点的信息
    private List<EraisDict> eraisDicts;
}