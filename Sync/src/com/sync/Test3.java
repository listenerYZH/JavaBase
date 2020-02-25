package com.sync;

/**
 * ͬ�������
 * @author listener
 *
 */
public class Test3 implements Runnable {
	static Test3 instance = new Test3();
	static int i = 0;

	@Override
	public void run() {
		// ʹ��ͬ�������Ա���i����ͬ������,������Ϊinstance
		//this ��instance ����һ���� 
		//synchronized (instance) {
		synchronized (this) {
			for (int j = 0; j < 1000000; j++) {
				i++;
			}
		}
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
