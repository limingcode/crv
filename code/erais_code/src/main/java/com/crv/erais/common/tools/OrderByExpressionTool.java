package com.crv.erais.common.tools;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 排序表达式工具
 * 
 */
public class OrderByExpressionTool {

	/**
	 *  获取排序表达式
	 * 
	 * @param orderByColumnMap
	 * @return java.lang.String
	 */
	public static String getOrderByExpression(Map<String, String> orderByColumnMap) {
		if (MapUtils.isEmpty(orderByColumnMap)) {
			return null;
		}
		StringBuilder sb = new StringBuilder(" ORDER BY");
		Set<String> keySet = orderByColumnMap.keySet();
		Iterator<String> ite = keySet.iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			String value = orderByColumnMap.get(key);
			if (StringUtils.isBlank(key)) {
				continue;
			}
			if (StringUtils.isBlank(value)) {
				continue;
			}
			sb.append(" ").append(key);
			sb.append(" ").append(value.toUpperCase());
			sb.append(",");
		}
		String orderByExpression = sb.toString();
		orderByExpression = orderByExpression.substring(0, orderByExpression.length() - 1);
		return orderByExpression;
	}
}
