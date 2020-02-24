/**
 * ThreadLocal ÿ���̶߳����Լ��ĸ��� �������������߳��޹�
 * @author listener
 *
 */
public class ThreadLocalTest {

	//�̱߳��ش洢����
	private static final ThreadLocal<Integer> THREAD_LOCAL_NUM = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};
 
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {//���������߳�
			Thread t = new Thread() {
				@Override
				public void run() {
					add10ByThreadLocal();
				}
			};
			t.start();
		}
	}
	
	/**
	 * �̱߳��ش洢������ 5
	 */
	private static void add10ByThreadLocal() {
		for (int i = 0; i < 5; i++) {
			Integer n = THREAD_LOCAL_NUM.get();
			n += 1;
			THREAD_LOCAL_NUM.set(n);
			System.out.println(Thread.currentThread().getName() + " : ThreadLocal num=" + n);
		}
	}
	
}