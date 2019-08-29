package com.crv.erais.service.dataservice;

import com.crv.erais.common.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crv.erais.model.EraisBeAuditOrgan;
import com.crv.erais.dao.EraisBeAuditOrganMapper;

import java.util.List;

@Service("eraisBeAuditOrganDataService")
public class EraisBeAuditOrganDataService extends BaseService<EraisBeAuditOrgan> {

    @Autowired
    private EraisBeAuditOrganMapper eraisBeAuditOrganMapper;

    public EraisBeAuditOrganDataService(EraisBeAuditOrganMapper eraisBeAuditOrganMapper) {
        super(eraisBeAuditOrganMapper);
    }

    public List<EraisBeAuditOrgan> getAllList(EraisBeAuditOrgan eraisBeAuditOrgan){
        return  eraisBeAuditOrganMapper.getAllList(eraisBeAuditOrgan);
    }
}
