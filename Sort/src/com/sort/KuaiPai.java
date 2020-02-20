package com.sort;

public class KuaiPai {

	public static void quickSort(int A[],int p,int q){
		if(p<q){
//			������ֳ�3���֣�p~r-1,r,r+1~q
			int r = partition(A,p,q);
			quickSort(A,p,r-1);
			quickSort(A,r+1,q);
		}
	}
	static int partition(int A[],int p,int q){//������Ԫ��������ԪС��Ԫ�ط�����ߣ�����Ԫ��ķ����ұ�
		int x = A[p],i=p,j,swap;
		for(j=p+1;j<=q;j++){
			if(A[j]<=x){
				i++;//iָ�������һ��ѭ�������һ������ԪС��Ԫ��
				swap=A[i];
				A[i]=A[j];
				A[j]=swap;
			}
		}
		swap=A[i];
		A[i]=A[p];
		A[p]=swap;
		return i;//���ر���ѭ����������Ԫ���ڵ�λ�ã�֮����Ԫ����Ҫ�ٲ���Ƚ�
	}
	
	/**
	 * ----����---- ���ţ��Ե�һ����Ϊ������ �ȴӺ���ǰ�Ƚϣ�
	 * С�ڻ�����λ�ã�����λ�����Ի�����λ��Ϊָ�룬��ԭ����λ��Ϊͷָ��
	 * ��ǰ����Ƚ� ������βָ����ǰ�ƶ�һλ
	 * 
	 * ��ǰ����Ƚϣ� ͷָ����С�ڻ�������λ�ò��䣬ͷָ����ǰ�ƶ� ����ʱ
	 * �������λ�ã�����ָ��λ��Ϊ�����λ�ã�Ȼ��Ӻ���ǰ�Ƚ�
	 * 
	 * ֱ��ͷָ��λ�ô��ڻ����βָ��λ��(��һ���Ƚ����)
	 * 
	 * ������ֳ����� �������ţ�ֱ�����Ҳ��ɷ�
	 * 
	 * @param arr
	 *            ����
	 * @param start
	 *            ��ʼʱ��
	 * @param begin
	 *            ͷָ��λ��
	 * @param last
	 *            βָ��λ��
	 * @return
	 */
	public static void sort(int[] arr, int begin, int last) {
		
		int start = begin;
		int end = last;
		// ͷ���ڵ���β �����
		if (begin >= last) {
			return;
		}

		// ȷ�ϻ���
		int x = arr[begin];

		// ѭ��
		while (begin < last) {
			// �Ӻ���ǰ��
			while (begin < last && arr[last] >= x) {
				last--;
			}
			// ������ڷ�Χ֮���ҵ� �򽻻�λ��
			if (begin < last) {
				arr[begin] = arr[last];
				// ͷָ��λ��ǰ��һλ
				begin++;
			}
			// ��ǰ������
			while (begin < last && arr[begin] <= x) {
				begin++;
			}
			// ͷָ����ָ�������ڻ���
			if (begin < last) {
				arr[last] = arr[begin];
				// βָ�����һλ
				last--;
			}

		}
		// ���begin >= last ����������begin �� last ������
		// ��Ϊ���begin���ڵ���lastʱ���˳�ѭ��
		arr[begin] = x;
		// ѭ������ ��ʾһ�����Ѿ������� �ݹ�������������
		// ��ߵݹ�����
		sort(arr, start, begin - 1);
		// �ұߵݹ�����
		sort(arr, begin + 1, end);
	}
}
