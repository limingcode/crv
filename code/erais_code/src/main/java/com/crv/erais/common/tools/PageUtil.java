package com.crv.erais.common.tools;

import com.crv.erais.common.StringUtils;
import com.crv.erais.model.BaseEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
/**
 *分页组件
 */
public class PageUtil {
    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     *分页
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @param orderBy orderBy
     */
    public static void startPage(Integer pageNum,Integer pageSize,String orderBy)
    {
        PageHelper.startPage(pageNum, pageSize, orderBy);
    }

    /**
     * 分页
     * @param entity entity
     */
    public static void startPage(BaseEntity entity)
    {
        String orderBy = StringUtils.isEmpty(entity.getOrderByColumn())?"":(StringUtils.toUnderScoreCase(entity.getOrderByColumn()) + " " + entity.getIsAsc());
        PageHelper.orderBy(orderBy);
        if(StringUtils.isNotNull(entity.getPageNum()) && StringUtils.isNotNull(entity.getPageNum())){
            PageHelper.startPage(entity.getPageNum(),entity.getPageSize());
        }
    }
}
