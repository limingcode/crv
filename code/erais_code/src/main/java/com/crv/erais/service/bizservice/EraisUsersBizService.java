package com.crv.erais.service.bizservice;

import java.util.Date;
import java.util.List;

import com.crv.erais.common.utils.ValidatorUtils;
import com.crv.erais.model.EraisUsersRoles;
import com.crv.erais.service.dataservice.EraisUsersRolesDataService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crv.erais.common.exception.BusinessException;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.common.utils.UUIDUtils;

import com.crv.erais.model.EraisUsers;
import com.crv.erais.service.dataservice.EraisUsersDataService;
import org.springframework.transaction.annotation.Transactional;

@Service("eraisUsersBizService")
public class EraisUsersBizService {

    @Autowired
    private EraisUsersDataService eraisUsersDataService;
	@Autowired
	private ValidatorUtils validator;
	@Autowired
	private EraisUsersRolesDataService eraisUsersRolesDataService;
    /**
     * 根据id查询
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param id 主键编号
     * @return EraisUsers
     */
	public EraisUsers getById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}
		
		EraisUsers eraisUsers = eraisUsersDataService.getById(id);
		if (eraisUsers == null) {
			return null;
		}
		//查询关联角色
		EraisUsersRoles ro = new EraisUsersRoles();
		ro.setUserId(id);
		List<EraisUsersRoles> list =eraisUsersRolesDataService.list(ro);
		if (list != null && list.size()>0){
			eraisUsers.setUsersRolesList(list);
		}
		return eraisUsers;
	}

	/**
	 * 根据id查询(简单对象)
	 *
	 * @author: JW
	 * @date: 2019-08-25 20:28:07
	 * @param id 主键编号
	 * @return EraisUsers
	 */
	public EraisUsers getSimpleById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}

		EraisUsers eraisUsers = eraisUsersDataService.getById(id);
		if (eraisUsers == null) {
			return null;
		}
		return eraisUsers;
	}
	
    /**
     * 根据条件查询
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param eraisUsers 查询条件
     * @return EraisUsers
     */
	public EraisUsers getByCondition(EraisUsers eraisUsers) {
		if (eraisUsers == null) {
			return null;
		}
		
		EraisUsers eraisUsersPo = eraisUsersDataService.getByCondition(eraisUsers);
		if (eraisUsersPo == null) {
			return null;
		}
		return eraisUsersPo;
	}
	
    /**
     * 根据条件查询集合
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param eraisUsers 查询对象
     * @return List<EraisUsers>
     */
	public List<EraisUsers> list(EraisUsers eraisUsers) {
		if (eraisUsers == null) {
			return null;
		}
		
		List<EraisUsers> eraisUsersList = eraisUsersDataService.list(eraisUsers);
		if (CollectionUtils.isEmpty(eraisUsersList)) {
			return null;
		}
		return eraisUsersList;
	}
	
	/**
	 * 根据ID集合查询集合
	 * 
	 * @author JW
	 * @date 2019-08-25 20:28:07
	 * @param ids ID集合
	 * @return List<EraisUsers>
	 */
	public List<EraisUsers> listByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        
        List<EraisUsers> eraisUsersList = eraisUsersDataService.listByIds(ids);
		if (CollectionUtils.isEmpty(eraisUsersList)) {
			return null;
		}
		return eraisUsersList;
	}

    /**
     * 根据条件分页查询集合
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param eraisUsers 查询对象
     * @return PageData<EraisUsers>
     */
	public TableDataInfo listPage(EraisUsers eraisUsers) {
		if (eraisUsers == null) {
			return null;
		}
		
		PageUtil.startPage(eraisUsers);
		List<EraisUsers> eraisUsersList = eraisUsersDataService.list(eraisUsers);
		return PageUtil.getDataTable(eraisUsersList);
	}
	
    /**
     * 保存数据
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param eraisUsers 传输对象
     */
    @Transactional
    public void save(EraisUsers eraisUsers) {
		/* 数据校验 */
		eraisUsers.setId(UUIDUtils.getUUID());
		eraisUsers.setUpdateTime(new Date());
		eraisUsers.setCreateTime(new Date());
		//创建人
		//eraisUsers.setCreatePro("");

		validator.validator(eraisUsers);
		EraisUsers parmUsers = new EraisUsers();
		parmUsers.setUserName(eraisUsers.getUserName());
		parmUsers.setUserId(eraisUsers.getUserId());
		List<EraisUsers> list = eraisUsersDataService.list(parmUsers);
		if(list!= null && list.size()>0){
			throw new BusinessException(1,"用户姓名或用户ID重复");
		}
    	eraisUsersDataService.save(eraisUsers);
		//保存用户配置的角色
		if (eraisUsers.getUsersRolesList()!= null){
			eraisUsersRolesDataService.saveBatch(eraisUsers.getUsersRolesList());
		}
    }
    
    /**
     * 根据ID修改
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param eraisUsers 传输对象
     */
	public void update(EraisUsers eraisUsers) {
		if(StringUtils.isEmpty(eraisUsers.getId())){
			throw new BusinessException(1,"用户唯一ID不能为空。");
		}
		EraisUsers eraisUsersPo = eraisUsersDataService.getById(eraisUsers.getId());
		if (eraisUsersPo == null) {
			throw new BusinessException(1,"该用户不存在，不做更新操作");
		}
		EraisUsers parmUsers = new EraisUsers();
		parmUsers.setUserName(eraisUsers.getUserName());
		parmUsers.setUserId(eraisUsers.getUserId());
		List<EraisUsers> list = eraisUsersDataService.list(parmUsers);
		if(list!= null){
			if(list.size()>1){
				throw new BusinessException(1,"用户姓名或用户ID重复");
			}else if (list.size()==1){
				EraisUsers user = list.get(0);
				if(!user.getId().equals(eraisUsers.getId())){
					throw new BusinessException(1,"用户姓名或用户ID重复");
				}
			}
		}
		eraisUsersPo.setUpdateTime(new Date());
		BeanUtils.copyProperties(eraisUsers, eraisUsersPo);
		/* 数据校验非空 */
		validator.validator(eraisUsersPo);
		eraisUsersDataService.update(eraisUsersPo);
		//更新用户配置的角色
		if (eraisUsers.getUsersRolesList()!= null){
			List<EraisUsersRoles> rolesList  = eraisUsers.getUsersRolesList();
			for (int i=0;i<rolesList.size();i++){
				String id = rolesList.get(i).getId();
				if(StringUtils.isEmpty(id)){
					EraisUsersRoles ro = rolesList.get(i);
					ro.setId(UUIDUtils.getUUID());
					eraisUsersRolesDataService.save(ro);
				}else{
					eraisUsersRolesDataService.update(rolesList.get(i));
				}
			}
		}
	}
	
    /**
     * 根据ID删除
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param id 数据ID
     */
    public void delete(String id) {
    	if (StringUtils.isBlank(id)) {
    		return;
    	}
    	eraisUsersDataService.delete(id);
    }

	/**
	 * 删除用户配置的角色
	 * @param id
	 */
	public void deleteUserRole(String id) {
		if (StringUtils.isBlank(id)) {
			return;
		}
		eraisUsersRolesDataService.delete(id);
	}

	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBatch (List<String> ids){
		eraisUsersDataService.deleteBatch(ids);
	}
	public void updateStatus(EraisUsers eraisUsers){
		eraisUsersDataService.update(eraisUsers);
	}
}
