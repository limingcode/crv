package com.crv.erais.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.crv.erais.common.exception.BusinessException;
import com.crv.erais.common.utils.ExcelUtil;
import com.crv.erais.common.utils.ValidatorUtils;
import com.crv.erais.model.EraisAuditOrgan;
<<<<<<< HEAD
=======
import com.crv.erais.model.EraisUsers;
>>>>>>> a577cdc70f21af6be6195da512eb9a8ad0a02829
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crv.erais.model.common.Result;
import com.crv.erais.common.tools.TableDataInfo;

import com.crv.erais.model.EraisBeAuditOrgan;
import com.crv.erais.service.bizservice.EraisBeAuditOrganBizService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/crv")
public class EraisBeAuditOrganController {
	private static final Logger logger = LoggerFactory.getLogger(EraisBeAuditOrganController.class);


	@Autowired
    private EraisBeAuditOrganBizService eraisBeAuditOrganBizService;
	@Autowired
	private ValidatorUtils validator;

	/**
     * 根据id查询
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param id 主键编号
     * @return Result<EraisBeAuditOrganVO>
     */
	@GetMapping("/eraisBeAuditOrgan/get/{id}")
	public Result get(@PathVariable("id") String id) {
		EraisBeAuditOrgan eraisBeAuditOrgan = eraisBeAuditOrganBizService.getById(id);
		return Result.success(eraisBeAuditOrgan);
	}
	/**
	 * 根据id查询(简单对象)
	 *
	 * @author: JW
	 * @date: 2019-08-25 08:06:17
	 * @param id 主键编号
	 * @return Result<EraisBeAuditOrgan>
	 */
	@GetMapping("/eraisBeAuditOrgan/getSimple/{id}")
	public Result getSimple(@PathVariable("id") String id) {
		EraisBeAuditOrgan eraisBeAuditOrgan = eraisBeAuditOrganBizService.getSimpleById(id);
		return Result.success(eraisBeAuditOrgan);
	}
    /**
     * 根据条件查询集合
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param eraisBeAuditOrgan 查询对象
     * @return Result<List<EraisBeAuditOrgan>>
     */
    @PostMapping("/eraisBeAuditOrgan/list")
	public Result list( EraisBeAuditOrgan eraisBeAuditOrgan) {
		List<EraisBeAuditOrgan> list = eraisBeAuditOrganBizService.list(eraisBeAuditOrgan);
		return Result.success(list);
	}
    /**
     * 根据条件分页查询集合
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param eraisBeAuditOrgan 查询对象
     * @return Result<PageData<EraisBeAuditOrgan>>
     */
    @PostMapping("/eraisBeAuditOrgan/page")
	public Result listPage( EraisBeAuditOrgan eraisBeAuditOrgan) {
		TableDataInfo page = eraisBeAuditOrganBizService.listPage(eraisBeAuditOrgan);
		return Result.success(page);
	}
    /**
     * 保存数据
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param eraisBeAuditOrgan
     * @return Result<Object>
     */
	@PostMapping("/eraisBeAuditOrgan/save")
	public Result save( EraisBeAuditOrgan eraisBeAuditOrgan) {
		try {
			eraisBeAuditOrganBizService.save(eraisBeAuditOrgan);
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
     * @date: 2019-08-25 08:06:17
     * @param id 主键编号
     * @return Result<EraisBeAuditOrgan>
     */
	@GetMapping("/eraisBeAuditOrgan/edit/{id}")
	public Result edit(@PathVariable("id") String id) {
		EraisBeAuditOrgan eraisBeAuditOrgan = eraisBeAuditOrganBizService.getById(id);
		return Result.success(eraisBeAuditOrgan);
	}
    /**
     * 根据ID修改
     *
     * @author: JW
     * @date: 2019-08-25 08:06:17
     * @param eraisBeAuditOrgan
	 * @return Result<Object>
     */
	@PostMapping("/eraisBeAuditOrgan/update")
	public Result update( EraisBeAuditOrgan eraisBeAuditOrgan) {
		try {
			eraisBeAuditOrganBizService.update(eraisBeAuditOrgan);
		}catch (Exception e){
			e.getMessage();
			BusinessException cause  = (BusinessException) e;
			String msg = cause.getErrMsg();
			if (StringUtils.isEmpty(msg)){
				msg = "更新失败";
			}
			return  Result.failure(1,msg);
		}
		return Result.success();
	}
	/**
	 * 根据ID删除
	 *
	 * @author: JW
	 * @date: 2019-08-25 08:06:17
	 * @param id 数据ID
	 * @return Result<Object>
	 */
	@PostMapping("/eraisBeAuditOrgan/delete/{id}")
	public Result delete(@PathVariable("id") String id) {
		eraisBeAuditOrganBizService.delete(id);
		return Result.success();
	}
	/**
	 * 导出被审计机构模板
	 */
	@GetMapping("/exportTemplate")
	public void exportTemplate(HttpServletResponse response) {
		String[] title = {"上级部门名称","部门名称","部门编码","是否启用 1：启用 2：禁用","排序"};
		String[] status = {"1","2"};
		String fileName = "被审计机构导入模板.xls";
		String sheetName = "被审计机构";
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setColumnWidth(3, 25 * 256);
		sheet.setColumnWidth(1, 20 * 256);
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFCell cell = null;
		for(int i=0;i<title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		//下拉,参数分别是：作用的sheet、下拉内容数组、起始行、终止行、起始列、终止列
		sheet.addValidationData(ExcelUtil.setDataValidation(sheet, status, 1, 50000, 3 ,3));
		try {
			fileName = new String(fileName.getBytes(),"ISO8859-1");
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e)
		{
			logger.error("被审计机构导入模板失败"+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 导入被审计机构
	 *
	 * @param multipartFile
	 * @return 返回校验失败的数据
	 */
	@PostMapping("/uploadExcel")
	public Result uploadExcel(@RequestParam(value = "fileName") MultipartFile multipartFile) {
		//先判断文件是否为空
		List<EraisBeAuditOrgan> resList =  new ArrayList<EraisBeAuditOrgan>();
		String message = "";
		if(multipartFile == null){
			message = "上传文件为空";
			Result.failure(1,message);
		}
		//获取文件名
		String fileName = multipartFile.getOriginalFilename();
		//检查文件是否为excel，是否为2003版本，或者为2007版本
		boolean excel2003 = fileName.matches("^.+\\.(?i)(xls)$");
		boolean excel2007 = fileName.matches("^.+\\.(?i)(xlsx)$");
		if(!excel2003 && !excel2007){
			message = "上传文件格式不正确，必须为excel格式";
			Result.failure(1,message);
		}
		//再判断文件内容是否为空
		long size = multipartFile.getSize();
		if(StringUtils.isEmpty(fileName) || size == 0){
			message = "上传文件内容为空";
			Result.failure(1,message);
		}
		//开始解析excel数据
		Workbook wb = null;
		InputStream file = null;
		try {
			file = multipartFile.getInputStream();
			file = multipartFile.getInputStream();
			ExcelUtil<EraisBeAuditOrgan> excelUtil = new ExcelUtil<EraisBeAuditOrgan>(EraisBeAuditOrgan.class);
			List<EraisBeAuditOrgan> list = excelUtil.importExcel("", file);
			for(int i=0;i<list.size();i++){
				System.out.println(list.size());
				EraisBeAuditOrgan eraisBeAuditOrgan =  list.get(i);
				Map<String, Object> errorMap =  validator.validators(eraisBeAuditOrgan);
				if (Integer.parseInt(errorMap.get("code").toString())>0){
					resList.add(eraisBeAuditOrgan);
				}else{
					try {
						eraisBeAuditOrganBizService.save(eraisBeAuditOrgan);
					}catch (Exception e){
						resList.add(eraisBeAuditOrgan);
					}
				}
			}
		}catch (Exception e){
			e.getMessage();
			Result.failure(1,"导入失败");
		}
		return Result.success(resList);
	}
<<<<<<< HEAD
=======
	/**
	 *  @param ids
	 * @return Result
	 */
	@GetMapping("/eraisBeAuditOrgan/deleteBatch")
	public Result deleteBatch(@RequestParam(value = "ids") String  ids){
		try {
			if (StringUtils.isEmpty(ids)) {
				return Result.failure(1,"请求列表为空");
			}
			List<String> idsList = com.crv.erais.common.StringUtils.strSplit(ids);
			eraisBeAuditOrganBizService.deleteBatch(idsList);
		}catch (Exception e){
			e.getMessage();
			logger.error("删除被审计机构失败"+e.getMessage());
			return Result.failure(1,"删除被审计机构失败");
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
	@GetMapping("/eraisBeAuditOrgan/updateStatus")
	public Result updateStatus(@RequestParam("id") String id, @RequestParam("status")  int status) {
		EraisBeAuditOrgan beAuditOrgan = new EraisBeAuditOrgan();
		beAuditOrgan.setId(id);
		beAuditOrgan.setStatus(status);
		eraisBeAuditOrganBizService.updateStatus(beAuditOrgan);
		return Result.success();
	}
>>>>>>> a577cdc70f21af6be6195da512eb9a8ad0a02829
}
