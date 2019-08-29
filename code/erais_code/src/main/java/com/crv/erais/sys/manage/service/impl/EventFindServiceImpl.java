package com.crv.erais.sys.manage.service.impl;

import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.common.utils.UUIDUtils;
import com.crv.erais.model.common.Result;
import com.crv.erais.sys.manage.mapper.EraisAuditFindMapper;
import com.crv.erais.sys.manage.pojo.EraisAuditFind;
import com.crv.erais.sys.manage.service.EventFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/27 20:50
 */
@Service
public class EventFindServiceImpl implements EventFindService {
    @Autowired
    private EraisAuditFindMapper eraisAuditFindMapper;
    @Override
    public TableDataInfo findEvent(EraisAuditFind example) {
        PageUtil.startPage(example);
        List<EraisAuditFind> event = eraisAuditFindMapper.findEvent(example);
        return     PageUtil.getDataTable(event);
    }

    @Override
    public int save(EraisAuditFind eraisAuditFind) {
       eraisAuditFind.setFindid(UUIDUtils.getUUID());

       int row= eraisAuditFindMapper.save(eraisAuditFind);
       if (row<0){
         throw new IllegalArgumentException("审计数据没被发现！！！");
       }
        return row;
    }

    /**
     * 删除对应的发现事项
     * @param findid
     * @return
     */
    @Override
    public int delete(String findid) {
        return eraisAuditFindMapper.delete(findid);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int deleteBatch(List<String> ids) {
        return eraisAuditFindMapper.deleteBatch(ids);
    }

    /**
     * 审计事项发现更新
     * @param eraisAuditFind
     * @return
     */
    @Override
    public int update(EraisAuditFind eraisAuditFind) {
        return eraisAuditFindMapper.update(eraisAuditFind);
    }


}
