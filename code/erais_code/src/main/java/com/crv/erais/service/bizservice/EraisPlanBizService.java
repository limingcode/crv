package com.crv.erais.service.bizservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.crv.erais.common.utils.SeriaNumberGeneratorUtils;
import com.crv.erais.common.utils.ValidatorUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crv.erais.common.exception.BusinessException;
import com.github.pagehelper.PageInfo;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.common.utils.UUIDUtils;

import com.crv.erais.model.EraisPlan;
import com.crv.erais.service.dataservice.EraisPlanDataService;

@Service("eraisPlanBizService")
public class EraisPlanBizService {
	private static final Logger logger = LoggerFactory.getLogger(EraisPlanBizService.class);

    @Autowired
    private EraisPlanDataService eraisPlanDataService;
	@Autowired
    private ValidatorUtils validator;
    /**
     * 根据id查询
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param id 主键编号
     * @return EraisPlan
     */
	public EraisPlan getById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}
		
		EraisPlan eraisPlan = eraisPlanDataService.getById(id);
		if (eraisPlan == null) {
			return null;
		}
		return eraisPlan;
	}

	/**
	 * 根据id查询(简单对象)
	 *
	 * @author: JW
	 * @date: 2019-08-28 14:41:26
	 * @param id 主键编号
	 * @return EraisPlan
	 */
	public EraisPlan getSimpleById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}

		EraisPlan eraisPlan = eraisPlanDataService.getById(id);
		if (eraisPlan == null) {
			return null;
		}
		return eraisPlan;
	}
	
    /**
     * 根据条件查询
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param eraisPlan 查询条件
     * @return EraisPlan
     */
	public EraisPlan getByCondition(EraisPlan eraisPlan) {
		if (eraisPlan == null) {
			return null;
		}
		
		EraisPlan eraisPlanPo = eraisPlanDataService.getByCondition(eraisPlan);
		if (eraisPlanPo == null) {
			return null;
		}
		return eraisPlanPo;
	}
	
    /**
     * 根据条件查询集合
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param eraisPlan 查询对象
     * @return List<EraisPlan>
     */
	public List<EraisPlan> list(EraisPlan eraisPlan) {
		if (eraisPlan == null) {
			return null;
		}
		
		List<EraisPlan> eraisPlanList = eraisPlanDataService.list(eraisPlan);
		if (CollectionUtils.isEmpty(eraisPlanList)) {
			return null;
		}
		return eraisPlanList;
	}
	
	/**
	 * 根据ID集合查询集合
	 * 
	 * @author JW
	 * @date 2019-08-28 14:41:26
	 * @param ids ID集合
	 * @return List<EraisPlan>
	 */
	public List<EraisPlan> listByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        
        List<EraisPlan> eraisPlanList = eraisPlanDataService.listByIds(ids);
		if (CollectionUtils.isEmpty(eraisPlanList)) {
			return null;
		}
		return eraisPlanList;
	}

    /**
     * 根据条件分页查询集合
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param eraisPlan 查询对象
     * @return PageData<EraisPlan>
     */
	public TableDataInfo listPage(EraisPlan eraisPlan) {
		if (eraisPlan == null) {
			return null;
		}
		
		PageUtil.startPage(eraisPlan);
		List<EraisPlan> eraisPlanList = eraisPlanDataService.list(eraisPlan);
		return PageUtil.getDataTable(eraisPlanList);
	}
	
    /**
     * 保存数据
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param eraisPlan 传输对象
     */
    public void save(EraisPlan eraisPlan) {
    	
		eraisPlan.setId(UUIDUtils.getUUID());
		eraisPlan.setUpdateTime(new Date());
		eraisPlan.setCreateTime(new Date());
		//创建人
		// eraisPlan.setCreatePro();
		eraisPlan.setPlanCode(SeriaNumberGeneratorUtils.getSeriaNumberGenerator());
		//数据非空验证
		validator.validator(eraisPlan);
		EraisPlan req = new EraisPlan();
		req.setPlanName(eraisPlan.getPlanName());
		List<EraisPlan> list = eraisPlanDataService.list(req);
		if(list !=null && list.size()>0){
			throw new BusinessException(1,"计划名不能重复。");
		}
    	eraisPlanDataService.save(eraisPlan);
    }
    
    /**
     * 根据ID修改
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param eraisPlan 传输对象
     */
	public void update(EraisPlan eraisPlan) {
		
		EraisPlan eraisPlanPo = eraisPlanDataService.getById(eraisPlan.getId());
		if (eraisPlanPo == null) {
			throw new BusinessException(1,"计划不存在");
		}
		eraisPlanPo.setUpdateTime(new Date());
		BeanUtils.copyProperties(eraisPlan, eraisPlanPo);
		EraisPlan req = new EraisPlan();
		req.setPlanName(eraisPlanPo.getPlanName());
		List<EraisPlan> list = eraisPlanDataService.list(req);
		if(list!= null){
			if(list.size()>1){
				throw new BusinessException(1,"用户姓名或用户ID重复");
			}else if (list.size()==1){
				EraisPlan e = list.get(0);
				if(!e.getId().equals(eraisPlanPo.getId())){
					throw new BusinessException(1,"用户姓名或用户ID重复");
				}
			}
		}
		eraisPlanDataService.update(eraisPlanPo);
	}
	
    /**
     * 根据ID删除
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param id 数据ID
     */
    public void delete(String id) {
    	if (StringUtils.isBlank(id)) {
    		return;
    	}
    	eraisPlanDataService.delete(id);
    }

	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBatch (List<String> ids){
		eraisPlanDataService.deleteBatch(ids);
	}
}
