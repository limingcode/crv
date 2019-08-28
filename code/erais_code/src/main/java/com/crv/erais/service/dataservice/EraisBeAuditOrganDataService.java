package com.crv.erais.service.dataservice;

import com.crv.erais.common.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crv.erais.model.EraisBeAuditOrgan;
import com.crv.erais.dao.EraisBeAuditOrganMapper;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> a577cdc70f21af6be6195da512eb9a8ad0a02829
@Service("eraisBeAuditOrganDataService")
public class EraisBeAuditOrganDataService extends BaseService<EraisBeAuditOrgan> {

    @Autowired
    private EraisBeAuditOrganMapper eraisBeAuditOrganMapper;

    public EraisBeAuditOrganDataService(EraisBeAuditOrganMapper eraisBeAuditOrganMapper) {
        super(eraisBeAuditOrganMapper);
    }
<<<<<<< HEAD
=======

    public List<EraisBeAuditOrgan> getAllList(EraisBeAuditOrgan eraisBeAuditOrgan){
        return  eraisBeAuditOrganMapper.getAllList(eraisBeAuditOrgan);
    }
>>>>>>> a577cdc70f21af6be6195da512eb9a8ad0a02829
}
