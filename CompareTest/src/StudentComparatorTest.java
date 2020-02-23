import java.util.Arrays;
import java.util.Comparator;

public class StudentComparatorTest {

	public static void main(String[] args) {
		// �����ʼ������
		final int STUDENT_NUM = 4;
		Student[] allStudents = new Student[STUDENT_NUM];

		// ��ʼ��ѧ������
		allStudents[0] = new Student("00001", "a");
		allStudents[1] = new Student("00003", "b");
		allStudents[2] = new Student("00002", "c");
		allStudents[3] = new Student("00004", "d");

		// ������ʼ������ͳɼ�
		for (int i = 0; i < allStudents.length; i++) {
			allStudents[i].setAge(i * 10);
		}
		for (int i = 0; i < allStudents.length; i++) {
			allStudents[i].setScore(99 - i * 1.5);
		}

		// ��������������
		Arrays.sort(allStudents, new ComparatorWithNameUP());
		// ��ʾѧ����Ϣ
		System.out.println("������������������");
		System.out.println("ѧ��" + "\t����" + "\t����" + "\t�ɼ�");
		for (int i = 0; i < allStudents.length; i++) {
			System.out.print(allStudents[i]);
		}

		// ��������������
		Arrays.sort(allStudents, new ComparatorWithNameDown());
		// ��ʾѧ����Ϣ
		System.out.println("������������������");
		System.out.println("ѧ��" + "\t����" + "\t����" + "\t�ɼ�");
		for (int i = 0; i < allStudents.length; i++) {
			System.out.print(allStudents[i]);
		}

		// ���ɼ���������
		Arrays.sort(allStudents, new ComparatorWithScoreDown());
		// ��ʾѧ����Ϣ
		System.out.println("���ɼ�������������");
		System.out.println("ѧ��" + "\t����" + "\t����" + "\t�ɼ�");
		for (int i = 0; i < allStudents.length; i++) {
			System.out.print(allStudents[i]);
		}

		// ���ɼ���������
		Arrays.sort(allStudents, new ComparatorWithScoreUp());
		// ��ʾѧ����Ϣ
		System.out.println("���ɼ�������������");
		System.out.println("ѧ��" + "\t����" + "\t����" + "\t�ɼ�");
		for (int i = 0; i < allStudents.length; i++) {
			System.out.print(allStudents[i]);
		}
	}
}

// ��������������������ⲿ�࣬��Comparator�ӿ�
class ComparatorWithNameUP implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}
}

// ���������н���������ⲿ�࣬��Comparator�ӿ�
class ComparatorWithNameDown implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		return arg1.getName().compareTo(arg0.getName());
	}
}

// ���ɼ�����
class ComparatorWithScoreDown implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		if (arg1.getScore() > arg0.getScore())
			return 1;
		else {
			if (arg1.getScore() == arg0.getScore())
				return 0;
			else
				return -1;
		}
	}

}

// ���ɼ�����
class ComparatorWithScoreUp implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		if (arg0.getScore() > arg1.getScore())
			return 1;
		else {
			if (arg0.getScore() == arg1.getScore())
				return 0;
			else
				return -1;
		}
	}

}
