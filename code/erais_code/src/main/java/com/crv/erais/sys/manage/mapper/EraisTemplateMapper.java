package com.crv.erais.sys.manage.mapper;

import com.crv.erais.sys.manage.pojo.EraisTemplate;
import com.crv.erais.sys.manage.pojo.EraisTemplateExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EraisTemplateMapper {
    //查询模板列表
    List<EraisTemplate> page(EraisTemplate example);
    //新增系统模板
    int insert(EraisTemplate record);

    int countByExample(EraisTemplate example);

    int deleteByExample(EraisTemplate example);

    int deleteByPrimaryKey(Short id);



    int insertSelective(EraisTemplate record);

    List<EraisTemplate> selectByExampleWithBLOBs(EraisTemplate example);



    EraisTemplate selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") EraisTemplate record, @Param("example") EraisTemplate example);

    int updateByExampleWithBLOBs(@Param("record") EraisTemplate record, @Param("example") EraisTemplate example);

    int updateByExample(@Param("record") EraisTemplate record, @Param("example") EraisTemplate example);

    int updateByPrimaryKeySelective(EraisTemplate record);

    int updateByPrimaryKeyWithBLOBs(EraisTemplate record);

    int updateByPrimaryKey(EraisTemplate record);
}