package com.crv.erais.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crv.erais.common.exception.BusinessException;
import com.crv.erais.model.EraisRoles;
import com.crv.erais.model.User;
import com.crv.erais.model.common.ResultCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crv.erais.model.common.Result;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import org.springframework.web.bind.annotation.PathVariable;
import com.crv.erais.model.EraisUsers;
import com.crv.erais.service.bizservice.EraisUsersBizService;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/crv")
public class EraisUsersController {
	private static final Logger logger = LoggerFactory.getLogger(EraisBeAuditOrganController.class);

	@Autowired
    private EraisUsersBizService eraisUsersBizService;
	@Autowired
	private RestTemplate template;

	/**
	 * 查询用户数据 支持分页
	 * @param pageSize
	 * @param current
	 * @param userName
	 * @param userAccount
	 * @return Result
	 */
	@GetMapping("/eraisUsers/getUserList")
	public Result getUserList(@RequestParam("pageSize") int pageSize,@RequestParam("current")int current,
							  @RequestParam("userName") String userName, @RequestParam("userAccount") String userAccount){
		JSONObject userResult = JSONObject.parseObject(template.getForObject("http://10.239.16.30:18081/upm/user/page?pageSize="+pageSize+"&current="+current+"&userName="+userName+"&userAccount"+userAccount,String.class));

		if (userResult.getInteger("code")==0){
			JSONObject userJson = userResult.getJSONObject("data");
			System.out.println("userJson.getString(\"records\")");
			List<User> userList = JSON.parseArray(userJson.getString("records"), User.class);
			return Result.success(userList);
		}else {
			return Result.failure(ResultCode.USER_NOT_EXIST,userResult.getString("msg"));
		}
	}
	/**
     * 根据id查询
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param id 主键编号
     * @return Result<EraisUsers>
     */
	@GetMapping("/eraisUsers/get/{id}")
	public Result get(@PathVariable("id") String id) {
		EraisUsers eraisUsers = eraisUsersBizService.getById(id);
		return Result.success(eraisUsers);
	}
	/**
	 * 根据id查询(简单对象)
	 *
	 * @author: JW
	 * @date: 2019-08-25 20:28:07
	 * @param id 主键编号
	 * @return Result<EraisUsers>
	 */

	@GetMapping("/eraisUsers/getSimple/{id}")
	public Result getSimple(@PathVariable("id") String id) {
		EraisUsers eraisUsers = eraisUsersBizService.getSimpleById(id);
		return Result.success(eraisUsers);
	}
    /**
     * 根据条件查询集合
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param eraisUsers 查询对象
     * @return Result<List<EraisUsers>>
     */
    @PostMapping("/eraisUsers/list")
	public Result list( EraisUsers eraisUsers) {
		List<EraisUsers> list = eraisUsersBizService.list(eraisUsers);
		return Result.success(list);
	}
    /**
     * 根据条件分页查询集合
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param eraisUsers 查询对象
     * @return Result<PageData<EraisUsers>>
     */
    @PostMapping("/eraisUsers/page")
	public Result listPage( EraisUsers eraisUsers) {
    	TableDataInfo page = eraisUsersBizService.listPage(eraisUsers);
		return Result.success(page);
	}
    /**
     * 保存数据
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param eraisUsers
     * @return Result<Object>
     */
	@PostMapping("/eraisUsers/save")
	public Result save( EraisUsers eraisUsers) {
		try {
			eraisUsersBizService.save(eraisUsers);
		}catch (Exception e){
			e.getMessage();
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
     * @date: 2019-08-25 20:28:07
     * @param id 主键编号
     * @return Result<EraisUsers>
     */
	@GetMapping("/eraisUsers/edit/{id}")
	public Result edit(@PathVariable("id") String id) {
		EraisUsers eraisUsers = eraisUsersBizService.getById(id);
		return Result.success(eraisUsers);
	}
    /**
     * 根据ID修改
     *
     * @author: JW
     * @date: 2019-08-25 20:28:07
     * @param eraisUsers
	 * @return Result<Object>
     */
	@PostMapping("/eraisUsers/update")
	public Result update( EraisUsers eraisUsers) {
		try {
			eraisUsersBizService.update(eraisUsers);
		}catch (Exception e){
			e.getMessage();
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
	 * @date: 2019-08-25 20:28:07
	 * @param id 数据ID
	 * @return Result<Object>
	 */
	@PostMapping("/eraisUsers/delete/{id}")
	public Result delete(@PathVariable("id") String id) {
		eraisUsersBizService.delete(id);
		return Result.success();
	}

	/**
	 * 删除用户配置的角色
	 * @param id
	 * @return Result
	 */
	@GetMapping("/eraisUsers/deleteUserRole/{id}")
	public Result deleteUserRole(@PathVariable("id") String id){
		eraisUsersBizService.deleteUserRole(id);
		return Result.success();
	}
	/**
	 *  @param ids
	 * @return Result
	 */
	@GetMapping("/eraisUsers/deleteBatch")
	public Result deleteBatch(@RequestParam(value = "ids") String  ids){
		try {
			if (StringUtils.isEmpty(ids)) {
				return Result.failure(1,"请求列表为空");
			}
			List<String> idsList = com.crv.erais.common.StringUtils.strSplit(ids);
			eraisUsersBizService.deleteBatch(idsList);
		}catch (Exception e){
			e.getMessage();
			logger.error("删除用户失败"+e.getMessage());
			return Result.failure(1,"删除用户失败");
		}
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
	@GetMapping("/eraisUsers/updateStatus")
	public Result updateStatus(@RequestParam("id") String id, @RequestParam("status")  int status) {
		EraisUsers eraisUsers = new EraisUsers();
		eraisUsers.setId(id);
		eraisUsers.setStatus(status);
		eraisUsersBizService.updateStatus(eraisUsers);
		return Result.success();
	}

}
