/**
 * 
 */
package com.taobao.inventory.common.process.test;

import com.taobao.inventory.common.process.HandlerChain;
import com.taobao.inventory.common.process.test.handlers.Demo1Handler;
import com.taobao.inventory.common.process.test.handlers.Demo2Handler;
import com.taobao.inventory.common.process.test.handlers.Demo5Handler;
import com.taobao.inventory.common.process.test.handlers.DemoCompositeHandler;
import com.taobao.inventory.common.process.test.interceptors.DemoInterceptor;

/**
 * @author Chris
 * @param <T>
 * 
 */
public class DemoChain {

	public static void main(String[] args) {
		HandlerChain<String> chain = new HandlerChain<String>();

		// ��װchain��֧��Composite������tmallbuy��branch
		chain.appendHandler(new Demo1Handler())
				.appendHandler(new Demo2Handler())
				.appendHandler(new DemoCompositeHandler())
				.appendHandler(new Demo5Handler());
				
		// ������
		chain.appendInterceptor(new DemoInterceptor());
		
		chain.handle(null, "Hello World!");
	}
}
