package ex3_iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public class Ex1_Iterator {
	public static void main(String[] args) {
		/* Iterator
		 *		- �÷��ǿ� ����� ��ҿ� �����ϴµ� ���Ǵ� �������̽�
		 *		- Iterator�� �÷��� �������̽��� ���ǵ� �޼ҵ��̹Ƿ� �ڼ��� List�� Set���� ���ԵǾ��ִ�.
		 *		- �÷��� Ŭ������ ���� Iterator()�� ȣ���Ͽ� Iterator�� ���� �� �ݺ����� ���ؼ� �÷��� Ŭ������ ��Ҹ� �����´�. 
		 */
		
		// �÷��� �������̽��� ������ �ٸ� Ŭ���� ��� ��, �޼ҵ� ���並 ��ġ�� �ʾƵ� �ǹǷ� �÷����� ���������� ����Ѵ�.
		// (�÷��� �������̽��� �����ϴ� �ٸ� Ŭ������ �����Ͽ� �״�� ��� ����)
		Collection c = new ArrayList();
		c.add("1");
		c.add("2");
		c.add("3");
		
		// Iterator���� �÷����� ��Ҹ� ǥ��ȭ�� ������� ��ȸ
		// (�÷��� ���� ������� ����� ��� ���)
		Iterator it = c.iterator();
		print(it);
		
		// [����] Map�� ���, Ű�� ���� ������ �����ϹǷ� Iterator�� ���� ȣ���� �� ����.
		// - keySet�̳� entrySet���� Ű�� ���� ���� ���� Set�� ���·� ���� �� Iterator�� ȣ���Ѵ�.
		Map m = new HashMap();
		m.put("1", "AAA");
		m.put("2", "BBB");
		m.put("3", "CCC");
		
		Iterator i = m.entrySet().iterator();
		print(i);
		
		// ListIterator
		// 	- Iterator�� ������ ��ȸ ��� �߰�
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		
		ListIterator lit = list.listIterator();
		
		while(lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
	}
	
	//
	static public void print(Iterator it) {
		//
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("------------------");
	}
}
