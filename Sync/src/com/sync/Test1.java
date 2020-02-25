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
			increase();
			//increase2();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Test1 test = new Test1();
		Test1 test2 = new Test1();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		//��ͬ������� ͬ�����������ԣ���̬ͬ�������Ϳ��ԣ���Ϊ��̬ͬ������ ��ס��class
		//Thread t3 = new Thread(test2);
		t1.start();
		t2.start();
		//�ȴ�ִ��
		t1.join();
		t2.join();
		System.out.println(i);
	}
	/**
	 * ������: 2000000
	 */
}
