package com.crv.erais.sys.manage.service.impl;

import com.crv.erais.common.StringUtils;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.sys.manage.mapper.DictMapper;
import com.crv.erais.sys.manage.pojo.EraisAuditEvent;
import com.crv.erais.sys.manage.pojo.EraisDict;
import com.crv.erais.sys.manage.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/25 10:32
 * 数据字典的事项逻辑
 */
@Service
public class DictServiceImpl implements DictService {
    //业务层处理
    @Autowired
    private DictMapper dictMapper;

    /**
     * 发现数据字典的父级节点
     * @param eraisDict  数据字典的ID
     * @return
     */
    @Override
    public TableDataInfo findByParentId(EraisDict eraisDict) {
        PageUtil.startPage(eraisDict);
        List<EraisDict> eraisDicts = dictMapper.findByParentId(eraisDict);
        return PageUtil.getDataTable(eraisDicts);
    }

    /**
     * 添加父级节点
     * @param eraisDict  数据字典对象
     * @return
     */
    @Override
    public int add(EraisDict eraisDict) {
        findByParentId(eraisDict);
        int row = dictMapper.add(eraisDict);
        if (row < 0) {
            return 0;
        }
        return row;
    }

    /**
     *
     *
     * @param eraisDict  数据字典对象
     * @return
     */
    @Override
    public int update(EraisDict eraisDict) {


        if (eraisDict == null)
            throw new IllegalArgumentException("修改对象不能为空！！");
        if (StringUtils.isEmpty(eraisDict.getName()))
            throw new IllegalArgumentException("修改数据字典不能为空！！");
        //持久化数据到数据库
        int row = dictMapper.update(eraisDict);

        if (row < 0) {
            return 0;
        }
        return row;
    }

    /**
     * 编辑数据字典 查询父级下所有的子集节点
     * @param eraisDict
     * @return
     */
    @Override
    public EraisDict eudit(EraisDict eraisDict) {

        List<EraisDict> list=  dictMapper.findByParentId(eraisDict);
        if (list!=null){
            List<EraisDict> list1 = dictMapper.eudit(eraisDict);

            eraisDict= list.get(0);
            eraisDict.setEraisDicts(list1);
        }
        return eraisDict;
    }


}
