package com.createThread;

//�̳�Thread���������߳�
public class Thread1 {

  public static void main(String[] args) {
      //�����߳�����
      Thread.currentThread().setName("main thread");
      MyThread myThread = new MyThread();
      myThread.setName("���߳�:");
      //�����߳�
      myThread.start();
      for(int i = 0;i<5;i++){
          System.out.println(Thread.currentThread().getName() + i);
      }
  }
}

class MyThread extends Thread{
  //��дrun()����
  public void run(){
      for(int i = 0;i < 10; i++){
          System.out.println(Thread.currentThread().getName() + i);
      }
  }
}