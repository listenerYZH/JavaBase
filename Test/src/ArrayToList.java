
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToList {
	
	public static void main(String[] args) {
		
		//����תlist
		String[] str=new String[] {"hello","world"};
		//��ʽһ��ʹ��forѭ��������Ԫ�ؼӽ�list
		List<String> list=new ArrayList<String>();
		for (String string : str) {
			list.add(string);
		}
		System.out.println(list);
		
		//��ʽ����
		List<String> list2=new ArrayList<String>(Arrays.asList(str));
		System.out.println(list2);
		
		//��ʽ����
		//ͬ������һ��ʹ����asList()�������ⲻ����õģ�
		//��ΪasList()���ص��б�Ĵ�С�ǹ̶��ġ�
		//��ʵ�ϣ����ص��б���java.util.ArrayList�࣬���Ƕ�����java.util.Arrays��һ��˽�о�̬��java.util.Arrays.ArrayList
		//����֪��ArrayList��ʵ�ֱ�������һ�����飬��asList()���ص��б�����ԭʼ����֧�ֵĹ̶���С���б�
		//��������£������ӻ�ɾ���б��е�Ԫ�أ�������׳��쳣UnsupportedOperationException��
		//java.util.Arrays.ArrayList����� set()��get()��contains()�ȷ��������ǲ��������add()��ɾ��remove()����,���Ե���add()�����ᱨ��
		List<String> list3 = Arrays.asList(str);
		//list3.remove(1);
		boolean contains = list3.contains("l");
		System.out.println(contains);
		System.out.println(list3);
		
		//��ʽ�ģ�ʹ��Collections.addAll()
		List<String> list4=new ArrayList<String>(str.length);
		Collections.addAll(list4, str);
		System.out.println(list4);
		
		//��ʽ�壺ʹ��Stream�е�Collector�ռ���
		//ת�����List ���� java.util.ArrayList �ܽ�����������ɾ�����
		List<String> list5=Stream.of(str).collect(Collectors.toList());
		System.out.println(list5);
	}
}

