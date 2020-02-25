package com.sync;

import java.util.concurrent.TimeUnit;

/**
 * �߳��ж� �ڻ�ȡ����Դ���߳��ǲ������õ�(�ȴ�̬�̲߳�������)
 * @author listener
 *
 */
public class Test5 implements Runnable {

	public synchronized void method() {
		System.out.println(Thread.currentThread().getName()+"method run ....");
	}

	/**
     * �ڹ������д������̲߳�������ȡ������
     */
    public Test5() {
    	System.out.println("Test5 init....");
        //��ʼ��ʱ�������߳� ��ִ��
        new Thread() {
            public void run() {
            	System.out.println(Thread.currentThread().getName()+": run ...");
            	method();
            	//������
            	try {
					wait();
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+": interrupt ...");
				}
            }
        }.start();
    }
    
    @Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" run ....");
		// �ж��ж�
		while (true) {
			if (Thread.interrupted()) {
				System.out.println("�ж��߳�!!");
				break;
			} else {
				method();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Test5 sync = new Test5();
		Thread t = new Thread(sync);
		// �ٴ����Ķ���������ʱ����ȡ��������Դ
		t.start();
		//˯1��
		TimeUnit.SECONDS.sleep(1);
		// �ж��߳�,�޷���Ч
		t.interrupt();
		System.out.println("end");
	}

}
