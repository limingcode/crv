package com.crv.erais.dao;

import org.apache.ibatis.annotations.Mapper;

import com.crv.erais.common.base.BaseMapper;
import com.crv.erais.model.EraisBeAuditOrgan;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface EraisBeAuditOrganMapper extends BaseMapper<EraisBeAuditOrgan > {
    public List<EraisBeAuditOrgan> getAllList(EraisBeAuditOrgan eraisBeAuditOrgan);

}
