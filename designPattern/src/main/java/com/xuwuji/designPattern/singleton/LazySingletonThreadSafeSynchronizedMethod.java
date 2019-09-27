package com.xuwuji.designPattern.singleton;

/**
 * 懒汉式单例
 * 
 * 1、线程安全
 * 
 * 2、采用同步方法
 *
 */
public class LazySingletonThreadSafeSynchronizedMethod {

	private static LazySingletonThreadSafeSynchronizedMethod instance;

	private LazySingletonThreadSafeSynchronizedMethod() {
	}

	/**
	 * 当使用时才创建instance
	 * 
	 * 优点：起到lazy loading的效果，线程安全，synchronized同步方法同一时间只会有一个线程进入
	 * 
	 * 缺点：加锁，效率低，并发情况下，每个线程在获取实例时都需要进行同步
	 * 
	 * @return
	 */
	public static synchronized LazySingletonThreadSafeSynchronizedMethod getInstance() {
		if (instance == null) {
			instance = new LazySingletonThreadSafeSynchronizedMethod();
		}
		return instance;
	}
}
