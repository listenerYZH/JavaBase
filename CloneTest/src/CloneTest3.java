import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ��� ֮ ���л�
 * @author listener
 *
 */
public class CloneTest3
{
	public static void main(String[] args) throws Exception
	{
		//��������
		Teacher3 teacher3 = new Teacher3();
		teacher3.setAge(23);
		teacher3.setName("����ʦ");
		
		Student3 student3 = new Student3();
		student3.setAge(20);
		student3.setName("����");
		student3.setTeacher3(teacher3);
		
		//����
		Student3 student4 = (Student3)student3.deepCopy();
		
		System.out.println("----------������-----------");
		System.out.println(student3);
		System.out.println(student4);
		
		System.out.println("-----------�޸�ֵ------------");
		
		student4.getTeacher3().setAge(60);
		student4.getTeacher3().setName("����ʦ");
		
		System.out.println(student3);
		System.out.println(student4);
		
	}
	
 
}
class Teacher3 implements Serializable
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
		return "Teacher3 [age=" + age + ", name=" + name + "]"+"��ַ��"+super.toString();
	}
	
}

class Student3 implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private int age;
		private String name;
		private Teacher3 teacher3;
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
		public Teacher3 getTeacher3()
		{
			return teacher3;
		}
		public void setTeacher3(Teacher3 teacher3)
		{
			this.teacher3 = teacher3;
		}
		
		@Override
		public String toString() {
			return "Student3 [age=" + age + ", name=" + name + ", teacher3=" + teacher3 + "]"+"��ַ��"+super.toString();
		}
		
		//ʹ�����л�student3��ʱ��Ҳ�Ὣteacher���л�
		public Object deepCopy()throws Exception
		{
			//����ǰ�������д��һ����������У�����Ϊ����������ʵ����Serializable����ӿڣ��������������
			//��һ�����ã�����������ʵ�������л�����ô���Ҳ��д��������������
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream  oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			
			//������ǽ����еĶ��������࣬����һ�����������У������Ϳ��Է�������������Ķ�����ʵ�����¡
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			return ois.readObject();
		}
	}