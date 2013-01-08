/**
 * 
 */
package com.taobao.inventory.common.process.handler;

import java.util.ArrayList;
import java.util.List;

import com.taobao.inventory.common.process.HandleResult;
import com.taobao.inventory.common.process.appender.Appendable;
import com.taobao.inventory.common.process.interceptor.HandlerInterceptor;

/**
 * <pre>
 * 组装多个处理节点，可以理解为启动一条子链。
 * </pre>
 * 
 * @author Chris
 */
public abstract class CompositeHandler<T> extends AbstractHandler<T> implements Appendable<T> {
 
	private List<Handler<T>> handlers = new ArrayList<Handler<T>>();
	
	@Override
	public void handle(T param, HandleResult result) {
		for(Handler<T> handler : handlers) {
			if(handler.canHandle(param)) {
				handler.handle(param, result);
			}
		}
	}
	
	@Override
	public Appendable<T> appendHandler(Handler<T> handler) {
		handlers.add(handler);
		return this;
	}

	@Override
	public Appendable<T> appendHandler(Handler<T> handler, Handler<T> successor) {
		throw new UnsupportedOperationException("Unsupported right now, u can implement the method, if in need!");
	}
	
	@Override
	public Appendable<T> appendInterceptor(HandlerInterceptor<T> interceptor) {
		throw new UnsupportedOperationException("Unsupported right now, u can implement the method, if in need!");
	}

	@Override
	public void bizHandle(T param, HandleResult result) {
		// DO NOTHING
	}
}
