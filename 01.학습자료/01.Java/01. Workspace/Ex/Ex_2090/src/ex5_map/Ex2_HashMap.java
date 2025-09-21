package ex5_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex2_HashMap {
	public static void main(String[] args) {
		/*	Map 
		 * 	- 키와 값이 쌍으로 이루어진 데이터의 집합
		 * 	- 순서는 유지되지 않는다.
		 * 	- 키는 중복을 허용하지 않으나 값은 중복을 허용한다.
		 * 	- 기존에 저장된 키 값에 동일한 키 값이 저장되는 경우 덮여쓰여지는 방식
		 * 	- Hashing을 사용하여 많은 양의 데이터를 검색하는데 성능이 좋다.
		 * 	- HashMap, TreeMap
		 * 
		 * 		[참고] HashMap의 구조
		 * 			- Entry라는 내부 클래스를 정의하고, 다시 Entry 타입의 배열을 선언한다.
		 * 			- Key와 Value는 서로 관련된 값이므로 각각의 배열로 따로 선언하는 것보다 하나의 클래스로 정의하여 하나의 배열로 다루는 방식 (객체지향적) 무결성 측면에서 바람직하다.
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
				// (1) 값이 존재하는 경우 해당 key값에 1 증가
				Integer value = (Integer) map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
			
			} else {
				// (2) 값이 존재하지 않는 경우 새로운 key값에 1추가
				map.put(data[i], new Integer(1));
			}
		}
		
		// 조회
		// entrySet : HashMap에 저장된 키, 값을 엔트리 (키와 값의 형태)로 Set에 저장하여 반환
		Iterator it = map.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			int value = (Integer) entry.getValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
		
		/* 해싱, 해시 함수 
		 * 	(1) 해싱
		 * 		- 해시 함수를 이용하여 데이터를 해시 테이블에 저장하고 검색하는 기법
		 * 		- 해싱을 구현한 컬렉션 클래스는 HashSet, HashMap, Hashtable 등이 있다.
		 * 		
		 * 		[참고] 해싱의 자료구조
		 * 			- 배열과 LinkedList 의 조합 형태
		 * 			- 저장할 데이터의 Key를 해시함수에 넣으면 배열의 한 요소를 얻게되고, 다시 그 곳에 연결되어있는 LinkedList에 저장한다.
		 * 
		 * 				데이터1 > 데이터1.1 > 데이터1.2
		 * 				데이터2 > 데이터2.1
		 * 				데이터3
		 * 				데이터4 > 데이터4.1
		 * 
		 *			[참고] 해시함수의 조회
		 * 			(1) 조회하고자하는 키 값이 해시 함수에 진입
		 * 			(2) 해시 함수에서 hashCode 함수를 통해서 해시 코드를 반환 (배열의 요소 주소)
		 * 			(3) 반환된 주소 값을 가지로 해당 링크드 리스트 (요소)에 접근하여 검색한 키와 일치하는 데이터 조회
		 * 
		 * 		[참고] String 클래스의 해시 함수
		 * 			- HashMap 같은 해싱을 구현한 클래스에서는 Object 클래스에 정의된 hashCode 함수를 사용하므로
		 * 			- 객체의 주소를 이용하여 해시 코드를 생성하므로 모든 객체에 대해서 주소를 비교하는 것이 가장 좋은 방법이다.
		 * 		
		 * 			- 단, String 클래스의 경우 Object로부터 상속받은 hashCode를 오버라이딩하여
		 * 			- 문자열의 내용으로 해시 코드를 생성한다.
		 * 			- 즉, 서로 다른 인스턴스이라도 동일한 문자열 값이라면 같은 해시 코드를 반환한다.
		 * 			-  String 클래스에서 해시 코드로 비교하고자할 때는 equals와 hashCode 두가지를 오버라이딩하여 비교해야한다.
		 */
	} 
	
	// 문자 (#) 처리
	public static String printBar(char ch, int value) {
		//
		char [] bar = new char[value];
		
		for(int i=0; i<bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);
	}
}
