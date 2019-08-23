package com.crv.erais.sys.manage.pojo;

import lombok.Data;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 10:20
 */
@Data
public class EraisDict {
    /**
     * "dict_name" VARCHAR2(255 BYTE) NULL ,
     * "dict_code" VARCHAR2(255 BYTE) NULL ,
     * "sort" VARCHAR2(255 BYTE) NULL ,
     * "low_status" NUMBER NULL ,
     * "remark" NUMBER NULL
     */
    //字典项名称
    private String dictName;
    //字典项编码
    private String dictCode;
    //排序
    private String sort;
    //是否是最低级
    private String low_status;
    //备注
    private String remark;



}
