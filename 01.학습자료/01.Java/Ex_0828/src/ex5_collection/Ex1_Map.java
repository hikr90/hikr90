package ex5_collection;

import java.util.HashMap;

public class Ex1_Map {
	public static void main(String[] args) {
		
		/* Map
		 * ���� key�� value�� ���� ���� �����Ͽ� Ư�� key�� Ư�� value�� ���� �� �ִ�.
		 * ��, key�� value �� ������ ���ʸ��� �־���Ѵ�.
		 * 
		 * Ű�� ���ؼ� ���� �˻��ϹǷ� ���� ���� �����͸� �˻��ϴµ� �־ �ӵ������� �پ ������ �����ش�.
		 * (if���� switch���� �ӵ� ���̿� ����.) 
		 * 
		 * HashMap, TreeMap �� ���̴� ����. 
		 * 
		 */
		 
		HashMap<Integer, Boolean> map1 = new HashMap<Integer, Boolean>(); 
		
		// Map�� put�� ����ؼ� ���� �����Ѵ�.
		map1.put(1, true);
		map1.put(2, false);
		map1.put(3, true);
		
		
		// ���� value�� �ߺ��� ����ϳ� key���� �ߺ��� ������� �ʴ´�.
		// ��� ���� �������� ����� Ű���� value���� ������.
		map1.put(3, false);
		
		
		// ���� ���� ���� �����ϴ� ���� ����� ����. 
		System.out.println("size : "+map1.size());
		System.out.println(map1);
		
		// ���� ������ ��, get�� ����Ѵ�.
		// objectŸ���� �����Ƿ� � Ÿ���̵� �� �޾Ƴ� �� �ִ�.
		System.out.println(map1.get(1));
		
		// ���� ���� �� ���� �´� Ÿ�Կ� �־�����Ѵ�. 
		boolean res = map1.get(2);
		
		// containskey
		// key���� ���ؼ� ã�� ���
		// boolean Ÿ������ ������ Ȯ���� �� �ִ�.
		if(map1.containsKey(1)) {
			System.out.println(map1.get(3));
		}
		
		// containsvalue
		// value�� ���� ã�� ���
		// � �濡 �� ���� �ִ��� �˻��� �Ұ����ϱ⿡ �� ���� ���� ���������� Ȯ���� �����ϴ�.
		if(map1.containsValue(true)) {
			System.out.println("map1���� true��� ���� ����Ǿ��ֽ��ϴ�.");
		}
		
		// key���� �˻��Ͽ� �� key���� value�� ����
		map1.remove(2);

		
		
		
		
		
		
		
		
		
		
		
	} // main
}
