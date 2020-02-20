import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo2 {
	public static String publicStaticString;
	protected static String protectedStaticString;
	static String staticString;
	private static String privateStaticString;
	public  String publicString;
	protected String protectedString;
	String string;
	private String privateString;
	private static Class<?> c1;
	
	
	public static void main(String[] args) throws Exception {
		// ��һ�ַ�ʽ��
		c1 = Class.forName("Demo2");
			
		// �ڶ��ַ�ʽ��
		// java��ÿ�����Ͷ���class ����.
		c1= Demo2.class;

		// �����ַ�ʽ��
		// java�������κ�һ��java������getClass ����
		Demo2 e= new Demo2();
		c1 = e.getClass(); // c3������ʱ�� (e������ʱ����Employee)
		
		System.out.println("---------��ȡ������������------------");
		for (Field string : c1.getDeclaredFields()) {
			System.out.println(string);
		}
		System.out.println("---------��ȡ����public����------------");
		for (Field string : c1.getFields()) {
			System.out.println(string);
		}
		System.out.println("---------��ȡ����������------------");
		for (Method method : c1.getDeclaredMethods()) {
			System.out.println(method);
		}
		System.out.println("---------��ȡ�������ڸ����public����------------");
		//���е��඼��̳�Object ���Ի��Զ�ʵ��equals��wait��notify�ȷ���
		for (Method method : c1.getMethods()) {
			System.out.println(method);
		}
	}
	
	public void show1 () {
		System.out.println("public show()");
	}
	protected void show6 () {
		System.out.println("protected show()");
	}
	private void show2 () {
		System.out.println("private show()");
	}
	public static void show3 () {
		System.out.println("public static show()");
	}
	protected static void show4 () {
		System.out.println("protected static show()");
	}
	private static void show5 () {
		System.out.println("private static show()");
	}	
	static void show7 () {
		System.out.println("private static show()");
	}
}
