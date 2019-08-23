package com.crv.erais.sys.manage.mapper;

import com.crv.erais.sys.manage.pojo.EraisAuditEvent;
import com.crv.erais.sys.manage.pojo.EraisDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 10:31
 */
@Mapper
public interface DictMapper {
    //执行字典的查询操作
    @Select("select dict_name,dict_code,sort,low_status,remark from ERAIS_DICT")
    List<EraisDict> findAll();
    int addEuditEvent(EraisAuditEvent auditEvent);

}
