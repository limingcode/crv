package com.crv.erais.sys.manage.mapper;

import com.crv.erais.sys.manage.pojo.EraisAuditFind;
import com.crv.erais.sys.manage.pojo.EraisAuditFindExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 审计发现业务逻辑接口mapper
 */
@Mapper
public interface EraisAuditFindMapper {
    //保存
    int save(EraisAuditFind record);

    //发现事项
    List<EraisAuditFind> findEvent(EraisAuditFind record);

    //删除发现事项
    int delete(String findid);

    //批量删除
    int deleteBatch(@Param("ids") List<String> ids);

    List<EraisAuditFind> selectByExample(EraisAuditFindExample example);

    //更新操作
    int update(EraisAuditFind eraisAuditFind);

}