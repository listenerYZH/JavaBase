package com.sync;

/**
 * ���η���
 * @author listener
 *
 */
public class Test1 implements Runnable {
	// ������Դ(�ٽ���Դ)
	static int i = 0;

	/**
	 * synchronized ����ʵ������
	 * ��ס����ʵ��������ͬһ��ʵ������ͬ��Ч��
	 */
	public synchronized void increase() {
		i++;
	}
	/**
	 * ���ξ�̬����
	 * ��ס���������(class �ļ�) ��ͬʵ����������ͬ����static
	 * ���Կ���ͬ��
	 */
	public static synchronized void increase2() {
		i++;
	}
	@Override
	public void run() {
		for (int j = 0; j < 1000000; j++) {
			increase2();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Test1());
		Thread t2 = new Thread(new Test1());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
	/**
	 * ������: 2000000
	 */
}
