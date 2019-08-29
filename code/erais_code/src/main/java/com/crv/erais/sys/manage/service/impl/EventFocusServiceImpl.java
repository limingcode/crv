package com.crv.erais.sys.manage.service.impl;

import com.crv.erais.common.utils.TimeFormat;
import com.crv.erais.common.utils.UUIDUtils;
import com.crv.erais.sys.manage.mapper.EraisAuditFocusMapper;
import com.crv.erais.sys.manage.pojo.EraisAuditFocus;
import com.crv.erais.sys.manage.service.EventFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/28 10:26
 * 审计关注点业务处理逻辑
 */
@Service
public class EventFocusServiceImpl implements EventFocusService {

   @Autowired
   private EraisAuditFocusMapper eraisAuditFocusMapper;
   //审计关注点的新增
    @Override
    public int save(EraisAuditFocus eraisAuditFocus) {
        eraisAuditFocus.setFocusid(UUIDUtils.getUUID());

        int save = eraisAuditFocusMapper.save(eraisAuditFocus);
        if (save<0){
            throw new IllegalArgumentException("更新失败！！");
        }
        return save;
    }

    @Override
    public int delete(String focusid) {
        return eraisAuditFocusMapper.delete(focusid);
    }


    /**
     * 审计关注点的批量删除
     * @param ids
     * @return
     */
    @Override
    public int deleteBatch(List<String> ids) {
        return eraisAuditFocusMapper.deleteBatch(ids);
    }

    /**
     * 审计关注点的更新
     * @param eraisAuditFocus
     * @return
     */

    @Override
    public int update(EraisAuditFocus eraisAuditFocus) {
        return eraisAuditFocusMapper.update(eraisAuditFocus);
    }
}
