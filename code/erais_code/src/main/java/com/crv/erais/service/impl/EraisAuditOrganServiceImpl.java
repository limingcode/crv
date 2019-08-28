package com.crv.erais.service.impl;

import com.crv.erais.common.StringUtils;
import com.crv.erais.common.exception.BusinessException;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.common.utils.CheckPhoneUtils;
import com.crv.erais.common.utils.SeriaNumberGeneratorUtils;
import com.crv.erais.common.utils.UUIDUtils;
import com.crv.erais.common.utils.ValidatorUtils;
import com.crv.erais.dao.EraisAuditOrganMapper;
import com.crv.erais.model.EraisAuditOrgan;
import com.crv.erais.service.EraisAuditOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EraisAuditOrganServiceImpl implements EraisAuditOrganService {


    @Autowired
    private EraisAuditOrganMapper  eraisAuditOrganMapper;
    @Autowired
    private ValidatorUtils validator;
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
    public void save(EraisAuditOrgan organ)  {

        //生成17位流水
        organ.setCode(SeriaNumberGeneratorUtils.getSeriaNumberGenerator());

        organ.setId(UUIDUtils.getUUID());
        organ.setCreateTime( new Date());
        organ.setUpdateTime(new Date());
        //创建人
        //organ.setCreatePro("");
        validator.validator(organ);

        EraisAuditOrgan eraisAuditOrgan = new EraisAuditOrgan();
        eraisAuditOrgan.setName(organ.getName());
        List<EraisAuditOrgan> list =  eraisAuditOrganMapper.getList(eraisAuditOrgan);
        if (list != null && list.size()>0){
                throw new BusinessException(1,"审计机构名称不能重复。");
        }
        eraisAuditOrganMapper.save(organ);
    }

    @Override
    public void update(EraisAuditOrgan organ) {
        validator.validator(organ);
        EraisAuditOrgan eraisAuditOrgan = new EraisAuditOrgan();
        eraisAuditOrgan.setName(organ.getName());
        List<EraisAuditOrgan> list =  eraisAuditOrganMapper.getList(eraisAuditOrgan);
        if (list != null){
            if (list.size()>1){
                throw new BusinessException(1,"审计机构名称不能重复。");
            } else if(list.size()==1){
                String id = list.get(0).getId();
                if (!organ.getId().equals(id)){
                    throw new BusinessException(1,"审计机构名称不能重复。");
                }
            }
        }
        //更新人
       // organ.setUpdatePro("");
        organ.setUpdateTime(new Date());
        eraisAuditOrganMapper.update(organ);
    }

    @Override
    public void deleteBatch(List<String> ids) {
        eraisAuditOrganMapper.deleteBatch(ids);
    }

    @Override
    public void updateStatus(EraisAuditOrgan eraisAuditOrgan) {
        eraisAuditOrganMapper.update(eraisAuditOrgan);
    }
}
