package com.crv.erais.controller;

import java.util.List;

import com.crv.erais.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crv.erais.model.common.Result;
import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import org.springframework.web.bind.annotation.PathVariable;
import com.crv.erais.model.EraisPlan;
import com.crv.erais.service.bizservice.EraisPlanBizService;

@RestController
@RequestMapping("/crv")
public class EraisPlanController {
	private static final Logger logger = LoggerFactory.getLogger(EraisPlanBizService.class);

	@Autowired
    private EraisPlanBizService eraisPlanBizService;

	/**
     * 根据id查询
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param id 主键编号
     * @return Result<EraisPlan>
     */
	@GetMapping("/eraisPlan/get/{id}")
	public Result get(@PathVariable("id") String id) {
		EraisPlan eraisPlan = eraisPlanBizService.getById(id);
		return Result.success(eraisPlan);
	}
	/**
	 * 根据id查询(简单对象)
	 *
	 * @author: JW
	 * @date: 2019-08-28 14:41:26
	 * @param id 主键编号
	 * @return Result<EraisPlan>
	 */

	@GetMapping("/eraisPlan/getSimple/{id}")
	public Result getSimple(@PathVariable("id") String id) {
		EraisPlan eraisPlan = eraisPlanBizService.getSimpleById(id);
		return Result.success(eraisPlan);
	}
    /**
     * 根据条件查询集合
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param eraisPlan 查询对象
     * @return Result<List<EraisPlan>>
     */
    @PostMapping("/eraisPlan/list")
	public Result list( EraisPlan eraisPlan) {
		List<EraisPlan> list = eraisPlanBizService.list(eraisPlan);
		return Result.success(list);
	}
    /**
     * 根据条件分页查询集合
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param eraisPlan 查询对象
     * @return Result<PageData<EraisPlan>>
     */
    @PostMapping("/eraisPlan/page")
	public Result listPage( EraisPlan eraisPlan) {
    	TableDataInfo page = eraisPlanBizService.listPage(eraisPlan);
		return Result.success(page);
	}
    /**
     * 保存数据
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param eraisPlan
     * @return Result<Object>
     */
	@PostMapping("/eraisPlan/save")
	public Result save( EraisPlan eraisPlan) {
		try {
			eraisPlanBizService.save(eraisPlan);
		}catch (Exception e){
			e.getMessage();
			BusinessException cause  = (BusinessException) e;
			String msg = cause.getErrMsg();
			if (StringUtils.isEmpty(msg)){
				msg = "保存失败";
			}
			logger.error("保存计划失败"+msg);
			return  Result.failure(1,msg);
		}
		return Result.success();
	}
    /**
     * 根据id查询编辑
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param id 主键编号
     * @return Result<EraisPlan>
     */
	@GetMapping("/eraisPlan/edit/{id}")
	public Result edit(@PathVariable("id") String id) {
		EraisPlan eraisPlan = eraisPlanBizService.getById(id);
		return Result.success(eraisPlan);
	}
    /**
     * 根据ID修改
     *
     * @author: JW
     * @date: 2019-08-28 14:41:26
     * @param eraisPlan
	 * @return Result<Object>
     */
	@PostMapping("/eraisPlan/update")
	public Result update( EraisPlan eraisPlan) {
		try {
			if(StringUtils.isEmpty(eraisPlan.getId())){
				logger.info("ID不能为空 ID="+eraisPlan.getId());
				return  Result.failure(1,"ID不能为空");
			}
			eraisPlanBizService.update(eraisPlan);
		}catch (Exception e){
			e.getMessage();
			BusinessException cause  = (BusinessException) e;
			String msg = cause.getErrMsg();
			if (StringUtils.isEmpty(msg)){
				msg = "修改失败";
			}
			logger.info("修改失败"+msg);
			return  Result.failure(1,msg);
		}
		return Result.success();
	}
	/**
	 * 根据ID删除
	 *
	 * @author: JW
	 * @date: 2019-08-28 14:41:26
	 * @param id 数据ID
	 * @return Result<Object>
	 */
	@PostMapping("/eraisPlan/delete/{id}")
	public Result delete(@PathVariable("id") String id) {
		eraisPlanBizService.delete(id);
		return Result.success();
	}
	/**
	 * 批量删除
	 *  @param ids
	 * @return Result
	 */
	@GetMapping("/eraisPlan/deleteBatch")
	public Result deleteBatch(@RequestParam(value = "ids") String  ids){
		try {
			if (StringUtils.isEmpty(ids)) {
				return Result.failure(1,"请求列表为空");
			}
			List<String> idsList = com.crv.erais.common.StringUtils.strSplit(ids);
			eraisPlanBizService.deleteBatch(idsList);
		}catch (Exception e){
			e.getMessage();
			logger.error("删除计划失败"+e.getMessage());
			return Result.failure(1,"删除计划失败");
		}
		return Result.success();
	}
}
