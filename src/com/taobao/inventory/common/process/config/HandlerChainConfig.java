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
	
	/** �����쳣�Ƿ���ֹ�����false����chain��ִ���꣬�����쳣�ռ���ExceptionList�� */
	boolean stopOnException = true;
	
	/** Handler����{@link HandleResult#success}=falseʱ���Ƿ��˳�ִ�������� */
	boolean stopOnFailure = true;
	
	/** Ĭ������ */
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
