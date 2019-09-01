package com.crv.erais.sys.manage.service.impl;

import com.crv.erais.common.StringUtils;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.common.utils.UUIDUtils;
import com.crv.erais.sys.manage.mapper.EraisAuditEventMapper;
import com.crv.erais.sys.manage.mapper.EraisAuditFindMapper;
import com.crv.erais.sys.manage.mapper.EraisAuditFocusMapper;
import com.crv.erais.sys.manage.pojo.EraisAuditEvent;
import com.crv.erais.sys.manage.pojo.EraisAuditFind;
import com.crv.erais.sys.manage.pojo.EraisAuditFocus;
import com.crv.erais.sys.manage.service.AuditEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 11:47
 * 业务操作
 */
@Service
@Slf4j
public class AuditEventServiceImpl implements AuditEventService {
    //注入审计事项mapper
    @Autowired
    private EraisAuditEventMapper eraisAuditEventMapper;
    //注入审计事项发现的mapper
    @Autowired
    private  EraisAuditFindMapper eraisAuditFindMapper;
    //注入审计事项关注点Mapper
    @Autowired
    private EraisAuditFocusMapper eraisAuditFocusMapper;

    /**
     * 查询对应的数据apper
     * @param example
     * @return
     */
    @Override
    public TableDataInfo selectByExample(EraisAuditEvent example) {
        PageUtil.startPage(example);
        List<EraisAuditEvent> list = eraisAuditEventMapper.selectByExample(example);

        return PageUtil.getDataTable(list);
    }

    /**
     * 进行相应的删除操作
     * @param event
     * @return
     */
    @Override
    //进行事务的提交
    @Transactional
    public int add(EraisAuditEvent event) {
        //查询接口
        String id =UUIDUtils.getUUID();
        event.setId(id);

        //审计事项新增关发现
        List<EraisAuditFind> eraisAuditFinds = event.getEraisAuditFindList();
        for(int i=0;i<eraisAuditFinds.size();i++){
            EraisAuditFind f = eraisAuditFinds.get(i);
            f.setEventId(id);
            eraisAuditFindMapper.save(f);
        }
        //审计事项新增关注点
        List<EraisAuditFocus> eraisAuditFocus=event.getLeraisAuditFocuList();
        for(int i=0;i<eraisAuditFocus.size();i++){
            EraisAuditFocus f = eraisAuditFocus.get(i);
            f.setEventId(id);
            eraisAuditFocusMapper.save(f);
        }
        return eraisAuditEventMapper.add(event);
    }

    /**
     * 根据事项的eventid进行删除
     * @param eventid  返回事项的id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String eventid) {

        return   eraisAuditEventMapper.deleteByPrimaryKey(eventid);

    }
    /**
     * 同时删除多条审计事项业务
     * @param ids
     * @return
     */

    @Override
    public int deleteBeach(List<String> ids) {
            return eraisAuditEventMapper.deleteBatch(ids);
    }

    /**
     * 更新事项业务操作
     * @param eventid
     * @return
     */
    @Override
    public int update(EraisAuditEvent eventid) {

        return eraisAuditEventMapper.update(eventid);
    }

    @Override
    public void updateStatus(EraisAuditEvent eraisAuditEvent) {
        eraisAuditEventMapper.updateStatus(eraisAuditEvent);
    }


}
