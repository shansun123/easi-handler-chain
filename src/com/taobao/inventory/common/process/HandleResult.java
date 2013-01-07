/**
 * 
 */
package com.taobao.inventory.common.process;

import java.util.ArrayList;
import java.util.List;

import com.taobao.inventory.common.process.config.HandlerChainConfig;
import com.taobao.inventory.common.process.context.AbstractContext;

/**
 * @author Chris
 * 
 */
public class HandleResult extends AbstractContext {

	/** 是否成功 */
	boolean success = true;

	/** 错误编码 */
	String errorCode = null;

	/** 错误信息 */
	String errorMessage = null;

	/** 如果设置 {@link HandlerChainConfig#stopOnException} = false，则异常列表可以大于1. */
	List<Throwable> exceptions = new ArrayList<Throwable>();

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<Throwable> getExceptions() {
		return exceptions;
	}

	public void setExceptions(List<Throwable> exceptions) {
		this.exceptions = exceptions;
	}
}
