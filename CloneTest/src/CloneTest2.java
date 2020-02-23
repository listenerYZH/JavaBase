/**
 * ���:
 * 	ԭ��������ö���Ҳʵ���˿�¡
 * ��ֻ�����������ö���ʱ�ʺ����������
 * @author listener
 *
 */
public class CloneTest2
{
	public static void main(String[] args) throws Exception
	{
		Teacher teacher = new Teacher();
		teacher.setAge(40);
		teacher.setName("teacher zhang");
		
		Student2 student2 = new Student2();
		student2.setAge(14);
		student2.setName("lisi");
		student2.setTeacher(teacher);
		
		//���
		Student2 student3 = (Student2)student2.clone();
		//
		System.out.println(student2);
		System.out.println(student3);
		//�ı�teacher�����ֵ
		System.out.println("---------�ı�teacher�����ֵ--------------");
		teacher.setName("teacher li");//�������κ�Ӱ��
		System.out.println(student2);
		System.out.println(student3);
	
	}
 
}
class Student2 implements Cloneable
{
	private int age;
	private String name;
	private Teacher teacher;
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Teacher getTeacher()
	{
		return teacher;
	}
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}
	
	@Override
	public String toString() {
		return "Student2 [age=" + age + ", name=" + name + ", teacher=" + teacher + "]"+"��ַ��"+super.toString();
	}
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		//��һ�����ص����student2��ֻ��һ��ǳ��¡��
		Student2 student2 = (Student2)super.clone();
		//��������Teacher�ĵ�ַ
		student2.setTeacher((Teacher)student2.getTeacher().clone());
		//˫���¡ʹ���Ǹ�teacher����Ҳ�õ��˸���
		return student2;
	}
}
class Teacher implements Cloneable
{
	private int age;
	private String name;
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Teacher [age=" + age + ", name=" + name + "]"+"��ַ��"+super.toString();
	}
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
}