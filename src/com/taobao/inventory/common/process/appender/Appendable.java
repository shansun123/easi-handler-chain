/**
 * 
 */
package com.taobao.inventory.common.process.appender;

import com.taobao.inventory.common.process.handler.Handler;
import com.taobao.inventory.common.process.interceptor.HandlerInterceptor;

/**
 * @author Chris
 * 
 */
public interface Appendable<T> {
	
	Appendable<T> appendHandler(Handler<T> handler);
	
	Appendable<T> appendHandler(Handler<T> handler, Handler<T> successor);
	
	Appendable<T> appendInterceptor(HandlerInterceptor<T> interceptor);
}
