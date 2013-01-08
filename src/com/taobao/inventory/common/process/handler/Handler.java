/**
 * 
 */
package com.taobao.inventory.common.process.handler;

import com.taobao.inventory.common.process.HandleResult;
import com.taobao.inventory.common.process.HandlerChain;
import com.taobao.inventory.common.process.config.HandlerConfig;

/**
 * ����ڵ�
 * 
 * @author Chris
 */
public interface Handler<T> {

	/**
	 * �ýڵ��Ƿ���ܴ���Ĳ�������������ܣ�������ִ��handle�������ݡ�
	 * @param param ����Ĳ���
	 * @return
	 */
	boolean canHandle(T param);

	/**
	 * ������������
	 * @param param ����Ĳ���
	 * @param result ����ʱ����һ���ڵ㴦��������ǰ�ڵ���ɺ󣬼��ǵ�ǰ�ڵ�ִ�н��
	 */
	void handle(T param, HandleResult result);

	/**
	 * ��һ���ڵ㣬����Ϊ�ա����Ϊ�գ�{@link HandlerChain}���Զ�������һ���ڵ�
	 * @return
	 */
	Handler<T> successor();
	
	/**
	 * ������һ���ڵ�
	 * @param successor
	 * @return
	 */
	Handler<T> successor(Handler<T> successor);
	
	/**
	 * �ڵ�������Ϣ
	 * @return
	 */
	HandlerConfig<T> getConfig();
}
