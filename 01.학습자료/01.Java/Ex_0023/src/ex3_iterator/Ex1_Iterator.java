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
		 *		- 컬렉션에 저장된 요소에 접근하는데 사용되는 인터페이스
		 *		- Iterator는 컬렉션 인터페이스에 정의된 메소드이므로 자손인 List와 Set에도 포함되어있다.
		 *		- 컬렉션 클래스에 대해 Iterator()를 호출하여 Iterator를 받은 뒤 반복문을 통해서 컬렉션 클래스의 요소를 가져온다. 
		 */
		
		// 컬렉션 인터페이스를 구현한 다른 클래스 사용 시, 메소드 검토를 거치지 않아도 되므로 컬렉션을 참조변수로 사용한다.
		// (컬렉션 인터페이스를 구현하는 다른 클래스로 변경하여 그대로 사용 가능)
		Collection c = new ArrayList();
		c.add("1");
		c.add("2");
		c.add("3");
		
		// Iterator으로 컬렉션의 요소를 표준화된 방식으로 조회
		// (컬렉션 종류 상관없이 공통된 방식 사용)
		Iterator it = c.iterator();
		print(it);
		
		// [참고] Map의 경우, 키와 값이 쌍으로 존재하므로 Iterator를 직접 호출할 수 없다.
		// - keySet이나 entrySet으로 키와 값을 각각 따로 Set의 형태로 얻어온 뒤 Iterator를 호출한다.
		Map m = new HashMap();
		m.put("1", "AAA");
		m.put("2", "BBB");
		m.put("3", "CCC");
		
		Iterator i = m.entrySet().iterator();
		print(i);
		
		// ListIterator
		// 	- Iterator에 역방향 조회 기능 추가
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
