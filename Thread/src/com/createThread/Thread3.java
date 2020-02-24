package com.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//ʵ��Callable�ӿ�
public class Thread3 {
 
    public static void main(String[] args) {
        //ִ��Callable ��ʽ����ҪFutureTask ʵ��ʵ�֣����ڽ���������
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        new Thread(futureTask).start();
        //�����߳������Ľ��
        try {
            Integer sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
 
class MyCallable implements Callable<Integer> {
 
    @Override
    public Integer call() throws Exception {
    	System.out.println(Thread.currentThread().getName());
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}