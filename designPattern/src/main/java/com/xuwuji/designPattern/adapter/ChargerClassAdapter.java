package com.xuwuji.designPattern.adapter;

/**
 * 类适配器
 * 
 * @author i509669
 *
 */
public class ChargerClassAdapter extends Charger220V implements Charger5V {

	public int output5V() {
		int src = this.output220V();
		int dest = transform(src);
		return dest;
	}

	private int transform(int src) {
		return 5;
	}

}
