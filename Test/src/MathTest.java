
public class MathTest {
	public static void main(String[] args) {
		System.out.println(Math.round(-2.5));
		StringBuilder sb = new StringBuilder(10);
		sb.append("hello");
		//sb.capacity() ��ΪStringBuffer��Ϊ������䳤�ȵ�ʱ����ʼ�����һ���֣�Ҳ���������ֽڳ��ȼ���16λ����ÿ����һ���ַ������Ⱦͻ���16�Ļ����ϼ� 12
		System.out.println("capacity: "+sb.capacity()+"----length: "+sb.length());
		System.out.println(sb.reverse());
		String str = "hello";
		String str2 = new String ("hello");
		System.out.println(str.hashCode()+"----"+str2.hashCode());
	}
}
