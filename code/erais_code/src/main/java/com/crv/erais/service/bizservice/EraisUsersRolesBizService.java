package com.crv.erais.service.bizservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import com.crv.erais.model.EraisUsersRoles;
import com.crv.erais.service.dataservice.EraisUsersRolesDataService;

@Service("eraisUsersRolesBizService")
public class EraisUsersRolesBizService {

    @Autowired
    private EraisUsersRolesDataService eraisUsersRolesDataService;
    
    /**
     * 根据id查询
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param id 主键编号
     * @return EraisUsersRoles
     */
	public EraisUsersRoles getById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}
		
		EraisUsersRoles eraisUsersRoles = eraisUsersRolesDataService.getById(id);
		if (eraisUsersRoles == null) {
			return null;
		}
		return eraisUsersRoles;
	}

	/**
	 * 根据id查询(简单对象)
	 *
	 * @author: JW
	 * @date: 2019-08-26 15:44:13
	 * @param id 主键编号
	 * @return EraisUsersRoles
	 */
	public EraisUsersRoles getSimpleById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}

		EraisUsersRoles eraisUsersRoles = eraisUsersRolesDataService.getById(id);
		if (eraisUsersRoles == null) {
			return null;
		}
		return eraisUsersRoles;
	}
	
    /**
     * 根据条件查询
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param eraisUsersRoles 查询条件
     * @return EraisUsersRoles
     */
	public EraisUsersRoles getByCondition(EraisUsersRoles eraisUsersRoles) {
		if (eraisUsersRoles == null) {
			return null;
		}
		
		EraisUsersRoles eraisUsersRolesPo = eraisUsersRolesDataService.getByCondition(eraisUsersRoles);
		if (eraisUsersRolesPo == null) {
			return null;
		}
		return eraisUsersRolesPo;
	}
	
    /**
     * 根据条件查询集合
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param eraisUsersRoles 查询对象
     * @return List<EraisUsersRoles>
     */
	public List<EraisUsersRoles> list(EraisUsersRoles eraisUsersRoles) {
		if (eraisUsersRoles == null) {
			return null;
		}
		
		List<EraisUsersRoles> eraisUsersRolesList = eraisUsersRolesDataService.list(eraisUsersRoles);
		if (CollectionUtils.isEmpty(eraisUsersRolesList)) {
			return null;
		}
		return eraisUsersRolesList;
	}
	
	/**
	 * 根据ID集合查询集合
	 * 
	 * @author JW
	 * @date 2019-08-26 15:44:13
	 * @param ids ID集合
	 * @return List<EraisUsersRoles>
	 */
	public List<EraisUsersRoles> listByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        
        List<EraisUsersRoles> eraisUsersRolesList = eraisUsersRolesDataService.listByIds(ids);
		if (CollectionUtils.isEmpty(eraisUsersRolesList)) {
			return null;
		}
		return eraisUsersRolesList;
	}

    /**
     * 根据条件分页查询集合
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param eraisUsersRoles 查询对象
     * @return PageData<EraisUsersRoles>
     */
	public TableDataInfo listPage(EraisUsersRoles eraisUsersRoles) {
		if (eraisUsersRoles == null) {
			return null;
		}
		
		PageUtil.startPage(eraisUsersRoles);
		List<EraisUsersRoles> eraisUsersRolesList = eraisUsersRolesDataService.list(eraisUsersRoles);
		return PageUtil.getDataTable(eraisUsersRolesList);
	}
	
    /**
     * 保存数据
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param eraisUsersRoles 传输对象
     */
    public void save(EraisUsersRoles eraisUsersRoles) {
    	
		eraisUsersRoles.setId(UUIDUtils.getUUID());
		eraisUsersRoles.setUpdateTime(new Date());
		eraisUsersRoles.setCreateTime(new Date());
    	eraisUsersRolesDataService.save(eraisUsersRoles);
    }
    
    /**
     * 根据ID修改
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param eraisUsersRoles 传输对象
     */
	public void update(EraisUsersRoles eraisUsersRoles) {
		
		EraisUsersRoles eraisUsersRolesPo = eraisUsersRolesDataService.getById(eraisUsersRoles.getId());
		if (eraisUsersRolesPo == null) {
			// TODO 抛出业务异常
		}
		eraisUsersRolesPo.setUpdateTime(new Date());
		BeanUtils.copyProperties(eraisUsersRoles, eraisUsersRolesPo);
		eraisUsersRolesDataService.update(eraisUsersRolesPo);
	}
	
    /**
     * 根据ID删除
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param id 数据ID
     */
    public void delete(String id) {
    	if (StringUtils.isBlank(id)) {
    		return;
    	}
    	eraisUsersRolesDataService.delete(id);
    }
}
