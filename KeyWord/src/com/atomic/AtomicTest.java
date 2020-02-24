package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;
 
/**
 * JDK ԭ�������
 * 
 * ����CAS�����㷨ʵ��ԭ����
 * 
 * CAS�� �ڴ�ֵ�;�ֵ�Ƚϣ���ͬ�Ϳ��Լ�1����ͬ�����ԡ�
 * @author listener
 *
 */
public class AtomicTest {
 
//    private int count = 0;
//    
//    public int getAndIncrement() {
//        return count++;
//    }
    
    private AtomicInteger count = new AtomicInteger(0);
    
    public int getAndIncrement() {
    	//�ײ���CAS����
        return count.getAndIncrement();
    }
    
    public static void main(String[] args) {
        final AtomicTest test = new AtomicTest();
        //���������߳�
        for (int i = 0; i <3; i++) {
            new Thread(){
                @Override
                public void run() {
                	//�Լ�10��
                    for (int j = 0; j <10; j++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " ��ȡ����ֵ��" + test.getAndIncrement());
                    }
                }
            }.start();
        }
    }
    
    
}