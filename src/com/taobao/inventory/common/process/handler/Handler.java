/**
 * 
 */
package com.taobao.inventory.common.process.handler;

import com.taobao.inventory.common.process.HandleResult;
import com.taobao.inventory.common.process.config.HandlerConfig;

/**
 * @author Chris
 */
public interface Handler<T> {

	boolean canHandle(T param);

	void handle(T param, HandleResult result);

	Handler<T> successor();
	
	Handler<T> successor(Handler<T> successor);
	
	HandlerConfig<T> getConfig();
}
