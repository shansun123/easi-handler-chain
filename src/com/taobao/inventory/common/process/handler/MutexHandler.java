/**
 * 
 */
package com.taobao.inventory.common.process.handler;

import java.util.ArrayList;
import java.util.List;

import com.taobao.inventory.common.process.HandleResult;

/**
 * @author Chris
 * 
 */
public abstract class MutexHandler<T> implements Handler<T> {
	private List<Handler<T>> handlers = new ArrayList<Handler<T>>();

	@Override
	public void handle(T param, HandleResult result) {
		for (Handler<T> handler : handlers) {
			if (handler.canHandle(param)) {
				handler.handle(param, result);
				break;
			}
		}
	}
}
