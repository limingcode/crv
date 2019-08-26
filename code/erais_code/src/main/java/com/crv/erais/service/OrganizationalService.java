package com.crv.erais.service;

import com.crv.erais.common.tools.TableDataInfo;
import com.crv.erais.model.Organizational;

import java.util.List;

/**
 * 组织机构
 */
public interface OrganizationalService {
	/**
	 * 获取所有组织机构
	 * @return List<Organizational>
	 */
	public List<Organizational> getListOrg();
	/**
	 * 分页获取组织机构
	 * @return TableDataInfo
	 */
	public TableDataInfo pageList(Organizational org);

	/**
	 * 根据ID获取
	 * @param id
	 * @return Organizational
	 */
	public Organizational getById(String id);
}
