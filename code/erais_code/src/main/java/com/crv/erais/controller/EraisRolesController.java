package com.crv.erais.controller;

import java.util.List;
import java.util.Map;

import com.crv.erais.common.exception.BusinessException;
import com.crv.erais.common.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crv.erais.model.common.Result;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import org.springframework.web.bind.annotation.PathVariable;
import com.crv.erais.model.EraisRoles;
import com.crv.erais.service.bizservice.EraisRolesBizService;

@RestController
@RequestMapping("/crv")
public class EraisRolesController {
    private static final Logger logger = LoggerFactory.getLogger(EraisBeAuditOrganController.class);

    @Autowired
    private EraisRolesBizService eraisRolesBizService;
    @Autowired
    private ValidatorUtils validator;
	/**
     * 根据id查询
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param id 主键编号
     * @return Result<EraisRoles>
     */
	@GetMapping("/eraisRoles/get/{id}")
	public Result get(@PathVariable("id") String id) {
		EraisRoles eraisRoles = eraisRolesBizService.getById(id);
		return Result.success(eraisRoles);
	}
	/**
	 * 根据id查询(简单对象)
	 *
	 * @author: JW
	 * @date: 2019-08-25 14:52:27
	 * @param id 主键编号
	 * @return Result<EraisRoles>
	 */

	@GetMapping("/eraisRoles/getSimple/{id}")
	public Result getSimple(@PathVariable("id") String id) {
		EraisRoles eraisRoles = eraisRolesBizService.getSimpleById(id);
		return Result.success(eraisRoles);
	}
    /**
     * 根据条件查询集合
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param eraisRoles 查询对象
     * @return Result<List<EraisRoles>>
     */
    @PostMapping("/eraisRoles/list")
	public Result list( EraisRoles eraisRoles) {
		List<EraisRoles> list = eraisRolesBizService.list(eraisRoles);
		return Result.success(list);
	}
    /**
     * 根据条件分页查询集合
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param eraisRoles 查询对象
     * @return Result<PageData<EraisRoles>>
     */
    @PostMapping("/eraisRoles/page")
	public Result listPage( EraisRoles eraisRoles) {
    	TableDataInfo page = eraisRolesBizService.listPage(eraisRoles);
		return Result.success(page);
	}
    /**
     * 保存数据
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param eraisRoles
     * @return Result<Object>
     */
	@PostMapping("/eraisRoles/save")
	public Result save( EraisRoles eraisRoles) {
	    try {
            eraisRolesBizService.save(eraisRoles);
        }catch (Exception e){
            BusinessException cause  = (BusinessException) e;
            String msg = cause.getErrMsg();
            if (StringUtils.isEmpty(msg)){
                msg = "保存失败";
            }
            return  Result.failure(1,msg);
        }
		return Result.success();
	}
    /**
     * 根据id查询编辑
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param id 主键编号
     * @return Result<EraisRoles>
     */
	@GetMapping("/eraisRoles/edit/{id}")
	public Result edit(@PathVariable("id") String id) {
		EraisRoles eraisRoles = eraisRolesBizService.getById(id);
		return Result.success(eraisRoles);
	}
    /**
     * 根据ID修改
     *
     * @author: JW
     * @date: 2019-08-25 14:52:27
     * @param eraisRoles
	 * @return Result<Object>
     */
	@PostMapping("/eraisRoles/update")
	public Result update( EraisRoles eraisRoles) {
        try {
            eraisRolesBizService.update(eraisRoles);
        }catch (Exception e){
            BusinessException cause  = (BusinessException) e;
            String msg = cause.getErrMsg();
            if (StringUtils.isEmpty(msg)){
                msg = "保存失败";
            }
            return  Result.failure(1,msg);
        }
		return Result.success();
	}
	/**
	 * 根据ID删除
	 *
	 * @author: JW
	 * @date: 2019-08-25 14:52:27
	 * @param id 数据ID
	 * @return Result<Object>
	 */
	@PostMapping("/eraisRoles/delete/{id}")
	public Result delete(@PathVariable("id") String id) {
		eraisRolesBizService.delete(id);
		return Result.success();
	}
	/**
	 * 修改状态
	 *
	 * @author: JW
	 * @date: 2019-08-27 14:52:27
	 * @param id 数据ID
	 * @return Result<Object>
	 */
	@GetMapping("/eraisRoles/updateStatus")
	public Result updateStatus(@RequestParam("id") String id, @RequestParam("status")  int status) {
		EraisRoles eraisRoles = new EraisRoles();
		eraisRoles.setId(id);
		eraisRoles.setStatus(status);
		eraisRolesBizService.updateStatus(eraisRoles);
		return Result.success();
	}


}
