package ex5_collection;

import java.util.HashMap;

public class Ex1_Map {
	public static void main(String[] args) {
		
		/*		map
		 * 		- key, value �ΰ����� ���� �� ���� �������� ���� (key, value �� ������ ���׸� Ÿ���� �ʿ��ϴ�.)
		 * 		- Ư�� key ���� �˻��Ͽ� value ���� Ȯ�� �����ϴ�.
		 * 		- �˻� �ӵ��� ������ �ε����� ����.
		 * 		- value ���� �ߺ��� �����ϳ� key�� �ߺ��� �������� ���� value���� ������ ������ �ߺ��� ���´�.
		 * 
		 * 		map �� �ڽ�Ŭ����
		 * 			- HashMap : ���� ����� ����
		 * 			- TreeMap : ������������ ����
		 */
		HashMap<Integer, Boolean> map1 = new HashMap<Integer, Boolean>(); 
		//
		map1.put(1, true);	// put �� ���ؼ� ���� �����Ѵ�.
		map1.put(2, false);
		map1.put(3, true);
		map1.put(3, false);
		//
		System.out.println("size : "+map1.size());		// size�� ���� ���̸� ��Ÿ����.
		System.out.println(map1);
		System.out.println(map1.get(1));		// map�� key���� get ���� ������ �� �ִ�.
		
		//
		boolean res = map1.get(2);
		
		// containskey
		// - key���� ���ؼ� ã�� ���
		// - boolean Ÿ������ ����� ��ȯ�Ѵ�.
		if(map1.containsKey(1)) {
			System.out.println(map1.get(3));
		}
		
		// containsvalue
		// - value�� ���� ã�� ���
		// - � �濡 �� ���� �ִ��� �˻��� �Ұ����ϱ⿡ �� ���� ���� ������ Ȯ�� �����ϴ�.
		if(map1.containsValue(true)) {
			System.out.println("map1���� true��� ���� ����Ǿ��ֽ��ϴ�.");
		}
		//
		map1.remove(2);	// remove �Լ��� ���ؼ� �Ķ���Ϳ� �ش��ϴ� key ���� ����
	} // main
}
