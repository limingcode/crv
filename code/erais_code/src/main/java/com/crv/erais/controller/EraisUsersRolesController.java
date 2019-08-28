package com.crv.erais.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.crv.erais.model.common.Result;
import com.crv.erais.common.tools.TableDataInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.crv.erais.model.EraisUsersRoles;
import com.crv.erais.service.bizservice.EraisUsersRolesBizService;

@RestController
@RequestMapping("/crv")
public class EraisUsersRolesController {
	
    @Autowired
    private EraisUsersRolesBizService eraisUsersRolesBizService;

	/**
     * 根据id查询
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param id 主键编号
     * @return Result<EraisUsersRoles>
     */
	@GetMapping("/eraisUsersRoles/get/{id}")
	public Result get(@PathVariable("id") String id) {
		EraisUsersRoles eraisUsersRoles = eraisUsersRolesBizService.getById(id);
		return Result.success(eraisUsersRoles);
	}
	/**
	 * 根据id查询(简单对象)
	 *
	 * @author: JW
	 * @date: 2019-08-26 15:44:13
	 * @param id 主键编号
	 * @return Result<EraisUsersRoles>
	 */

	@GetMapping("/eraisUsersRoles/getSimple/{id}")
	public Result getSimple(@PathVariable("id") String id) {
		EraisUsersRoles eraisUsersRoles = eraisUsersRolesBizService.getSimpleById(id);
		return Result.success(eraisUsersRoles);
	}
    /**
     * 根据条件查询集合
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param eraisUsersRoles 查询对象
     * @return Result<List<EraisUsersRoles>>
     */
    @PostMapping("/eraisUsersRoles/list")
	public Result list( EraisUsersRoles eraisUsersRoles) {
		List<EraisUsersRoles> list = eraisUsersRolesBizService.list(eraisUsersRoles);
		return Result.success(list);
	}
    /**
     * 根据条件分页查询集合
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param eraisUsersRoles 查询对象
     * @return Result<PageData<EraisUsersRoles>>
     */
    @PostMapping("/eraisUsersRoles/page")
	public Result listPage( EraisUsersRoles eraisUsersRoles) {
    	TableDataInfo page = eraisUsersRolesBizService.listPage(eraisUsersRoles);
		return Result.success(page);
	}
    /**
     * 保存数据
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param eraisUsersRoles
     * @return Result<Object>
     */
	@PostMapping("/eraisUsersRoles/save")
	public Result save( EraisUsersRoles eraisUsersRoles) {
		eraisUsersRolesBizService.save(eraisUsersRoles);
		return Result.success();
	}
    /**
     * 根据id查询编辑
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param id 主键编号
     * @return Result<EraisUsersRoles>
     */
	@GetMapping("/eraisUsersRoles/edit/{id}")
	public Result edit(@PathVariable("id") String id) {
		EraisUsersRoles eraisUsersRoles = eraisUsersRolesBizService.getById(id);
		return Result.success(eraisUsersRoles);
	}
    /**
     * 根据ID修改
     *
     * @author: JW
     * @date: 2019-08-26 15:44:13
     * @param eraisUsersRoles
	 * @return Result<Object>
     */
	@PostMapping("/eraisUsersRoles/update")
	public Result update( EraisUsersRoles eraisUsersRoles) {
		eraisUsersRolesBizService.update(eraisUsersRoles);
		return Result.success();
	}
	/**
	 * 根据ID删除
	 *
	 * @author: JW
	 * @date: 2019-08-26 15:44:13
	 * @param id 数据ID
	 * @return Result<Object>
	 */
	@PostMapping("/eraisUsersRoles/delete/{id}")
	public Result delete(@PathVariable("id") String id) {
		eraisUsersRolesBizService.delete(id);
		return Result.success();
	}
}
