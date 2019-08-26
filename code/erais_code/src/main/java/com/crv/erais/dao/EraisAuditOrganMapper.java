package com.crv.erais.dao;

import com.crv.erais.model.EraisAuditOrgan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface EraisAuditOrganMapper {

    public EraisAuditOrgan getById(String Id);
    public List<EraisAuditOrgan> getList(EraisAuditOrgan organ);
    public void save(EraisAuditOrgan organ);
    public void update(EraisAuditOrgan organ);
    public void deleteById(String Id);
}