package ex8_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex1_Collections {
	public static void main(String[] args) {
		/*	Collections
		 * 		- �÷��ǰ� ���õ� �޼ҵ带 �����ϴ� Ŭ����
		 * 		
		 * 		[����] �÷����� ����ȭ
		 * 			- ��Ƽ ������ ���α׷��ֿ����� �ϳ��� ��ü�� ���� �����尡 ���ÿ� ���� �����ϹǷ� �������� �ϰ����� �����ϱ����ؼ� ��ü�� ����ȭ�� �ʿ��ϴ�.
		 * 			- ArrayList, HashMap������ ���� ���ϸ� �������ؼ� ��ü������ ����ȭ�� ���� �ʰ� 
		 * 			- �ʿ��� ��Ȳ�� Collections Ŭ������ ����ȭ �޼ҵ带 ����Ѵ�.
		 * 			- (synchronized �� �پ��ִ� �� �÷����� �����Ͽ� ���)
		 * 
		 * 			List list 		= Collections.synchronizedList(List list);
		 * 			Set set 		= Collections.synchronizedSet(Set set);
		 * 			Map map 	= Collections.synchronizedMap(Map map);
		 * 
		 * 		[����] �б����� �÷���
		 * 			- ����� �����͸� ������ �� ���� �÷���
		 * 			- ��Ƽ ������ ���α׷��ֿ��� ���� �����尡 �ϳ��� �÷����� ����ϴٰ� �����Ͱ� �ջ�Ǵ� ��Ȳ ����
		 * 
		 * 			static List 		unmodifiableList(List list);
		 * 			static Set 		unmodifiableSet(Set set);
		 * 			static Map 	unmodifiableMap(Map map);
		 * 
		 * 		[����] Singleton Collections
		 * 			- �� �ϳ����� ��ü�� �����ϴ� �÷����� ���Ѵ�. 
		 * 			- �Ű������� ������ ��Ҹ� �����ϸ�, �ش� ��Ҹ� �����ϴ� �÷����� ��ȯ�Ѵ�. 
		 * 			- ��ȯ�� �÷����� ������ �� ����.
		 * 
		 * 			static List singletonList(Object obj);
		 * 			static List singleton(Object obj);
		 * 			static Map singletonMap(Object key, Object value);
		 */
			
		// �÷��� �޼ҵ�
		List list = new ArrayList();
		
		// �ѹ��� ����
		Collections.addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		// ���� ����ŭ ���������� �̵�
		Collections.rotate(list, 2);
		System.out.println(list);
		
		// ����1�� ����2�� ��ġ ����
		Collections.swap(list, 0, 2);
		System.out.println(list);
		
		//  ����� ��ġ�� ���Ƿ� ����
		Collections.shuffle(list);
		System.out.println(list);
		
		//  ����
		Collections.sort(list);
		System.out.println(list);
		
		//  ���� ����
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		// ������ ����� ��ġ ��ȯ
		int idx = Collections.binarySearch(list, 3);
		System.out.println(idx);
		
		// ������ ä���
		Collections.fill(list, 9);
		System.out.println(list);
		
		// ���ο� ����Ʈ ���� �� �����ŭ ������ ä���
		List list2 = Collections.nCopies(list.size(), 2);
		System.out.println(list2);
		
		// ���� ��Ұ� �ִ��� ��
		System.out.println(Collections.disjoint(list, list2));
		
		// ����
		// ����2�� �����͸� ����1�� ����
		Collections.copy(list, list2);
		System.out.println(list);
		System.out.println(list2);
		
		// ġȯ
		//  ����2�� �����͸� ������ 1�� ġȯ
		Collections.replaceAll(list, 2, 1);
		System.out.println(list);
	}
}
