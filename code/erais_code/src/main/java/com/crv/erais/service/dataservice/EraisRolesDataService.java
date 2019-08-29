package com.crv.erais.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crv.erais.common.base.BaseService;

// import com.crv.erais.system.provider.po.EraisRoles;
import com.crv.erais.model.EraisRoles;
import com.crv.erais.dao.EraisRolesMapper;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> a577cdc70f21af6be6195da512eb9a8ad0a02829
@Service("eraisRolesDataService")
public class EraisRolesDataService extends BaseService<EraisRoles> {

    @Autowired
    private EraisRolesMapper eraisRolesMapper;

    public EraisRolesDataService(EraisRolesMapper eraisRolesMapper) {
        super(eraisRolesMapper);
    }
<<<<<<< HEAD
=======
    public List<EraisRoles> getList(EraisRoles eraisRoles){
        return eraisRolesMapper.allList(eraisRoles);
    }
>>>>>>> a577cdc70f21af6be6195da512eb9a8ad0a02829
}
