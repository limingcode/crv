package com.crv.erais.sys.manage.mapper;

import com.crv.erais.sys.manage.pojo.EraisAuditFocus;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiMing
 * 审计关注点的业务逻辑mapper
 */
@Mapper
public interface EraisAuditFocusMapper {
    //保存
    int save(EraisAuditFocus record);
    int delete(String focusid);
    //批量删除
    int deleteBatch(@Param("ids") List<String> ids);

    //修改
    int update(EraisAuditFocus eraisAuditFocus);

    //查询对象
    List<EraisAuditFocus> selectByExample(EraisAuditFocus example);
}