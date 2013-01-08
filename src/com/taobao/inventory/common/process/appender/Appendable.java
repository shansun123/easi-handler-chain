/**
 * 
 */
package com.taobao.inventory.common.process.appender;

import com.taobao.inventory.common.process.HandlerChain;
import com.taobao.inventory.common.process.handler.CompositeHandler;
import com.taobao.inventory.common.process.handler.Handler;
import com.taobao.inventory.common.process.handler.MutexHandler;
import com.taobao.inventory.common.process.interceptor.HandlerInterceptor;

/**
 * <pre>
 * ��ʶĳ�����Ƿ�֧����Ӵ���ڵ�
 * </pre>
 * 
 * Ŀǰ֧�ָ����Ե����У�
 * <li>{@link HandlerChain}</li> 
 * <li>{@link CompositeHandler}</li>
 * <li>{@link MutexHandler}</li>
 * 
 * @author Chris
 */
public interface Appendable<T> {

	/**
	 * ���һ������ڵ�
	 * 
	 * @param handler ����ڵ�
	 * @return
	 */
	Appendable<T> appendHandler(Handler<T> handler);

	/**
	 * ���һ������ڵ㣬��ָ���ýڵ����һ���ڵ�
	 * 
	 * @param handler ����ڵ�
	 * @param successor �ýڵ����һ���ڵ�
	 * @return
	 */
	Appendable<T> appendHandler(Handler<T> handler, Handler<T> successor);

	/**
	 * ���һ������������������������Ӧ�õ�{@link HandlerChain}��ÿһ������ڵ�
	 * @param interceptor ������
	 * @return
	 */
	Appendable<T> appendInterceptor(HandlerInterceptor<T> interceptor);
}
