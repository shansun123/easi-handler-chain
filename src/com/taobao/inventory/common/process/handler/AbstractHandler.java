/**
 * 
 */
package com.taobao.inventory.common.process.handler;

import com.taobao.inventory.common.process.HandleResult;

/**
 * 处理节点抽象类
 * 
 * @author Chris
 * @param <T>
 */
public abstract class AbstractHandler<T> implements Handler<T> {
	/**
	 * 当前节点处理完成后，下一个处理节点。这样就能支持节点间跳转。
	 */
	private Handler<T> _successor;
	
	public AbstractHandler<T> successor(Handler<T> successor) {
		this._successor = successor;
		return this;
	}

	public Handler<T> successor() {
		return _successor;
	}

	@Override
	public void handle(T param, HandleResult result) {
		bizHandle(param, result);
	}
	
	public abstract void bizHandle(T param, HandleResult result);
}
