package com.crv.erais.service.bizservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.crv.erais.model.EraisRoles;
import com.crv.erais.service.dataservice.EraisRolesDataService;

@Service("eraisRolesBizService")
public class EraisRolesBizService {

    @Autowired
    private EraisRolesDataService eraisRolesDataService;
	@Autowired
	private ValidatorUtils validator;
    /**
     * 根据id查询
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param id 主键编号
     * @return EraisRoles
     */
	public EraisRoles getById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}
		
		EraisRoles eraisRoles = eraisRolesDataService.getById(id);
		if (eraisRoles == null) {
			return null;
		}
		return eraisRoles;
	}

	/**
	 * 根据id查询(简单对象)
	 *
	 * @author: JW
	 * @date: 2019-08-25 14:52:27
	 * @param id 主键编号
	 * @return EraisRoles
	 */
	public EraisRoles getSimpleById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}

		EraisRoles eraisRoles = eraisRolesDataService.getById(id);
		if (eraisRoles == null) {
			return null;
		}
		return eraisRoles;
	}
	
    /**
     * 根据条件查询
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param eraisRoles 查询条件
     * @return EraisRoles
     */
	public EraisRoles getByCondition(EraisRoles eraisRoles) {
		if (eraisRoles == null) {
			return null;
		}
		
		EraisRoles eraisRolesPo = eraisRolesDataService.getByCondition(eraisRoles);
		if (eraisRolesPo == null) {
			return null;
		}
		return eraisRolesPo;
	}
	
    /**
     * 根据条件查询集合
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param eraisRoles 查询对象
     * @return List<EraisRoles>
     */
	public List<EraisRoles> list(EraisRoles eraisRoles) {
		if (eraisRoles == null) {
			return null;
		}
		
		List<EraisRoles> eraisRolesList = eraisRolesDataService.list(eraisRoles);
		if (CollectionUtils.isEmpty(eraisRolesList)) {
			return null;
		}
		return eraisRolesList;
	}
	
	/**
	 * 根据ID集合查询集合
	 * 
	 * @author JW
	 * @date 2019-08-25 14:52:27
	 * @param ids ID集合
	 * @return List<EraisRoles>
	 */
	public List<EraisRoles> listByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        
        List<EraisRoles> eraisRolesList = eraisRolesDataService.listByIds(ids);
		if (CollectionUtils.isEmpty(eraisRolesList)) {
			return null;
		}
		return eraisRolesList;
	}

    /**
     * 根据条件分页查询集合
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param eraisRoles 查询对象
     * @return PageData<EraisRoles>
     */
	public TableDataInfo listPage(EraisRoles eraisRoles) {
		if (eraisRoles == null) {
			return null;
		}
		
		PageUtil.startPage(eraisRoles);
		List<EraisRoles> eraisRolesList = eraisRolesDataService.list(eraisRoles);
		return PageUtil.getDataTable(eraisRolesList);
	}
	
    /**
     * 保存数据
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param eraisRoles 传输对象
     */
    public void save(EraisRoles eraisRoles) {
		eraisRoles.setId(UUIDUtils.getUUID());
		eraisRoles.setUpdateTime(new Date());
		eraisRoles.setCreateTime(new Date());
		//创建人
		//eraisRoles.setCreatePro("");
		//数据非空验证
		validator.validator(eraisRoles);
		List<EraisRoles> list = eraisRolesDataService.list(eraisRoles);
		if(list !=null && list.size()>0){
			throw new BusinessException(1,"角色名称不能重复。");
		}
    	eraisRolesDataService.save(eraisRoles);
    }
    
    /**
     * 根据ID修改
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param eraisRoles 传输对象
     */
	public void update(EraisRoles eraisRoles) {
		validator.validator(eraisRoles);
		EraisRoles eraisRoles1 = new EraisRoles();
		eraisRoles1.setRoleName(eraisRoles.getRoleName());
		List<EraisRoles> list = eraisRolesDataService.list(eraisRoles1);
		if(list !=null){
			if(list.size()>1){
				throw new BusinessException(1,"角色名称不能重复。");
			}else if (list.size()==1){
				String id = list.get(0).getId();
				if(!eraisRoles.getId().equals(id)){
					throw new BusinessException(1,"角色名称不能重复。");
				}
			}
		}
		eraisRoles.setUpdateTime(new Date());
        //修改人
		//eraisRoles.setUpdatePro("");
		eraisRolesDataService.update(eraisRoles);
	}
	
    /**
     * 根据ID删除
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param id 数据ID
     */
    public void delete(String id) {
    	if (StringUtils.isBlank(id)) {
    		return;
    	}
    	eraisRolesDataService.delete(id);
    }
}
