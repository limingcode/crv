package com.crv.erais.dao;

import com.crv.erais.model.Organizational;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
/**
 * 组织机构
 */
public interface OrganizationalMapper {

	/**
	 * 获取所有组织机构
	 * @return List<Organizational>
	 */
	public List<Organizational> list();
	/**
	 * 分页组织机构
	 * @return List<Organizational>
	 */
	public List<Organizational> pageList(Organizational org);
}
