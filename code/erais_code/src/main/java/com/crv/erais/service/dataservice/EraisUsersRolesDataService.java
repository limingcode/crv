package com.crv.erais.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crv.erais.common.base.BaseService;

// import com.crv.erais.system.provider.po.EraisUsersRoles;
import com.crv.erais.model.EraisUsersRoles;
import com.crv.erais.dao.EraisUsersRolesMapper;

@Service("eraisUsersRolesDataService")
public class EraisUsersRolesDataService extends BaseService<EraisUsersRoles> {

    @Autowired
    private EraisUsersRolesMapper eraisUsersRolesMapper;

    public EraisUsersRolesDataService(EraisUsersRolesMapper eraisUsersRolesMapper) {
        super(eraisUsersRolesMapper);
    }
}
