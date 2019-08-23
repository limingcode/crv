package com.crv.erais.model;

import lombok.Data;

@Data
/**
 * 组织机构
 */
public class Organizational {
	/**
	 * id
	 */
    private String id;
	/**
	 * 名称
	 */
    private String name;
	/**
	 * 父节点ID
	 */
    private String parentId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
    
}
