package com.sort;

public class XuanZe {
	/**
	 * ѡ�񣺴�������ѡ����С�������һ������
	 * 		�ظ�����ѡ����ڶ�����...
	 * @param arr	����
	 * @param start	��ʼʱ��
	 * @param end	����ʱ��
	 * @return
	 */
	public static long sort(int[] arr, long start, long end) {
		start = System.currentTimeMillis();
		//����һ����������
		int temp;
		//ÿ��λ�ö�Ҫѡ����С��  �����м����� ���м���
		for (int i = 0; i < arr.length-1; i++) {
			//��ȡ��ַ
			int min = i;
			//�����ñ�,i֮ǰ�����ݶ��Ѿ������꣬��Ҳ���ñ�
			for (int j = i+1; j < arr.length - 1; j++) {
				//����бȵ�ǰС��
				if (arr[j] < arr[min]){
					//��С�������仯
					min = j;
				}
			}
			//�б仯��
			if (min != i){
				temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		
		end = System.currentTimeMillis();
		return (end - start);
	}

}
