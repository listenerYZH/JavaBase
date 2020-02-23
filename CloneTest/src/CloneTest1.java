/**
 * ǳ����
 * 		������������ö����Ա�����ĵ�ַҲ���������µ�ԭ�����޸����ö������ʱ����¡��������ö������Ҳ���Ÿı��ˡ�
 * @author listener
 *
 */
public class CloneTest1 {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Mark mark = new Mark(100, 99);
		User user = new User("user", 22, mark);
		
		User userClone = (User) user.clone();
		
		System.out.println("ԭuser��" + user);
		System.out.println("��¡��user��" + userClone);
		
		// �޸��������͵�mark����
		user.mark.setMath(60);
		
		System.out.println("�޸ĺ��ԭuser��" + user);
		System.out.println("�޸ĺ�Ŀ�¡user��" + userClone);
		
		//���������ǵĵ�ַ
	}
}

class Mark {
	private int chinese;
	private int math;

	public Mark(int chinese, int math) {
		this.chinese = chinese;
		this.math = math;
	}

	public void setChinese(int chinese) {
		this.chinese = chinese;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Mark{" + "chinese=" + chinese + ", math=" + math + '}'+"��ַ��"+super.toString();
	}
}

class User implements Cloneable {
	private String name;
	private int age;
	public Mark mark;

	public User(String name, int age, Mark mark) {
		this.name = name;
		this.age = age;
		this.mark = mark;
	}

	@Override
	public String toString() {
		
		return "User{" + "name='" + name + '\'' + ", age=" + age + ", mark=" + mark + '}'+"��ַ��"+super.toString();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}