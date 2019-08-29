package com.crv.erais.sys.manage.mapper;

import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.sys.manage.pojo.EraisAuditEvent;
import com.crv.erais.sys.manage.pojo.EraisDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 10:31
 * 随意的mapper接口
 */
@Mapper
public interface DictMapper {
    //执行字典的查询父节点操作
    List<EraisDict> findByParentId(EraisDict eraisDict);
    //新增父节点ID
     int add(EraisDict eraisDict);
     //编辑处理数据字典
    int update(EraisDict eraisDict);
    //编辑
    List<EraisDict> eudit(EraisDict eraisDict);


}
