package com.crv.erais.sys.manage.service.impl;

import com.crv.erais.sys.manage.mapper.DictMapper;
import com.crv.erais.sys.manage.pojo.EraisDict;
import com.crv.erais.sys.manage.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 10:32
 */
@Service
public class DictServiceImpl implements DictService {
    //业务层处理
    @Autowired
    private DictMapper dictMapper;
    /*
    执行查询数据字典的业务操作
     */
    @Override
    public List<EraisDict> findAll() {
        //调用mapper的接口
        List<EraisDict> dictList = dictMapper.findAll();
        return dictList;
    }
}
