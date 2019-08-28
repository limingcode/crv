package com.crv.erais.controller;

import com.crv.erais.common.base.BaseController;
import com.crv.erais.common.exception.BusinessException;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.common.utils.ExcelUtil;
import com.crv.erais.common.utils.ValidatorUtils;
import com.crv.erais.model.EraisAuditOrgan;
import com.crv.erais.model.common.Result;
import com.crv.erais.service.EraisAuditOrganService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 审计机构
 */
@RestController
@RequestMapping("/crv/auditOrgan")
public class EraisAuditOrganController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(EraisAuditOrganController.class);

    @Autowired
    private EraisAuditOrganService eraisAuditOrganService;
    @Autowired
    private ValidatorUtils validator;
    /**
     * 获取所有
     * @return
     */
    @PostMapping("/page")
    public Result getPageList(EraisAuditOrgan organ) {
        TableDataInfo info = eraisAuditOrganService.getPageList(organ);
        return Result.success(info);
    }
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable("id") String Id) {
        if (StringUtils.isEmpty(Id))
        {
            logger.error("检测到审计机构ID为空ID"+Id);
            return  Result.failure(1,"Id不能为空");
        }
        EraisAuditOrgan organ = eraisAuditOrganService.getById(Id);
        return Result.success(organ);
    }
    @GetMapping("/delete")
    public Result deleteById(String Id) {
        if (StringUtils.isEmpty(Id))
        {
            logger.error("检测到审计机构ID为空ID"+Id);
            return  Result.failure(1,"Id不能为空");
        }
        eraisAuditOrganService.deleteById(Id);
        return Result.success();
    }
    /**
     * 无分页
     * @param organ
     * @return
     */
    @PostMapping("/list")
    public Result getList(EraisAuditOrgan organ) {
        List<EraisAuditOrgan> list = eraisAuditOrganService.getList(organ);
        return Result.success(list);
    }
    /**
     * 新增
     * @param organ
     * @return Result
     */
    //@PostMapping("/save")
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public Result save(EraisAuditOrgan organ) {
        try {
            eraisAuditOrganService.save(organ);
        }catch (Exception e)
        {
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
     * 更新
     * @param organ
     * @return Result
     */
    @PostMapping("/update")
    public Result update(EraisAuditOrgan organ) {
        if(StringUtils.isEmpty(organ.getId()))
        {
            return  Result.failure(1,"ID不能为空");
        }
        try {
            eraisAuditOrganService.update(organ);
        }catch (Exception e)
        {
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
     * 导出模板
     */
    @GetMapping("/exportTemplate")
    public void exportTemplate(HttpServletResponse response) {
        String[] title = {"机构名称","编号","排序","是否启用 1：启用 2：禁用","上级机构","负责人","负责人ID","电话"};
        String[] status = {"1","2"};
        String fileName = "审计机构导入模板.xls";
        String sheetName = "审计机构";
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);
        sheet.setColumnWidth(3, 25 * 256);
        sheet.setColumnWidth(1, 15 * 256);
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
            logger.error("审计机构导入模板失败"+e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 导入
     *
     * @param multipartFile
     * @return 返回校验失败的数据
     */
    @PostMapping("/uploadExcel")
    public Result uploadExcel(@RequestParam(value = "fileName") MultipartFile multipartFile) {
        //先判断文件是否为空
        List<EraisAuditOrgan> resList =  new ArrayList<EraisAuditOrgan>();
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
            ExcelUtil<EraisAuditOrgan> excelUtil = new ExcelUtil<EraisAuditOrgan>(EraisAuditOrgan.class);
            List<EraisAuditOrgan> list = excelUtil.importExcel("", file);
            for(int i=0;i<list.size();i++){
                System.out.println(list.size());
                EraisAuditOrgan organ =  list.get(i);
                Map<String, Object> errorMap =  validator.validators(organ);
                if (Integer.parseInt(errorMap.get("code").toString())>0){
                    resList.add(organ);
                }else{
                    try {
                        eraisAuditOrganService.save(organ);
                    }catch (Exception e){
                        resList.add(organ);
                    }
                }
            }
        }catch (Exception e){
            e.getMessage();
            Result.failure(1,"导入失败");
        }
        return Result.success(resList);
    }
    /**
     *  @param ids
     * @return Result
     */
    @GetMapping("/deleteBatch")
    public Result deleteBatch(@RequestParam(value = "ids") String  ids){
        try {
            if (StringUtils.isEmpty(ids)) {
                return Result.failure(1,"请求列表为空");
            }
            List<String> idsList = com.crv.erais.common.StringUtils.strSplit(ids);
            eraisAuditOrganService.deleteBatch(idsList);
        }catch (Exception e){
            e.getMessage();
            logger.error("删除审计机构失败"+e.getMessage());
            return Result.failure(1,"删除审计机构失败");
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
    @GetMapping("/updateStatus")
    public Result updateStatus(@RequestParam("id") String id, @RequestParam("status")  int status) {
        EraisAuditOrgan eraisAuditOrgan = new EraisAuditOrgan();
        eraisAuditOrgan.setId(id);
        eraisAuditOrgan.setStatus(status);
        eraisAuditOrganService.updateStatus(eraisAuditOrgan);
        return Result.success();
    }
}
