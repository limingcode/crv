package com.crv.erais.common.exception;

import lombok.Data;

/**
 * 业务运行时异常类
 */
@Data
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -7130339879784996462L;

	/**
	 * 错误编码
	 */
	private Integer errCode;

	/**
	 * 错误信息
	 */
	private String errMsg;

	/**
	 * 需要传递的数据
	 */
	private Object data;

	public BusinessException(Integer errCode) {
		this.errCode = errCode;
	}

	public BusinessException(String errMsg) {
		this.errMsg = errMsg;
	}

	public BusinessException(Integer errCode, Object data) {
		this.errCode = errCode;
		this.data = data;
	}

	public BusinessException(Integer errCode, String errMsg, Object data) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.data = data;
	}

	public BusinessException(Integer errCode, String errMsg) {
		this(errCode, errMsg, null);
	}

	public BusinessException(Integer errCode, String errMsg, Object data, Throwable throwable) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.data = data;
	}

	public BusinessException(Integer errCode, String errMsg, Throwable throwable) {
		this(errCode, errMsg, null, throwable);
	}
}
