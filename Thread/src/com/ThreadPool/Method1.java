package com.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Method1 {
	 
	//�����̳߳أ�ÿ���ύһ������ʹ���һ���̣߳�ֱ���ﵽ�̳߳ص������������ʱ�߳��������ٱ仯�����̷߳����������ʱ���̳߳ػᲹ��һ���µ��߳�
	static ExecutorService fixedExecutor = Executors.newFixedThreadPool(3);
	
	
	public static void main(String[] args) {
	//���Զ����̳߳أ��̳߳ص�����Ϊ3���ύ6�����񣬸��ݴ�ӡ������Կ�����ִ��ǰ3������3�������������ִ�к��������
		for (int i = 0; i < 6; i++) {
			final int index = i;
			fixedExecutor.execute(new Runnable() {
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
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ "4���...");
		
		fixedExecutor.shutdown();
	}
	
}