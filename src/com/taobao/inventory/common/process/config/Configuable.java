/**
 * 
 */
package com.taobao.inventory.common.process.config;

/**
 * <pre>
 * ��ʶĳ���Ƿ�֧����������
 * </pre>
 * 
 * Ŀǰ֧�����õ����У�
 * <li>{@link HandlerChainConfig}</li>
 * <li>{@link HandlerConfig}</li>
 *
 * @author Chris
 */
public interface Configuable {

	/**
	 * ��ȡһ�����ã���ʱ�ᴴ��һ��Configurableʵ����
	 * @return ����ʵ��
	 */
	Configuable config();
}
