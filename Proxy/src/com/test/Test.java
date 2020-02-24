package com.test;

import com.base.Developer;
import com.base.IDeveloper;
import com.cglib.EnginnerCGLibProxy;
import com.jdkproxy.EnginnerProxy;
import com.staticproxy.DeveloperProxy;
/**
 * jdk > cglib when size < 1000000
 * 
 * when size > 1000000 jdk > cglib
 * @author listener
 *
 */
public class Test {
	private static int size = 1000000;
	private static long startTime;
	private static long endTime;
	
	public static void main(String[] args) {
		
		// ԭ����Ҫָ����Ա Ȼ�����ָ����Ա�ķ���
		IDeveloper jerry = new Developer("Jerry");
		jerry.writeCode();
		System.out.println("===============================");
		// ��̬����
		// ֻҪָ����Ա�� �������������ô�����������
		IDeveloper jerryProxy = new DeveloperProxy(jerry);
		jerryProxy.writeCode();
		
		System.out.println("===============================");
		//jdk���� ����ʵ��invocationHandler 
		IDeveloper jerryProxy2 = (IDeveloper) new EnginnerProxy().bind(jerry);
		startTime = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			jerryProxy2.writeCode();
		}
		endTime = System.currentTimeMillis();
		System.out.println("jdk "+(endTime-startTime));
		
		System.out.println("===============================");
		//cglib ���ܴ���final��
		IDeveloper jerryProxy3 = (IDeveloper) new EnginnerCGLibProxy().bind(jerry);
		startTime = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			jerryProxy3.writeCode();
		}
		endTime = System.currentTimeMillis();
		System.out.println("cglib "+(endTime-startTime));
	}
}
