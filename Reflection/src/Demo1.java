
public class Demo1 {
	public static void main(String[] args) {
		Class<?> test = Demo1.class;
		ClassLoader classLoader = test.getClassLoader();
		//���ü�����
		System.out.println(classLoader.getParent().getParent());
		//��չ������
		System.out.println(classLoader.getParent());
		//app������
		System.out.println(classLoader);
	}
	
}
