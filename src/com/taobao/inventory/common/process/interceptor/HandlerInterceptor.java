/**
 * 
 */
package com.taobao.inventory.common.process.interceptor;

import com.taobao.inventory.common.process.HandleResult;
import com.taobao.inventory.common.process.handler.Handler;

/**
 * @author Chris
 */
public interface HandlerInterceptor<T> {

	void beforeHandle(T param, Handler<T> handler, HandleResult result);

	void afterHandle(T param, Handler<T> handler, HandleResult result);

	void errorHandle(T param, Handler<T> handler, HandleResult result);

	void finalHandle(T param, Handler<T> handler, HandleResult result);
}
