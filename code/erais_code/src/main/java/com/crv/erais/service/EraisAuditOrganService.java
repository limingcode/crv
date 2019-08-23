package com.crv.erais.service;

import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.model.EraisAuditOrgan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EraisAuditOrganService {
    public TableDataInfo getPageList(EraisAuditOrgan organ);
    public EraisAuditOrgan getById(@Param("Id") String Id);

    public void deleteById(@Param("Id") String Id);
    public List<EraisAuditOrgan> getList(EraisAuditOrgan organ);
    public void save(EraisAuditOrgan organ);
    public void update(EraisAuditOrgan organ);

}
