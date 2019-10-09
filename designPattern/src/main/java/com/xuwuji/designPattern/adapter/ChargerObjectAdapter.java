package com.xuwuji.designPattern.adapter;

/**
 * 对象适配器
 * 
 * @author i509669
 *
 */
public class ChargerObjectAdapter implements Charger5V {

	private Charger220V charger220V;

	ChargerObjectAdapter(Charger220V charger220V) {
		this.charger220V = charger220V;
	}

	public int output5V() {
		int src = charger220V.output220V();
		int dest = transform(src);
		return dest;
	}

	private int transform(int src) {
		return 5;
	}

}
