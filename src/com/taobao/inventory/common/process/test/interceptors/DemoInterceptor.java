/**
 * 
 */
package com.taobao.inventory.common.process.test.interceptors;

import com.taobao.inventory.common.process.HandleResult;
import com.taobao.inventory.common.process.handler.Handler;
import com.taobao.inventory.common.process.interceptor.HandlerInterceptor;

/**
 * @author Chris
 * @param <T>
 *
 */
public class DemoInterceptor implements HandlerInterceptor<String> {

	@Override
	public void beforeHandle(String param, Handler<String> handler, HandleResult result) {
		System.out.println("[" + handler.getClass().getSimpleName() + "]BEFORE: param=" + param);
	}

	@Override
	public void afterHandle(String param, Handler<String> handler, HandleResult result) {
		System.out.println("[" + handler.getClass().getSimpleName() + "]AFTER: param=" + param);		
	}

	@Override
	public void errorHandle(String param, Handler<String> handler, HandleResult result) {
		System.out.println("[" + handler.getClass().getSimpleName() + "]ERROR: param=" + param);		
	}

	@Override
	public void finalHandle(String param, Handler<String> handler, HandleResult result) {
		System.out.println("[" + handler.getClass().getSimpleName() + "]FINAL: param=" + param);		
	}

}
