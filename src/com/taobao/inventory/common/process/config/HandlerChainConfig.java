/**
 * 
 */
package com.taobao.inventory.common.process.config;

import com.taobao.inventory.common.process.HandleResult;
import com.taobao.inventory.common.process.context.AbstractContext;

/**
 * @author Chris
 * 
 */
public class HandlerChainConfig extends AbstractContext implements Configuable {
	
	/** 遇到异常是否终止，如果false，则chain会执行完，并将异常收集到ExceptionList中 */
	boolean stopOnException = true;
	
	/** Handler返回{@link HandleResult#success}=false时，是否退出执行责任链 */
	boolean stopOnFailure = true;
	
	/** 默认配置 */
	private final static HandlerChainConfig DEFAULT_CONFIG = new HandlerChainConfig();
	
	private HandlerChainConfig() {}

	public HandlerChainConfig config() {
		return new HandlerChainConfig();
	}
	
	public boolean isStopOnException() {
		return stopOnException;
	}

	public void setStopOnException(boolean stopOnException) {
		this.stopOnException = stopOnException;
	}

	public boolean isStopOnFailure() {
		return stopOnFailure;
	}

	public void setStopOnFailure(boolean stopOnFailure) {
		this.stopOnFailure = stopOnFailure;
	}
	
	public static HandlerChainConfig getDefault() {
		return DEFAULT_CONFIG;
	}
}
