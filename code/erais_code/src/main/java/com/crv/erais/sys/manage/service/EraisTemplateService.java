package com.crv.erais.sys.manage.service;

import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.sys.manage.pojo.EraisTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/29 20:34
 * 系统模板的相关业务接口
 *
 */

public interface EraisTemplateService {
   //分页查询系统模板
   TableDataInfo page(EraisTemplate example);
   //新增系统模板
   int insert(EraisTemplate record);
}
