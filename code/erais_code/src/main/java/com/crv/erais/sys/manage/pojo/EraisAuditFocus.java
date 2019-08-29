package com.crv.erais.sys.manage.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author LiMing
 * 审计关注点实体
 */
@Data
public class EraisAuditFocus {
    //关注流水号
    private String numbber;
    //关注点
    private String focus;
    //关注系统
    private String system;
    //关注时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date issuetime;
    //
    private String regimedigest;
    //关注ID
    private String focusid;
    //关注事项的ID
    private String eventId;


}