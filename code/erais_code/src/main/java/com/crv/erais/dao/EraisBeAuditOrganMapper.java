package com.crv.erais.dao;

import org.apache.ibatis.annotations.Mapper;

import com.crv.erais.common.base.BaseMapper;
import com.crv.erais.model.EraisBeAuditOrgan;

import java.util.List;

@Mapper
public interface EraisBeAuditOrganMapper extends BaseMapper<EraisBeAuditOrgan > {
    public List<EraisBeAuditOrgan> getAllList(EraisBeAuditOrgan eraisBeAuditOrgan);

}
