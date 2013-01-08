/**
 * 
 */
package com.taobao.inventory.common.process;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.taobao.inventory.common.process.appender.Appendable;
import com.taobao.inventory.common.process.config.HandlerChainConfig;
import com.taobao.inventory.common.process.config.HandlerConfig;
import com.taobao.inventory.common.process.exception.HandleException;
import com.taobao.inventory.common.process.handler.AbstractHandler;
import com.taobao.inventory.common.process.handler.Handler;
import com.taobao.inventory.common.process.interceptor.HandlerInterceptor;

/**
 * @author Chris
 * 
 */
public class HandlerChain<T> implements Appendable<T> {

	private final List<Handler<T>> chain = new ArrayList<Handler<T>>();

	private final List<HandlerInterceptor<T>> interceptors = new ArrayList<HandlerInterceptor<T>>();

	@SuppressWarnings("unchecked")
	public HandleResult handle(HandlerChainConfig config, T param) {
		HandlerChainConfig cfg = null;
		if (config == null) {
			cfg = HandlerChainConfig.getDefault();
		} else {
			cfg = config;
		}

		HandleResult result = new HandleResult();

		Handler<T> currentHandler = null;
		while ((currentHandler = nextHandler(currentHandler)) != null) {
			if (currentHandler.canHandle(param)) {
				HandlerConfig<Object> handlerConfig = (HandlerConfig<Object>) currentHandler.getConfig();
				if (handlerConfig == null) {
					handlerConfig = HandlerConfig.getDefault();
				}

				try {
					intercept(param, currentHandler, result, handlerConfig, Location.BEFORE);

					currentHandler.handle(param, result);

					intercept(param, currentHandler, result, handlerConfig, Location.AFTER);
					
					if (cfg.isStopOnFailure() && !result.success) {
						break;
					}
				} catch (Throwable e) {
					intercept(param, currentHandler, result, handlerConfig, Location.EXCEPTION);

					if (handlerConfig.isIgnoreException()) {
						continue;
					}

					if (cfg.isStopOnException()) {
						result.success = false;
						break;
					} else {
						result.exceptions.add(e);
					}
				} finally {
					intercept(param, currentHandler, result, handlerConfig, Location.FINAL);
				}
			}
		}

		return result;
	}

	protected Handler<T> nextHandler(Handler<T> currentHandler) {
		if (chain.size() == 0) {
			return null;
		}

		if (currentHandler == null) {
			return chain.get(0);
		}
 
		if (currentHandler != null && currentHandler.successor() != null) {
			int succIndex = chain.indexOf(currentHandler.successor());

			HandlerAssert.assertTrue(succIndex >= 0,
					"successor [{0}] of [{1}] not found in the chain!", currentHandler
							.successor().getClass().getSimpleName(), currentHandler
							.getClass().getSimpleName());

			return currentHandler.successor();
		}

		int currIndex = chain.indexOf(currentHandler);

		HandlerAssert.assertTrue(currIndex >= 0,
				"illegal handler, not fount in the chain!");

		// 已经完成
		if (currIndex == chain.size() - 1) {
			return null;
		} else {
			return chain.get(currIndex + 1);
		}
	}

	public boolean canHandle(T param) {
		return true;
	}

	@Override
	public Appendable<T> appendHandler(Handler<T> handler) {
		chain.add(handler);
		return this;
	}

	@Override
	public Appendable<T> appendHandler(Handler<T> handler, Handler<T> successor) {
		return appendHandler(handler.successor(successor));
	}
	
	@Override
	public Appendable<T> appendInterceptor(HandlerInterceptor<T> interceptor) {
		interceptors.add(interceptor);
		return this;
	}

	private void intercept(T param, Handler<T> handler, HandleResult result, HandlerConfig<Object> config, Location loc) {
		if (config.isRefuseInterceptor()) {
			return;
		}

		for (HandlerInterceptor<T> hi : interceptors) {
			switch (loc) {
			case BEFORE:
				hi.beforeHandle(param, handler, result);
				break;
			case AFTER:
				hi.afterHandle(param, handler, result);
				break;
			case EXCEPTION:
				hi.errorHandle(param, handler, result);
				break;
			case FINAL:
				hi.finalHandle(param, handler, result);
				break;
			default:
				break;
			}
		}
	}

	private static enum Location {
		BEFORE, AFTER, FINAL, EXCEPTION
	}

	private static class HandlerAssert {

		static void assertTrue(boolean statement, String errorMessage) {
			if (!statement) {
				throw new HandleException("HANDLER_CHAIN_ILLEGALE",
						errorMessage);
			}
		}

		static void assertTrue(boolean statement, String messageTemplete,
				Object... params) {
			if (!statement) {
				throw new HandleException("HANDLER_CHAIN_ILLEGALE",
						MessageFormat.format(messageTemplete, params));
			}
		}
	}

	final Handler<T> NULL_HANDLER = new AbstractHandler<T>() {
		@Override
		public boolean canHandle(T param) {
			return false;
		}
 
		@Override
		public HandlerConfig<T> getConfig() {
			return null;
		}

		@Override
		public void bizHandle(T param, HandleResult result) {
		}
	};
}
