package com.crv.erais.sys.manage.service;

import com.crv.erais.sys.manage.pojo.EraisDict;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 10:31
 */
public interface DictService {
    //实现查询数据字典的接口
    List<EraisDict> findAll();
}
