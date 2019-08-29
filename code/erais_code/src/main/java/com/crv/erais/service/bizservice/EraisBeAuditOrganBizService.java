package com.crv.erais.service.bizservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.crv.erais.common.utils.SeriaNumberGeneratorUtils;
import com.crv.erais.common.utils.ValidatorUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crv.erais.common.exception.BusinessException;
import com.github.pagehelper.PageInfo;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.common.utils.UUIDUtils;

import com.crv.erais.model.EraisBeAuditOrgan;
import com.crv.erais.service.dataservice.EraisBeAuditOrganDataService;

@Service("eraisBeAuditOrganBizService")
public class EraisBeAuditOrganBizService {

    @Autowired
    private EraisBeAuditOrganDataService eraisBeAuditOrganDataService;
	@Autowired
	private ValidatorUtils validator;
	private  static final String DATA_SOURCE ="ERAIS";
    /**
     * 根据id查询
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param id 主键编号
     * @return EraisBeAuditOrgan
     */
	public EraisBeAuditOrgan getById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}
		
		EraisBeAuditOrgan eraisBeAuditOrgan = eraisBeAuditOrganDataService.getById(id);
		if (eraisBeAuditOrgan == null) {
			return null;
		}
		return eraisBeAuditOrgan;
	}

	/**
	 * 根据id查询(简单对象)
	 *
	 * @author: JW
	 * @date: 2019-08-25 08:06:17
	 * @param id 主键编号
	 * @return EraisBeAuditOrgan
	 */
	public EraisBeAuditOrgan getSimpleById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}

		EraisBeAuditOrgan eraisBeAuditOrgan = eraisBeAuditOrganDataService.getById(id);
		if (eraisBeAuditOrgan == null) {
			return null;
		}
		return eraisBeAuditOrgan;
	}
	
    /**
     * 根据条件查询
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param eraisBeAuditOrgan 查询条件
     * @return EraisBeAuditOrgan
     */
	public EraisBeAuditOrgan getByCondition(EraisBeAuditOrgan eraisBeAuditOrgan) {
		if (eraisBeAuditOrgan == null) {
			return null;
		}
		
		EraisBeAuditOrgan eraisBeAuditOrganPo = eraisBeAuditOrganDataService.getByCondition(eraisBeAuditOrgan);
		if (eraisBeAuditOrganPo == null) {
			return null;
		}
		return eraisBeAuditOrganPo;
	}
	
    /**
     * 根据条件查询集合
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param eraisBeAuditOrgan 查询对象
     * @return List<EraisBeAuditOrgan>
     */
	public List<EraisBeAuditOrgan> list(EraisBeAuditOrgan eraisBeAuditOrgan) {
		if (eraisBeAuditOrgan == null) {
			return null;
		}
		
		List<EraisBeAuditOrgan> eraisBeAuditOrganPOList = eraisBeAuditOrganDataService.list(eraisBeAuditOrgan);
		if (CollectionUtils.isEmpty(eraisBeAuditOrganPOList)) {
			return null;
		}
		return eraisBeAuditOrganPOList;
	}
	
	/**
	 * 根据ID集合查询集合
	 * 
	 * @author JW
	 * @date 2019-08-25 08:06:17
	 * @param ids ID集合
	 * @return List<EraisBeAuditOrgan>
	 */
	public List<EraisBeAuditOrgan> listByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        
        List<EraisBeAuditOrgan> eraisBeAuditOrganPOList = eraisBeAuditOrganDataService.listByIds(ids);
		if (CollectionUtils.isEmpty(eraisBeAuditOrganPOList)) {
			return null;
		}
		return eraisBeAuditOrganPOList;
	}

    /**
     * 根据条件分页查询集合
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param eraisBeAuditOrgan 查询对象
     * @return PageData<EraisBeAuditOrgan>
     */
	public TableDataInfo listPage(EraisBeAuditOrgan eraisBeAuditOrgan) {
		if (eraisBeAuditOrgan == null) {
			return null;
		}
		
		PageUtil.startPage(eraisBeAuditOrgan);
		List<EraisBeAuditOrgan> eraisBeAuditOrganPOList = eraisBeAuditOrganDataService.list(eraisBeAuditOrgan);
		return PageUtil.getDataTable(eraisBeAuditOrganPOList);
	}
	
    /**
     * 保存数据
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param eraisBeAuditOrgan 传输对象
     */
    public void save(EraisBeAuditOrgan eraisBeAuditOrgan) {

		eraisBeAuditOrgan.setId(UUIDUtils.getUUID());
		eraisBeAuditOrgan.setCreateTime(new Date());
		eraisBeAuditOrgan.setUpdateTime(new Date());
		eraisBeAuditOrgan.setDataSource(DATA_SOURCE);//新增数据默认来源为 ERAIS
		eraisBeAuditOrgan.setCode(SeriaNumberGeneratorUtils.getSeriaNumberGenerator());
		//创建人
		//eraisBeAuditOrgan.setCreatePro("");
		//数据非空验证
		validator.validator(eraisBeAuditOrgan);

		EraisBeAuditOrgan reqEraisBeAuditOrgan = new EraisBeAuditOrgan();
		reqEraisBeAuditOrgan.setDepartmentName(eraisBeAuditOrgan.getDepartmentName());
		List<EraisBeAuditOrgan> list = eraisBeAuditOrganDataService.getAllList(reqEraisBeAuditOrgan);
		if(list !=null && list.size()>0){
			throw new BusinessException(1,"非审计机构名称不能重复。");
		}
    	eraisBeAuditOrganDataService.save(eraisBeAuditOrgan);
    }
    
    /**
     * 根据ID修改
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param eraisBeAuditOrgan2 传输对象
     */
	public void update(EraisBeAuditOrgan eraisBeAuditOrgan2) {
		//数据非空验证
		EraisBeAuditOrgan eraisBeAuditOrgan = eraisBeAuditOrganDataService.getById(eraisBeAuditOrgan2.getId());
		BeanUtils.copyProperties(eraisBeAuditOrgan2, eraisBeAuditOrgan);//前赋值给后对象
		validator.validator(eraisBeAuditOrgan);
		if(StringUtils.isEmpty(eraisBeAuditOrgan.getDataSource())){
			if(eraisBeAuditOrgan.getDataSource().equals(DATA_SOURCE)){
				throw new BusinessException(1,"数据来源为 "+DATA_SOURCE +"的不能修改");
			}
		}
		EraisBeAuditOrgan eraisBeAuditOrgan1 = new EraisBeAuditOrgan();
		eraisBeAuditOrgan1.setDepartmentName(eraisBeAuditOrgan.getDepartmentName());
		List<EraisBeAuditOrgan> list = eraisBeAuditOrganDataService.getAllList(eraisBeAuditOrgan1);
		if(list !=null){
			if(list.size()>1){
				throw new BusinessException(1,"非审计机构名称不能重复。");
			}else if (list.size()==1){
				String id = list.get(0).getId();
				if(!eraisBeAuditOrgan.getId().equals(id)){
					throw new BusinessException(1,"非审计机构名称不能重复。");
				}
			}
		}
		eraisBeAuditOrgan.setUpdateTime(new Date());
		//更新人
		//eraisBeAuditOrgan.setUpdatePro("");
		eraisBeAuditOrganDataService.update(eraisBeAuditOrgan);
	}
	
    /**
     * 根据ID删除
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param id 数据ID
     */
    public void delete(String id) {
    	if (StringUtils.isBlank(id)) {
    		return;
    	}
    	eraisBeAuditOrganDataService.delete(id);
    }
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBatch (List<String> ids){
		eraisBeAuditOrganDataService.deleteBatch(ids);
	}
	public void updateStatus(EraisBeAuditOrgan eraisBeAuditOrgan){
		eraisBeAuditOrganDataService.update(eraisBeAuditOrgan);
	}
}
