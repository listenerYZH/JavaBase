package com.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Method4 {

	//���̵߳��̳߳أ��߳��쳣�������ᴴ��һ���µ��̣߳���ȷ�������ύ˳��ִ��
	static ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
	
	
	public static void main(String[] args) {
	//���Ե��̵߳��̳߳�
		for (int i = 0; i < 3; i++) {
			final int index = i;
			singleExecutor.execute(new Runnable() {
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
		System.out.println("4���...");
		
		singleExecutor.shutdown();
	}
	
}