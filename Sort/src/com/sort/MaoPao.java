package com.sort;

public class MaoPao {
	/**
	 * ð������a[i] > a[i+1] ��a[i]��a[i+1]�����ݽ��������򲻱�
	 * 			ÿһ�ֶ���ѡ���һ����ֵ����i����������i-1�ֱȽ�
	 * @param a ������Ҫ���������
	 * @return
	 */
	public static long sort(int[] a, long start, long end) {
		start = System.currentTimeMillis();
		for (int i = 0; i < a.length; i++) { // ��һ�� Ҫ�Ƚϵ�����
			for (int j = 0; j < a.length - i - 1; j++) { // �ڶ��� ÿ�����Ƚϼ���
				if (a[j] > a[j + 1]) { 					 // �Լ����ú��Լ��� ���Լ�һ
					int temp = a[j]; 					 // ÿһ�ֱȽ��궼��һ����ֵ���֣����Լ�ȥi
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		end = System.currentTimeMillis();
		return (end - start);
	}
}
