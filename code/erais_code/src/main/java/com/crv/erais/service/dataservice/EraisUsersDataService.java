package com.crv.erais.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crv.erais.common.base.BaseService;

import com.crv.erais.model.EraisUsers;
import com.crv.erais.dao.EraisUsersMapper;

@Service("eraisUsersDataService")
public class EraisUsersDataService extends BaseService<EraisUsers> {

    @Autowired
    private EraisUsersMapper eraisUsersMapper;

    public EraisUsersDataService(EraisUsersMapper eraisUsersMapper) {
        super(eraisUsersMapper);
    }
}
