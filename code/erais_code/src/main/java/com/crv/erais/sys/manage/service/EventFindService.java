package com.crv.erais.sys.manage.service;

import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.sys.manage.pojo.EraisAuditFind;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/27 20:49
 * 审计发现service接口
 */
public interface EventFindService {
    //审计发现的列表
    TableDataInfo findEvent(EraisAuditFind example);

    //新增
    int save(EraisAuditFind eraisAuditFind);

    //删除单个
    int delete(String findid);

    //批量删除
    int deleteBatch(@Param("ids") List<String> ids);

    //更新操作
    int update(EraisAuditFind eraisAuditFind);

}
