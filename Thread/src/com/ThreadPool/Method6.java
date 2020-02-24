package com.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Method6 {
	 
	//������ȡ�̳߳�
	//�����߳̽��� �ͽ�����
	static ExecutorService workStealingExecutor = Executors.newWorkStealingPool();
	
	public static void main(String[] args) {
	
	//����������ȡ�̳߳�
		for (int i = 0; i < 10; i++) {//���� CPU 8�ˣ����ﴴ��10��������в���
			final int index = i;
			workStealingExecutor.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " index:" + index);
				}
			});
		}
		
		try {
			Thread.sleep(4000);//�������̲߳����ߣ������д�ӡ���
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("4���...");
		
//		workStealingExecutor.shutdown();
	}
	
}