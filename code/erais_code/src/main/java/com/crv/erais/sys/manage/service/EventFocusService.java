package com.crv.erais.sys.manage.service;

import com.crv.erais.sys.manage.pojo.EraisAuditFocus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/28 10:25
 * 审计关注点的service
 */
public interface EventFocusService {
    //审计关注添加
    int save(EraisAuditFocus eraisAuditFocus);

    //删除单条ID
    int delete(String focusid);

    //批量删除审计关注点
    int deleteBatch(List<String> ids);

    //更新
    int update(EraisAuditFocus eraisAuditFocus);

}
