package com.xuwuji.designPattern.adapter;

public class Phone {

	public void charge(Charger5V charger) {
		System.out.print(charger.output5V());
	}

	public static void main(String[] args) {
		Phone phone = new Phone();
		// 类适配器
		Charger5V charger1 = new ChargerClassAdapter();
		phone.charge(charger1);
		
		// 对象适配器
		Charger5V charger2 = new ChargerObjectAdapter(new Charger220V());
		phone.charge(charger2);
	}
}
