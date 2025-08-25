package ex8_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex1_Collections {
	public static void main(String[] args) {
		/*	Collections
		 * 		- 컬렉션과 관련된 메소드를 제공하는 클래스
		 * 		
		 * 		[참고] 컬렉션의 동기화
		 * 			- 멀티 쓰레드 프로그래밍에서는 하나의 객체를 여러 쓰레드가 동시에 접근 가능하므로 데이터의 일관성을 유지하기위해서 객체의 동기화가 필요하다.
		 * 			- ArrayList, HashMap에서는 성능 저하를 막기위해서 자체적으로 동기화를 하지 않고 
		 * 			- 필요한 상황에 Collections 클래스의 동기화 메소드를 사용한다.
		 * 			- (synchronized 가 붙어있는 각 컬렉션을 선언하여 사용)
		 * 
		 * 			List list 		= Collections.synchronizedList(List list);
		 * 			Set set 		= Collections.synchronizedSet(Set set);
		 * 			Map map 	= Collections.synchronizedMap(Map map);
		 * 
		 * 		[참고] 읽기전용 컬렉션
		 * 			- 저장된 데이터를 변경할 수 없는 컬렉션
		 * 			- 멀티 쓰레드 프로그래밍에서 여러 쓰레드가 하나의 컬렉션을 사용하다가 데이터가 손상되는 상황 방지
		 * 
		 * 			static List 		unmodifiableList(List list);
		 * 			static Set 		unmodifiableSet(Set set);
		 * 			static Map 	unmodifiableMap(Map map);
		 * 
		 * 		[참고] Singleton Collections
		 * 			- 단 하나만의 객체를 저장하는 컬렉션을 뜻한다. 
		 * 			- 매개변수로 저장할 요소를 지정하면, 해당 요소를 저장하는 컬렉션을 반환한다. 
		 * 			- 반환된 컬렉션은 변경할 수 없다.
		 * 
		 * 			static List singletonList(Object obj);
		 * 			static List singleton(Object obj);
		 * 			static Map singletonMap(Object key, Object value);
		 */
			
		// 컬렉션 메소드
		List list = new ArrayList();
		
		// 한번에 저장
		Collections.addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		// 변수 값만큼 오른쪽으로 이동
		Collections.rotate(list, 2);
		System.out.println(list);
		
		// 변수1과 변수2의 위치 변경
		Collections.swap(list, 0, 2);
		System.out.println(list);
		
		//  요소의 위치를 임의로 변경
		Collections.shuffle(list);
		System.out.println(list);
		
		//  정렬
		Collections.sort(list);
		System.out.println(list);
		
		//  역순 정렬
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		// 변수가 저장된 위치 반환
		int idx = Collections.binarySearch(list, 3);
		System.out.println(idx);
		
		// 데이터 채우기
		Collections.fill(list, 9);
		System.out.println(list);
		
		// 새로운 리스트 복사 후 사이즈만큼 변수로 채우기
		List list2 = Collections.nCopies(list.size(), 2);
		System.out.println(list2);
		
		// 공통 요소가 있는지 비교
		System.out.println(Collections.disjoint(list, list2));
		
		// 복사
		// 변수2의 데이터를 변수1에 복사
		Collections.copy(list, list2);
		System.out.println(list);
		System.out.println(list2);
		
		// 치환
		//  변수2의 데이터를 변수로 1로 치환
		Collections.replaceAll(list, 2, 1);
		System.out.println(list);
	}
}
