package com.sort;

public class GuiBing {
	/**
	 *  �鲢�� �������Ϊ�����ȳ��������飬һֱ��
	 *  ֱ��ÿ��������ֻ��һ���������ϲ�
	 *  ��ߵĵ�һ�����ұߵĵ�һ���Ƚ� С�ķ���temp����ĵ�һ��
	 *  Ȼ��С�ĵڶ����ٸ���һ����һ���Ƚϣ�С���ƹ�ȥ������Ǻϲ�
	 * @param a
	 * @param start
	 * @param end
	 */
	public static void sort(int[] arr, int start, int end) {
		int mid ;
		if( start < end) {
			//����������
			mid = (start+end)/2;
			//����������ٻ���
			sort(arr, start, mid);
			//�ұ��������ٻ���
			sort(arr, mid+1, end);
			//�鲢
			merge(arr, start, mid, end);
		}
		
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		//��ʼ����������źϲ�������
		int[] temp = new int[end-start+1];
		//������ݵ���ʼ��
		int left = start;
		//�ұ����ݵ���ʼ��
		int right = mid+1;
		//temp��������
		int i = 0;
		//���ұߵ������Ѿ�������ɣ��ϲ�
		while (left <= mid && right <= end) {
			//����ڷ�Χ�� �� ��С�����������
			if (arr[left] < arr[right]) {
				temp[i++] = arr[left++];
			} else {
				temp[i++] = arr[right++];
			}
		}
		//ѭ�������� ��ʣ�����ݷ�������
		while (left <= mid) {
			temp[i++] = arr[left++];
		}
		while (right <= end) {
			temp[i++] = arr[right++];
		}
		
		//�����鸲��ԭ��������
		for (int j = 0; j < temp.length; j++) {
			arr[start+j] = temp[j];
		}
	}
}
