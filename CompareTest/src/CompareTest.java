import java.util.Arrays;

public class CompareTest {
	public static void main(String[] args) {
		// �����ʼ������
		final int STUDENT_NUM = 4;
		Student[] allStudents = new Student[STUDENT_NUM];

		// ��ʼ��
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

		// ��ѧ����������
		Arrays.sort(allStudents);

		// ��ʾѧ����Ϣ
		System.out.println("ѧ��" + "\t����" + "\t����" + "\t�ɼ�");
		for (int i = 0; i < allStudents.length; i++) {
			System.out.print(allStudents[i]);
		}
		
	}
}
