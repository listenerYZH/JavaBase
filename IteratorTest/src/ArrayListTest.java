import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class ArrayListTest {
	 private static ArrayList<String> aList = new ArrayList<String>();
	//ʹ�õ���������Ԫ�ع����У����ü��ϵ� remove(Object obj) �������ܻᱨ java.util.ConcurrentModificationException �쳣
    public static void main(String[] args) {
        
         aList.add("111");
         aList.add("222");
         aList.add("333");
         System.out.println("�Ƴ�ǰ��"+aList);
         
         Iterator<String> iterator = aList.iterator();
         //�굥�����߳��н��б��������Ƿ����ı�󣬻�����̶߳Աȣ�ָ�벻һ������
         while(iterator.hasNext())
         {
        	 String next = iterator.next();
             if("222".equals(next))
             {	
            	 //�ᱨ�쳣
            	 //aList.remove("333");
            	 //��ɾ��it.next���ص�ֵ��
            	 iterator.remove();          
             }
         }
         System.out.println("�Ƴ���"+aList);
    }
    
    //JDK 1.8 Iterator forEachRemaining ������ ����Iterator �� remove �����ᱨ java.lang.IllegalStateException �쳣
    public static void testForEachRemainingIteRemove () {
        final Iterator<String> iterator = aList.iterator();
        iterator.forEachRemaining(new Consumer<String>() {
 
            public void accept(String t) {
                if ("222".equals(t)) {
                    iterator.remove();
                }
            }
        });
    }
}
