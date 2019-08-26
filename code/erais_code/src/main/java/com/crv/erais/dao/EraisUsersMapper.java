package com.crv.erais.dao;

import org.apache.ibatis.annotations.Mapper;

import com.crv.erais.common.base.BaseMapper;
// import com.crv.erais.system.api.qo.EraisUsers;
import com.crv.erais.model.EraisUsers;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EraisUsersMapper extends BaseMapper<EraisUsers > {

}
