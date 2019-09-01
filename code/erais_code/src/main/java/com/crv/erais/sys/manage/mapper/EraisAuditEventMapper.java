package com.crv.erais.sys.manage.mapper;

import com.crv.erais.sys.manage.pojo.EraisAuditEvent;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiMing
 *  审计事项相关接口mapper实现
 */
@Mapper
public interface EraisAuditEventMapper {
    //查询所有
    List<EraisAuditEvent> selectByExample(EraisAuditEvent example);
    //删除审计事项
    int deleteByPrimaryKey(String eventid);
    //批量删除审计事项
    int deleteBatch(@Param("ids")List<String> ids);
    //添加审计事项以及关联的
    int add(EraisAuditEvent record);
    //更新操作
    int update(EraisAuditEvent eraisAuditEvent);
    void updateStatus(EraisAuditEvent eraisAuditEvent);

}