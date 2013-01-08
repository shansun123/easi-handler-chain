/**
 * 
 */
package com.taobao.inventory.common.process.handler;

import com.taobao.inventory.common.process.HandleResult;

/**
 * ����ڵ������
 * 
 * @author Chris
 * @param <T>
 */
public abstract class AbstractHandler<T> implements Handler<T> {
	/**
	 * ��ǰ�ڵ㴦����ɺ���һ������ڵ㡣��������֧�ֽڵ����ת��
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
