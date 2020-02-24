package com.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Method5 {
	//���߳̿�ִ��������������̳߳�
	static ScheduledExecutorService singleScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	
	
	public static void main(String[] args) {
	//���Ե��߳̿�����ִ�е��̳߳�
		for (int i = 0; i < 3; i++) {
			final int index = i;
			//scheduleWithFixedDelay �̶����ӳ�ʱ��ִ������ scheduleAtFixedRate �̶���Ƶ��ִ������
			singleScheduledExecutor.scheduleAtFixedRate(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + " index:" + index);
				}
			}, 0, 3, TimeUnit.SECONDS);
		}
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("4���...");
		
		singleScheduledExecutor.shutdown();
	}
	
}