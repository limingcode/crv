package com.crv.erais.common.base;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 基础数据接口
 *
 * @author jw
 * @date 2019/8/19 20:57
 */

public class BaseService<QO> {

	/**
	 * 批量操作一次提交的数量
	 */
	private static final int ONCE_SUBMIT_NUM = 1000;

	private BaseMapper<QO> mapper;

	public BaseService(BaseMapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * 截取集合
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param list
	 * @param i
	 * @param remainder
	 * @param count
	 * @return java.util.List
	 */
	private <T> List<T> getSubList(List<T> list, int i, int remainder, int count) {
		int start = i * ONCE_SUBMIT_NUM;
		int end = start + ONCE_SUBMIT_NUM;
		if (remainder != 0 && (i == count - 1)) {
			end = start + remainder;
		}
		return list.subList(start, end);
	}

	/**
	 * 根据ID查询详情
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param id
	 * @return PO
	 */
	public QO getById(String id) {
		if (id == null) {
			return null;
		}
		return mapper.getById(id);
	}

	/**
	 * 根据条件查询详情
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return PO
	 */
	public QO getByCondition(QO qo) {
		if (qo == null) {
			return null;
		}
		return mapper.getByCondition(qo);
	}

	/**
	 * 根据条件查询集合
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return java.util.List<PO>
	 */
	public List<QO> list(QO qo) {
		if (qo == null) {
			return null;
		}
		return mapper.list(qo);
	}

	/**
	 * 根据ID集合查询集合
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param ids
	 * @return java.util.List<QO>
	 */
	public List<QO> listByIds(List<String> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return null;
		}
		return mapper.listByIds(ids);
	}

	/**
	 * 保存
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return void
	 */
	public void save(QO qo) {
		if (qo == null) {
			return;
		}
		mapper.save(qo);
	}

	/**
	 * 批量保存
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param poList
	 * @return void
	 */
	public void saveBatch(List<QO> poList) {
		if (CollectionUtils.isEmpty(poList)) {
			return;
		}
		int size = poList.size();
		if (size > ONCE_SUBMIT_NUM) {
			int count = size / ONCE_SUBMIT_NUM;
			int remainder = size % ONCE_SUBMIT_NUM;
			if (remainder != 0) {
				count = count + 1;
			}
			for (int i = 0; i < count; i++) {
				mapper.saveBatch(this.getSubList(poList, i, remainder, count));
			}
		} else {
			mapper.saveBatch(poList);
		}
	}

	/**
	 * 根据ID修改
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return void
	 */
	public void update(QO qo) {
		if (qo == null) {
			return;
		}
		mapper.update(qo);
	}

	/**
	 * 根据ID批量修改
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param poList
	 * @return void
	 */
	public void updateBatch(List<QO> poList) {
		if (CollectionUtils.isEmpty(poList)) {
			return;
		}
		int size = poList.size();
		if (size > ONCE_SUBMIT_NUM) {
			int count = size / ONCE_SUBMIT_NUM;
			int remainder = size % ONCE_SUBMIT_NUM;
			if (remainder != 0) {
				count = count + 1;
			}
			for (int i = 0; i < count; i++) {
				mapper.updateBatch(this.getSubList(poList, i, remainder, count));
			}
		} else {
			mapper.updateBatch(poList);
		}
	}

	/**
	 * 根据ID选择性修改(只修改不为空的字段)
	 * 
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo
	 * @return void
	 */
	public void updateSelective(QO qo) {
		if (qo == null) {
			return;
		}
		mapper.updateSelective(qo);
	}

	/**
	 * 批量根据ID选择性修改(只修改不为空的字段)
	 *
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param poList 持久对象
	 */
	public void updateSelectiveBatch(List<QO> poList) {
		if (CollectionUtils.isEmpty(poList)) {
			return;
		}
		int size = poList.size();
		if (size > ONCE_SUBMIT_NUM) {
			int count = size / ONCE_SUBMIT_NUM;
			int remainder = size % ONCE_SUBMIT_NUM;
			if (remainder != 0) {
				count = count + 1;
			}
			for (int i = 0; i < count; i++) {
				mapper.updateBatchSelective(this.getSubList(poList, i, remainder, count));
			}
		} else {
			mapper.updateBatchSelective(poList);
		}
	}

	/**
	 * 根据ID删除
	 *
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param id 数据ID
	 */
	public void delete(String id) {
		if (id == null) {
			return;
		}
		mapper.delete(id);
	}

	/**
	 * 根据ID批量删除
	 *
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param ids 数据ID集合
	 */
	public void deleteBatch(List<String> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return;
		}
		int size = ids.size();
		if (size > ONCE_SUBMIT_NUM) {
			int count = size / ONCE_SUBMIT_NUM;
			int remainder = size % ONCE_SUBMIT_NUM;
			if (remainder != 0) {
				count = count + 1;
			}
			for (int i = 0; i < count; i++) {
				mapper.deleteBatch(this.getSubList(ids, i, remainder, count));
			}
		} else {
			mapper.deleteBatch(ids);
		}
	}

	/**
	 * 根据条件统计数量
	 *
	 * @author jw
	 * @date 2019/8/19 20:57
	 * @param qo 查询对象
	 * @return long
	 */
	public long count(QO qo) {
		if (qo == null) {
			return 0;
		}
		return mapper.count(qo);
	}
}
