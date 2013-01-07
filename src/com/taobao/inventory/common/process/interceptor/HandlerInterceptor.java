/**
 * 
 */
package com.taobao.inventory.common.process.interceptor;

import com.taobao.inventory.common.process.HandleResult;

/**
 * @author Chris
 */
public interface HandlerInterceptor<T> {

	void beforeHandle(T param, HandleResult result);

	void afterHandle(T param, HandleResult result);

	void errorHandle(T param, HandleResult result);

	void finalHandle(T param, HandleResult result);
}
