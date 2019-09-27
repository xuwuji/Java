package com.xuwuji.designPattern.singleton;

/**
 * 饿汉式单例（静态变量/静态代码块）
 * 
 */

/**
 * 优点：采用静态变量，在类装载的时候就完成了instance的实例化，避免了线程同步问题
 * 
 * 缺点：由于是装载时就完成了实例化，如果从始至终都没有使用过这个instance，则造成了内存的浪费
 */
public class EagerSingletonThreadSafeStatic {
	// 静态变量方式
	private final static EagerSingletonThreadSafeStatic instance1 = new EagerSingletonThreadSafeStatic();

	// 静态代码块方式
	private final static EagerSingletonThreadSafeStatic instance2;
	static {
		instance2 = new EagerSingletonThreadSafeStatic();
	}

	// 构造器私有化
	private EagerSingletonThreadSafeStatic() {}

	// 返回实例对象
	public static EagerSingletonThreadSafeStatic getInstance() {
		return instance1;
		// return instance2;
	}

}
