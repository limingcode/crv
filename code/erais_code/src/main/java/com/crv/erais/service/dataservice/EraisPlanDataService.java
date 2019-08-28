package com.crv.erais.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crv.erais.common.base.BaseService;

// import com.crv.erais.system.provider.po.EraisPlan;
import com.crv.erais.model.EraisPlan;
import com.crv.erais.dao.EraisPlanMapper;

@Service("eraisPlanDataService")
public class EraisPlanDataService extends BaseService<EraisPlan> {

    @Autowired
    private EraisPlanMapper eraisPlanMapper;

    public EraisPlanDataService(EraisPlanMapper eraisPlanMapper) {
        super(eraisPlanMapper);
    }
}
