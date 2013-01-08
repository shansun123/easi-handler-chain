/**
 * 
 */
package com.taobao.inventory.common.process.config;

import com.taobao.inventory.common.process.HandleResult;
import com.taobao.inventory.common.process.context.AbstractContext;

/**
 * <pre>
 * ������·��������Ϣ
 * </pre>
 * 
 * @author Chris
 */
public class HandlerChainConfig extends AbstractContext implements Configuable {
	
	/** 
	 * �����쳣�Ƿ���ֹ�����false����chain��ִ���꣬�����쳣�ռ���ExceptionList�� 
	 */
	boolean stopOnException = true;
	
	/**
	 * Handler����{@link HandleResult#success}=falseʱ���Ƿ��˳�ִ�������� 
	 */
	boolean stopOnFailure = true;
	
	/** 
	 * Ĭ������ 
	 */
	private final static HandlerChainConfig DEFAULT_CONFIG = new HandlerChainConfig();
	
	private HandlerChainConfig() {}

	public HandlerChainConfig config() {
		return new HandlerChainConfig();
	}
	
	/**
	 * �����쳣�Ƿ���ֹ
	 * @return
	 */
	public boolean isStopOnException() {
		return stopOnException;
	}

	/**
	 * ���������쳣�Ƿ���ֹ
	 * @param stopOnException
	 */
	public void setStopOnException(boolean stopOnException) {
		this.stopOnException = stopOnException;
	}

	/**
	 * ����ʧ�ܣ��Ƿ��˳�ִ�������� 
	 * @return
	 */
	public boolean isStopOnFailure() {
		return stopOnFailure;
	}

	/**
	 * ��������ʧ�ܣ��Ƿ��˳�ִ�������� 
	 * @param stopOnFailure
	 */
	public void setStopOnFailure(boolean stopOnFailure) {
		this.stopOnFailure = stopOnFailure;
	}
	
	/**
	 * ��ȡĬ������
	 * @return
	 */
	public static HandlerChainConfig getDefault() {
		return DEFAULT_CONFIG;
	}
}
