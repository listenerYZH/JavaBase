package com.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//�̳߳�ʵ��
public class Thread4 {
 
    public static void main(String[] args) {
        //�����̳߳�
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPool threadPool = new ThreadPool();
        for(int i =0;i<5;i++){
            //Ϊ�̳߳ط�������
            executorService.submit(threadPool);
        }
        //�ر��̳߳�
        executorService.shutdown();
        System.out.println('a'+1);
    }
}
 
class ThreadPool implements Runnable {
 
    @Override
    public void run() {
        for(int i = 0 ;i<2;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

}