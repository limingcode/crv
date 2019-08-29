package com.crv.erais.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crv.erais.common.base.BaseService;

// import com.crv.erais.system.provider.po.EraisRoles;
import com.crv.erais.model.EraisRoles;
import com.crv.erais.dao.EraisRolesMapper;

import java.util.List;

@Service("eraisRolesDataService")
public class EraisRolesDataService extends BaseService<EraisRoles> {

    @Autowired
    private EraisRolesMapper eraisRolesMapper;

    public EraisRolesDataService(EraisRolesMapper eraisRolesMapper) {
        super(eraisRolesMapper);
    }
    public List<EraisRoles> getList(EraisRoles eraisRoles){
        return eraisRolesMapper.allList(eraisRoles);
    }
}
