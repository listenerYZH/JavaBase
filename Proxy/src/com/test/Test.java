package com.test;

import com.base.Developer;
import com.base.IDeveloper;
import com.cglib.EnginnerCGLibProxy;
import com.jdkproxy.EnginnerProxy;
import com.staticproxy.DeveloperProxy;

public class Test {
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
		jerryProxy2.writeCode();
		
		System.out.println("===============================");
		//cglib ���ܴ���final��
		IDeveloper jerryProxy3 = (IDeveloper) new EnginnerCGLibProxy().bind(jerry);
		jerryProxy3.writeCode();
	}
}
