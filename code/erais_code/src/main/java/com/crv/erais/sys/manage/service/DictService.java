package com.crv.erais.sys.manage.service;

import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.sys.manage.pojo.EraisDict;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 10:31
 * 数据字典的service
 */
public interface DictService {
    //查询父级节点
    TableDataInfo findByParentId(EraisDict eraisDict);

    //新增
    int add(EraisDict eraisDict);

    //修改
    int update(EraisDict eraisDict);

    //编辑
    EraisDict eudit(EraisDict eraisDict);

}
