package com.crv.erais.common.base;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础Mapper
 * 
 *  @author jw
 * @date 2019/8/19 20:57
 */
@Mapper
public interface BaseMapper<QO> {

	/**
	 * 根据ID查询详情
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param id
	 * @return PO
	 */
	QO getById(String id);

	/**
	 * 根据条件查询详情
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return PO
	 */
	QO getByCondition(QO qo);

	/**
	 * 根据条件查询集合
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return java.util.List<PO>
	 */
	List<QO> list(QO qo);

	/**
	 * 根据ID集合查询集合
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param ids
	 * @return java.util.List<PO>
	 */
	List<QO> listByIds(@Param("items") List<String> ids);

	/**
	 * 保存
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return void
	 */
	void save(QO qo);

	/**
	 * 批量保存
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param poList
	 * @return void
	 */
	void saveBatch(@Param("items") List<QO> poList);

	/**
	 * 根据ID修改
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return void
	 */
	void update(QO qo);

	/**
	 * 根据ID批量修改
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param poList
	 * @return void
	 */
	void updateBatch(@Param("items") List<QO> poList);

	/**
	 * 根据ID选择性修改(只修改不为空的字段)
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return void
	 */
	void updateSelective(QO qo);

	/**
	 * 根据ID批量选择性修改(只修改不为空的字段)
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param poList
	 * @return void
	 */
	void updateBatchSelective(@Param("items") List<QO> poList);

	/**
	 * 根据ID删除
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param id
	 * @return void
	 */
	void delete(String id);

	/**
	 * 根据ID批量删除
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param ids
	 * @return void
	 */
	void deleteBatch(@Param("items") List<String> ids);

	/**
	 * 根据条件统计数量
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return long
	 */
	long count(QO qo);
}
