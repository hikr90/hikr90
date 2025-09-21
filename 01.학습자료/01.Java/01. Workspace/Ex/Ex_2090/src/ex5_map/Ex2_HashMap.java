package ex5_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex2_HashMap {
	public static void main(String[] args) {
		/*	Map 
		 * 	- Ű�� ���� ������ �̷���� �������� ����
		 * 	- ������ �������� �ʴ´�.
		 * 	- Ű�� �ߺ��� ������� ������ ���� �ߺ��� ����Ѵ�.
		 * 	- ������ ����� Ű ���� ������ Ű ���� ����Ǵ� ��� ������������ ���
		 * 	- Hashing�� ����Ͽ� ���� ���� �����͸� �˻��ϴµ� ������ ����.
		 * 	- HashMap, TreeMap
		 * 
		 * 		[����] HashMap�� ����
		 * 			- Entry��� ���� Ŭ������ �����ϰ�, �ٽ� Entry Ÿ���� �迭�� �����Ѵ�.
		 * 			- Key�� Value�� ���� ���õ� ���̹Ƿ� ������ �迭�� ���� �����ϴ� �ͺ��� �ϳ��� Ŭ������ �����Ͽ� �ϳ��� �迭�� �ٷ�� ��� (��ü������) ���Ἲ ���鿡�� �ٶ����ϴ�.
		 * 			
		 * 			Entry [] table;
		 * 
		 * 			static class Entry implement Map.Entry {
		 * 				final Object key;
		 * 				Object value;
		 * 			}
		 */
		
		HashMap map = new HashMap();
		String [] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};
		
		for(int i=0; i<data.length; i++) {
			if(map.containsKey(data[i])) {
				// (1) ���� �����ϴ� ��� �ش� key���� 1 ����
				Integer value = (Integer) map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
			
			} else {
				// (2) ���� �������� �ʴ� ��� ���ο� key���� 1�߰�
				map.put(data[i], new Integer(1));
			}
		}
		
		// ��ȸ
		// entrySet : HashMap�� ����� Ű, ���� ��Ʈ�� (Ű�� ���� ����)�� Set�� �����Ͽ� ��ȯ
		Iterator it = map.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			int value = (Integer) entry.getValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
		
		/* �ؽ�, �ؽ� �Լ� 
		 * 	(1) �ؽ�
		 * 		- �ؽ� �Լ��� �̿��Ͽ� �����͸� �ؽ� ���̺� �����ϰ� �˻��ϴ� ���
		 * 		- �ؽ��� ������ �÷��� Ŭ������ HashSet, HashMap, Hashtable ���� �ִ�.
		 * 		
		 * 		[����] �ؽ��� �ڷᱸ��
		 * 			- �迭�� LinkedList �� ���� ����
		 * 			- ������ �������� Key�� �ؽ��Լ��� ������ �迭�� �� ��Ҹ� ��Եǰ�, �ٽ� �� ���� ����Ǿ��ִ� LinkedList�� �����Ѵ�.
		 * 
		 * 				������1 > ������1.1 > ������1.2
		 * 				������2 > ������2.1
		 * 				������3
		 * 				������4 > ������4.1
		 * 
		 *			[����] �ؽ��Լ��� ��ȸ
		 * 			(1) ��ȸ�ϰ����ϴ� Ű ���� �ؽ� �Լ��� ����
		 * 			(2) �ؽ� �Լ����� hashCode �Լ��� ���ؼ� �ؽ� �ڵ带 ��ȯ (�迭�� ��� �ּ�)
		 * 			(3) ��ȯ�� �ּ� ���� ������ �ش� ��ũ�� ����Ʈ (���)�� �����Ͽ� �˻��� Ű�� ��ġ�ϴ� ������ ��ȸ
		 * 
		 * 		[����] String Ŭ������ �ؽ� �Լ�
		 * 			- HashMap ���� �ؽ��� ������ Ŭ���������� Object Ŭ������ ���ǵ� hashCode �Լ��� ����ϹǷ�
		 * 			- ��ü�� �ּҸ� �̿��Ͽ� �ؽ� �ڵ带 �����ϹǷ� ��� ��ü�� ���ؼ� �ּҸ� ���ϴ� ���� ���� ���� ����̴�.
		 * 		
		 * 			- ��, String Ŭ������ ��� Object�κ��� ��ӹ��� hashCode�� �������̵��Ͽ�
		 * 			- ���ڿ��� �������� �ؽ� �ڵ带 �����Ѵ�.
		 * 			- ��, ���� �ٸ� �ν��Ͻ��̶� ������ ���ڿ� ���̶�� ���� �ؽ� �ڵ带 ��ȯ�Ѵ�.
		 * 			-  String Ŭ�������� �ؽ� �ڵ�� ���ϰ����� ���� equals�� hashCode �ΰ����� �������̵��Ͽ� ���ؾ��Ѵ�.
		 */
	} 
	
	// ���� (#) ó��
	public static String printBar(char ch, int value) {
		//
		char [] bar = new char[value];
		
		for(int i=0; i<bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);
	}
}
