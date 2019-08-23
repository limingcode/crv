package com.crv.erais.controller;

import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.model.EraisAuditOrgan;
import com.crv.erais.model.common.Result;
import com.crv.erais.service.EraisAuditOrganService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 审计机构
 */
@RestController
@RequestMapping("/crv/auditOrgan")
public class EraisAuditOrganController {

    @Autowired
    private EraisAuditOrganService eraisAuditOrganService;
    /**
     * 获取所有
     * @return
     */
    @PostMapping("/getPageList")
    public Result getPageList(EraisAuditOrgan organ) {
        TableDataInfo info = eraisAuditOrganService.getPageList(organ);
        return Result.success(info);
    }
    @GetMapping("/getById")
    public Result getById(String Id) {
        if (StringUtils.isEmpty(Id))
        {
            return  Result.failure(1,"Id不能为空");
        }
        EraisAuditOrgan organ = eraisAuditOrganService.getById(Id);
        return Result.success(organ);
    }
    @GetMapping("/deleteById")
    public Result deleteById(String Id) {
        if (StringUtils.isEmpty(Id))
        {
            return  Result.failure(1,"Id不能为空");
        }
        eraisAuditOrganService.deleteById(Id);
        return Result.success();
    }
    /**
     * 分页
     * @param organ
     * @return
     */
    @GetMapping("/getList")
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
    public Result save(   EraisAuditOrgan organ) {
        try {
            eraisAuditOrganService.save(organ);
        }catch (Exception e)
        {
            return  Result.failure(1,"保存失败");
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
        try {
            if(StringUtils.isEmpty(organ.getId()))
            {
                return  Result.failure(1,"ID不能为空");
            }
            eraisAuditOrganService.update(organ);
        }catch (Exception e)
        {
            return  Result.failure(1,"更新失败");
        }
        return Result.success();
    }

    /**
     * 导出模板
     */
    @GetMapping("/exportTemplate")
    public void exportTemplate(HttpServletResponse response) {
        String[] title = {"机构名称","编号","排序","是否启用 1：启用 2：禁用"};
        String fileName = "审计机构导入模板.xls";
        String sheetName = "审计机构";
    }

    /**
     * 导入
     *
     * @param multipartFile
     * @return
     */
    @PostMapping("/uploadExcel")
    public Result uploadExcel(@RequestParam(value = "fileName") MultipartFile multipartFile) {

        return Result.success();
    }
}
