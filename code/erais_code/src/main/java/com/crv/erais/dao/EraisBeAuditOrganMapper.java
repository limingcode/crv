package com.crv.erais.dao;

import org.apache.ibatis.annotations.Mapper;

import com.crv.erais.common.base.BaseMapper;
import com.crv.erais.model.EraisBeAuditOrgan;

<<<<<<< HEAD
@Mapper
public interface EraisBeAuditOrganMapper extends BaseMapper<EraisBeAuditOrgan > {
=======
import java.util.List;

@Mapper
public interface EraisBeAuditOrganMapper extends BaseMapper<EraisBeAuditOrgan > {
    public List<EraisBeAuditOrgan> getAllList(EraisBeAuditOrgan eraisBeAuditOrgan);
>>>>>>> a577cdc70f21af6be6195da512eb9a8ad0a02829

}
