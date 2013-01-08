/**
 * 
 */
package com.taobao.inventory.common.process.config;

import com.taobao.inventory.common.process.context.AbstractContext;

/**
 * @author Chris
 * 
 */
public class HandlerConfig<T> extends AbstractContext implements Configuable {
	private boolean ignoreException = false;
	
	private boolean refuseInterceptor = false;

	static private HandlerConfig<Object> DEFAULT_CONFIG = new HandlerConfig<Object>();

	private HandlerConfig() {
	}

	public HandlerConfig<T> config() {
		return new HandlerConfig<T>();
	}

	public static HandlerConfig<Object> getDefault() {
		return DEFAULT_CONFIG;
	}
 
	public boolean isIgnoreException() {
		return ignoreException;
	}

	public HandlerConfig<T> setIgnoreException(boolean ignoreException) {
		this.ignoreException = ignoreException;
		return this;
	}

	public boolean isRefuseInterceptor() {
		return refuseInterceptor;
	}

	public void setRefuseInterceptor(boolean refuseInterceptor) {
		this.refuseInterceptor = refuseInterceptor;
	}
}
