package com.xuwuji.designPattern.singleton;

/**
 * 懒汉式单例
 * 
 * 1、线程安全
 * 
 * 2、采用双重检查
 *
 */
public class LazySingletonThreadSafeDoubleCheck {

	/**
	 * 1、volatile保证可见性和有序性
	 * 
	 * 2、当instance被一个线程实例化后，实时地刷新值到主内存中的共享变量存储中
	 * 
	 * 3、当一个线程修改了volatile修饰的instance变量，其他线程会立即看到最新的值
	 * 
	 */
	private static volatile LazySingletonThreadSafeDoubleCheck instance;

	private LazySingletonThreadSafeDoubleCheck() {
	}

	/**
	 * 将锁进行细化，保证线程安全的前提下，可以多个线程进行实例化获取
	 * 
	 * @return
	 */
	public static LazySingletonThreadSafeDoubleCheck getInstance() {
		// 线程A和线程B同时进入if条件
		if (instance == null) {
			/**
			 * 1、进行同步，线程A进入下面的代码块，线程B进行等待
			 */
			synchronized (LazySingletonThreadSafeDoubleCheck.class) {
				/**
				 * 2、线程A判断后对instance进行实例化
				 * 
				 * 3、线程A执行完毕后释放锁，线程B获得锁后进入此处代码
				 * 
				 * 4、由于volatile实时刷新内存，B发见instance已经实例化了
				 * 
				 * 5、B得到由A实例化的instance然后返回
				 *
				 * hint:如果instance没有加volatile关键字，当A实例化后，B可能看不到已经被实例化的instance对象，此时还会进行下面的实例化动作
				 */
				if (instance == null) {
					instance = new LazySingletonThreadSafeDoubleCheck();
				}
			}
		}
		return instance;
	}
}
