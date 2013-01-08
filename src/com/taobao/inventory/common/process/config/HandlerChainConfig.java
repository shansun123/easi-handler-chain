/**
 * 
 */
package com.taobao.inventory.common.process.config;

import com.taobao.inventory.common.process.HandleResult;
import com.taobao.inventory.common.process.context.AbstractContext;

/**
 * <pre>
 * 处理链路的配置信息
 * </pre>
 * 
 * @author Chris
 */
public class HandlerChainConfig extends AbstractContext implements Configuable {
	
	/** 
	 * 遇到异常是否终止，如果false，则chain会执行完，并将异常收集到ExceptionList中 
	 */
	boolean stopOnException = true;
	
	/**
	 * Handler返回{@link HandleResult#success}=false时，是否退出执行责任链 
	 */
	boolean stopOnFailure = true;
	
	/** 
	 * 默认配置 
	 */
	private final static HandlerChainConfig DEFAULT_CONFIG = new HandlerChainConfig();
	
	private HandlerChainConfig() {}

	public HandlerChainConfig config() {
		return new HandlerChainConfig();
	}
	
	/**
	 * 遇到异常是否终止
	 * @return
	 */
	public boolean isStopOnException() {
		return stopOnException;
	}

	/**
	 * 设置遇到异常是否终止
	 * @param stopOnException
	 */
	public void setStopOnException(boolean stopOnException) {
		this.stopOnException = stopOnException;
	}

	/**
	 * 遇到失败，是否退出执行责任链 
	 * @return
	 */
	public boolean isStopOnFailure() {
		return stopOnFailure;
	}

	/**
	 * 设置遇到失败，是否退出执行责任链 
	 * @param stopOnFailure
	 */
	public void setStopOnFailure(boolean stopOnFailure) {
		this.stopOnFailure = stopOnFailure;
	}
	
	/**
	 * 获取默认配置
	 * @return
	 */
	public static HandlerChainConfig getDefault() {
		return DEFAULT_CONFIG;
	}
}
