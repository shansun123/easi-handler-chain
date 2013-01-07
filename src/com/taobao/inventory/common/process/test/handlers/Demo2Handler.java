/**
 * 
 */
package com.taobao.inventory.common.process.test.handlers;

import com.taobao.inventory.common.process.HandleResult;
import com.taobao.inventory.common.process.config.HandlerConfig;
import com.taobao.inventory.common.process.handler.Handler;

/**
 * @author Chris
 *
 */
public class Demo2Handler implements Handler<String> {

	@Override
	public boolean canHandle(String param) {
		return param != null && param.length() > 0;
	}

	@Override
	public void handle(String param, HandleResult result) {
		System.out.println("In Demo2 Handler, param=" + param); 
		result.setSuccess(true);
	}

	@Override
	public HandlerConfig<String> getConfig() {
		return null;
	}

}
