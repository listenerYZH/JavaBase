package com.sync;

/**
 * �����ԣ��߳��Ѿ��û����ˣ��ٴ������������������룬���������ǻ�ɹ���
 * @author listener
 *
 */
public class Test4 implements Runnable {
	static Test4 instance = new Test4();
	static int i = 0;
	static int j = 0;

	@Override
	public void run() {
		for (int j = 0; j < 1000000; j++) {

			// this,��ǰʵ��������
			synchronized (this) {
				i++;
				increase();// synchronized�Ŀ�������
			}
		}
	}
	
	/**
	 * ��̬ �����ж��󶼻�ͬ��
	 */
	public static synchronized void increase() {
		j++;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
