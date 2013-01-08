/**
 * 
 */
package com.taobao.inventory.common.process.handler;

import java.util.ArrayList;
import java.util.List;

import com.taobao.inventory.common.process.HandleResult;
import com.taobao.inventory.common.process.appender.Appendable;
/**
 * @author Chris
 * 
 */
public abstract class MutexHandler<T> extends AbstractHandler<T> implements Appendable<T> {
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
