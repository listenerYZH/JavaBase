package com.test;

import java.util.Arrays;
import java.util.Random;

import com.sort.ChaRu;
import com.sort.GuiBing;
import com.sort.KuaiPai;
import com.sort.MaoPao;
import com.sort.XuanZe;

public class Main {
	//�����С
	static int size = 100000;
	//���п�ʼʱ��
	static long start;
	//���н���ʱ��
	static long end;
	//��ʼ������
	static int[] arr;
	static String str = "aaa";
	//���������ʱ��(ms)
	public static void main(String[] args) {
		//Arrays.sort Ĭ��ʹ�ÿ��ţ����ǻ�������ݵĳ�����ʹ����������� dualpivotquicksort
		System.out.println("-----------Arrays.sort-------------------");
		giveNum(size);
		start = System.currentTimeMillis();
		Arrays.sort(arr);
		end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println("-----------�鲢---------------------------");
		giveNum(size);
		start = System.currentTimeMillis();
		GuiBing.sort(arr, 0, arr.length-1);
		end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println("-----------����---------------------------");
		giveNum(size);
		start = System.currentTimeMillis();
		KuaiPai.sort(arr, 0, arr.length-1);
		end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println("-----------ѡ��---------------------------");
		giveNum(size);
		System.out.println(XuanZe.sort(arr, start, end));
		System.out.println("-----------ð��---------------------------");
		giveNum(size);
		System.out.println(MaoPao.sort(arr, start, end));
		System.out.println("-----------����---------------------------");
		giveNum(size);
		System.out.println(ChaRu.sort(arr, start, end));
		
	}
	// ��ֵ
	public static void giveNum(int size) {
		arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}
	}
}
