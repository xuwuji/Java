package com.xuwuji.designPattern.singleton;

/**
 * 懒汉式单例（线程不安全）
 *
 */
public class LazySingletonThreadNotSafe {

	private static LazySingletonThreadNotSafe instance;

	private LazySingletonThreadNotSafe() {
	}

	/**
	 * 当使用时才创建instance
	 * 
	 * 优点：起到lazy loading的效果
	 * 
	 * 缺点：线程不安全
	 * 
	 * @return
	 */
	public static LazySingletonThreadNotSafe getInstance() {
		/**
		 * 1、多线程的情况下，线程A和线程B同时进入下面的代码块
		 * 
		 * 2、此时在系统中instance还未被实例化，便均会执行实例化操作
		 */
		if (instance == null) {
			instance = new LazySingletonThreadNotSafe();
		}
		return instance;
	}
}
