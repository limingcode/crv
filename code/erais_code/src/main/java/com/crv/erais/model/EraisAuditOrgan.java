package com.crv.erais.model;

import com.crv.erais.common.utils.Excel;
import com.crv.erais.common.utils.Phone;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Data
public class EraisAuditOrgan extends BaseEntity{
    @NotEmpty  ( message = "唯一标识 ID 不能为空")
    private String id;
    @Excel(column = "A", name = "审计机构")
    @NotEmpty  ( message = "审计机构不能为空")
    private String name;
    @Excel(column = "G", name = "负责人ID")
    @NotEmpty  ( message = "负责人ID 不能为空")
    private String chargeId;
    @Excel(column = "F", name = "负责人")
    @NotEmpty  ( message = "负责人不能为空")
    private String charge;
    @Excel(column = "E", name = "上级机构")
    private String topOrganId;
    @NotEmpty  ( message = "手机号码不能为空")
    @Excel(column = "H", name = "电话")
    @Phone
    private String phone;
    @Excel(column = "D", name = "禁用启用")
    private Integer status = 1;// 1启用 2：禁用

    private String createPro;
    @Excel(column = "C", name = "排序")
    private Integer sort;
    @Excel(column = "B", name = "编码")
    @NotEmpty( message = "编码不能为空")
    private String code;

    private Date createTime;

    private String updatePro;

    private Date updateTime;

}
