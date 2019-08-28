package com.crv.erais.sys.manage.mapper;

import com.crv.erais.sys.manage.pojo.EraisAuditEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuditEventMapper {
    //查询所有的审计事项
    List<EraisAuditEvent> selectAll();
    int countByExample(EraisAuditEvent event);
    //新增审计事项
    int insert(EraisAuditEvent record);
    //数据事项的单个删除
    public void delete(Integer id);
    public void deleteBatch(Integer[] ids);
}