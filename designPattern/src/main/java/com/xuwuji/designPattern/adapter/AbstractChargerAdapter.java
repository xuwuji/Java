package com.xuwuji.designPattern.adapter;

/**
 * 接口适配器
 * 
 * @author i509669
 *
 */
public abstract class AbstractChargerAdapter implements Charger {
	// 不需要实现的方法默认为空
	public int output5V() {
		// TODO Auto-generated method stub
		return 0;
	}

	// 实现需要完成的方法
	public int output200V() {
		return 200;
	}
}
