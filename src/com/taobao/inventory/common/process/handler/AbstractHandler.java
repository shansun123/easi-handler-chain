/**
 * 
 */
package com.taobao.inventory.common.process.handler;

/**
 * @author Chris
 * @param <T>
 * 
 */
public abstract class AbstractHandler<T> implements Handler<T> {
	private Handler<T> _successor;
	
	public AbstractHandler<T> successor(Handler<T> successor) {
		this._successor = successor;
		return this;
	}

	public Handler<T> successor() {
		return _successor;
	}
}
