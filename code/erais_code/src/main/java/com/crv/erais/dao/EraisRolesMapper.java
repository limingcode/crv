package com.crv.erais.dao;

import org.apache.ibatis.annotations.Mapper;

import com.crv.erais.common.base.BaseMapper;
// import com.crv.erais.system.api.qo.EraisRoles;
import com.crv.erais.model.EraisRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EraisRolesMapper extends BaseMapper<EraisRoles > {

    public List<EraisRoles> allList(EraisRoles eraisRoles);
}
