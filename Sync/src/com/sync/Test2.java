package com.sync;


/**
 * ���������൱��������  ���Բ�ͬ��
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
		// new��ʵ��
		Thread t1 = new Thread(new Test2());
		// new��ʵ��
		Thread t2 = new Thread(new Test2());
		t1.start();
		t2.start();
		// join����:��ǰ�߳�A�ȴ�thread�߳���ֹ֮����ܴ�thread.join()����
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
