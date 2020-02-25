package com.sync;


/**
 * 两个对象相当于两把锁  所以不同步
 * @author listener
 *
 */
public class Test2 implements Runnable{
	static int i = 0;

	public synchronized void increase() {
		i++;
	}

	@Override
	public void run() {
		for (int j = 0; j < 1000000; j++) {
			increase();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// new新实例
		Thread t1 = new Thread(new Test2());
		// new新实例
		Thread t2 = new Thread(new Test2());
		t1.start();
		t2.start();
		// join含义:当前线程A等待thread线程终止之后才能从thread.join()返回
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
