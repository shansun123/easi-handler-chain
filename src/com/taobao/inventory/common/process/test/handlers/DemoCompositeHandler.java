/**
 * 
 */
package com.taobao.inventory.common.process.test.handlers;

import com.taobao.inventory.common.process.config.HandlerConfig;
import com.taobao.inventory.common.process.handler.CompositeHandler;

/**
 * @author Chris
 *
 */
public class DemoCompositeHandler extends CompositeHandler<String> {

	public DemoCompositeHandler() {
		appendHandler(new Demo3Handler()).appendHandler(new Demo4Handler());
	}
	
	@Override
	public boolean canHandle(String param) {
		return true;
	}

	@Override
	public HandlerConfig<String> getConfig() {
		return null;
	}

}
