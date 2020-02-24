package com.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Method3 {
	 
	//�����̳߳أ���ִ�������Ե�����
	static ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);
	
	
	public static void main(String[] args) {
	//���Զ�����������ִ�е��̳߳�
		for (int i = 0; i < 3; i++) {
			final int index = i;
			//scheduleWithFixedDelay �̶����ӳ�ʱ��ִ������ scheduleAtFixedRate �̶���Ƶ��ִ������
			scheduledExecutor.scheduleWithFixedDelay(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + " index:" + index);
				}
			}, 0, 5, TimeUnit.SECONDS);
			System.out.println("==========================");
		}
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("4���...");
		
		//scheduledExecutor.shutdown();
	}
}