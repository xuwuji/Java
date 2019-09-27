package com.xuwuji.designPattern.singleton;

/**
 * 懒汉式单例
 * 
 * 1、线程安全
 * 
 * 2、静态内部类实现
 *
 */
public class LazySingletonThreadSafeStaticInnerClass {

	private LazySingletonThreadSafeStaticInnerClass() {
	}

	/**
	 * 在外部类LazySingletonThreadSafeStaticInnerClass加载时，不会加载静态内部类LazySingletonThreadSafeStaticInnerClassHolder
	 *
	 */
	private static class LazySingletonThreadSafeStaticInnerClassHolder {
		private static final LazySingletonThreadSafeStaticInnerClass instance = new LazySingletonThreadSafeStaticInnerClass();
	}

	/**
	 * 1、在静态内部类的变量被调用时，才会对其进行加载
	 * 
	 * 2、加载静态内部类时，实例化其内部的静态变量
	 * 
	 * 3、获得instance对象然后返回
	 *
	 * 优点：
	 * 
	 * （1）加载机制避免了线程安全问题
	 * 
	 * （2）静态内部类的加载机制又保证了只有调用时才进行的懒加载
	 * 
	 * @return
	 */
	public static LazySingletonThreadSafeStaticInnerClass getInstance() {
		return LazySingletonThreadSafeStaticInnerClassHolder.instance;
	}
}
