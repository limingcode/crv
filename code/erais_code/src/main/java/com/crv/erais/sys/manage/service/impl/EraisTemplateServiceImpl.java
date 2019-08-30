package com.crv.erais.sys.manage.service.impl;

import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.common.utils.UUIDUtils;
import com.crv.erais.sys.manage.mapper.EraisTemplateMapper;
import com.crv.erais.sys.manage.pojo.EraisTemplate;
import com.crv.erais.sys.manage.service.EraisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/29 20:34
 * 模板管理控制业务实现
 */
@Service
public class EraisTemplateServiceImpl implements EraisTemplateService {
    //注入相关的系统模板接口功能
    @Autowired
    private EraisTemplateMapper eraisTemplateMapper;
    @Override
    public TableDataInfo page(EraisTemplate example) {
        String uuid=UUIDUtils.getUUID();
        example.setId(uuid);
        PageUtil.startPage(example);
        List<EraisTemplate> page = eraisTemplateMapper.page(example);

        return PageUtil.getDataTable(page);
    }

    @Override
    public int insert(EraisTemplate record) {

        return eraisTemplateMapper.insert(record);
    }

}
