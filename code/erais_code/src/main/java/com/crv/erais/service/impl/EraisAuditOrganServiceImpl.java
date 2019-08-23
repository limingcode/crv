package com.crv.erais.service.impl;

import com.crv.erais.common.StringUtils;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.common.utils.UUIDUtils;
import com.crv.erais.dao.EraisAuditOrganMapper;
import com.crv.erais.model.EraisAuditOrgan;
import com.crv.erais.model.Organizational;
import com.crv.erais.service.EraisAuditOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EraisAuditOrganServiceImpl implements EraisAuditOrganService {


    @Autowired
    private EraisAuditOrganMapper eraisAuditOrganMapper;
    @Override
    public TableDataInfo getPageList(EraisAuditOrgan organ) {
        PageUtil.startPage(organ);
        List<EraisAuditOrgan> data =  eraisAuditOrganMapper.getList(organ);
        return PageUtil.getDataTable(data);
    }

    @Override
    public EraisAuditOrgan getById(String Id) {
        EraisAuditOrgan organ = eraisAuditOrganMapper.getById(Id);
        return  organ;
    }

    @Override
    public void deleteById(String Id) {
        eraisAuditOrganMapper.deleteById(Id);
    }

    @Override
    public List<EraisAuditOrgan> getList(EraisAuditOrgan organ) {
        List<EraisAuditOrgan> list = eraisAuditOrganMapper.getList(organ);
        return list;
    }

    @Override
    public void save(EraisAuditOrgan organ) {
        if (organ.getStatus() == null){
            organ.setStatus(1);//启用   2 禁用
        }else {
            if(StringUtils.isEmpty(organ.getStatus().toString())){
                organ.setStatus(1);//启用   2 禁用
            }
        }
        organ.setId(UUIDUtils.getUUID());
        organ.setCreateTime( new Date());
        organ.setUpdateTime(new Date());
        eraisAuditOrganMapper.save(organ);
    }

    @Override
    public void update(EraisAuditOrgan organ) {
        organ.setUpdateTime(new Date());
        eraisAuditOrganMapper.update(organ);
    }
}
