package com.sort;

public class ChaRu {
	/**
	 * 
	 * ��Ҫ���������ǰһ�����Ƚϣ�
	 * �����򲻶���С������ǰһ����������Ȼ������ǰһ�����Ƚ�
	 * ����ȥһֱ������ǰһ������λ��
	 * 
	 * @param a     ����������������
	 * @param start ��ʼʱ��
	 * @param end   ���н���ʱ��
	 * @return
	 */
	public static long sort(int[] arr, long start, long end) {
		start = System.currentTimeMillis();
		
		//�Ƚϴ���Ϊ���鳤��-1(��һ�������ñȽ�)
		for(int i = 0; i < arr.length - 1; i++){
			//��ȡ��ǰ�Ƚ�����λ��
			int j = i;
			//��ȡ��Ҫ�������
			int x = arr[j+1];
			//ѭ���Ƚ� ��� ����С��ǰ�� ��λ��
			while (j >= 0 && arr[j] > x){
				//��λ�� �����ֵ�ź���
				arr[j+1] = arr[j];
				//������ǰһ�����Ƚ�
				j--;
			}
			//�Ƚ��� ��ֵ����ǰһ��λ��
			arr[j+1] = x;
		}
		
		
		end = System.currentTimeMillis();
		return end - start;
	}

}
