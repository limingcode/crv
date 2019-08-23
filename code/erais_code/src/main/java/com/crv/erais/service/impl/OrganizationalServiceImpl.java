package com.crv.erais.service.impl;

import com.crv.erais.common.tools.PageUtil;
import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.dao.OrganizationalMapper;
import com.crv.erais.model.Organizational;
import com.crv.erais.service.OrganizationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
/**
 * 组织机构
 */
public class OrganizationalServiceImpl implements OrganizationalService {
	@Autowired
	/**
	 * 组织机构mapper 接口对象
	 */
	private OrganizationalMapper orgMapper;

	/**
	 * 获取所有组织机构
	 * @return List<Organizational>
	 */
	public List<Organizational> getListOrg()
	{
		List<Organizational> list = new ArrayList<Organizational>();
		try {
		    list = orgMapper.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return list;
	}
	/**
	 * 分页获取组织机构
	 * @return TableDataInfo
	 */
	public TableDataInfo pageList(Organizational org) {
		PageUtil.startPage(org);
		List<Organizational> data =  orgMapper.pageList(org);
		return PageUtil.getDataTable(data);
	}
}
