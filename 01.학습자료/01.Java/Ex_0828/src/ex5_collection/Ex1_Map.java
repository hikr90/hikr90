package ex5_collection;

import java.util.HashMap;

public class Ex1_Map {
	public static void main(String[] args) {
		
		/*		map
		 * 		- key, value 두가지의 값이 한 쌍인 데이터의 집합 (key, value 두 종류의 제네릭 타입이 필요하다.)
		 * 		- 특정 key 값을 검색하여 value 값을 확인 가능하다.
		 * 		- 검색 속도가 빠르며 인덱스가 없다.
		 * 		- value 값의 중복은 가능하나 key의 중복은 마지막에 넣은 value값을 덮어씌우는 식으로 중복을 막는다.
		 * 
		 * 		map 의 자식클래스
		 * 			- HashMap : 정렬 기능이 존재
		 * 			- TreeMap : 오름차순으로 정렬
		 */
		HashMap<Integer, Boolean> map1 = new HashMap<Integer, Boolean>(); 
		//
		map1.put(1, true);	// put 을 통해서 값을 저장한다.
		map1.put(2, false);
		map1.put(3, true);
		map1.put(3, false);
		//
		System.out.println("size : "+map1.size());		// size는 맵의 길이를 나타낸다.
		System.out.println(map1);
		System.out.println(map1.get(1));		// map의 key값을 get 으로 가져올 수 있다.
		
		//
		boolean res = map1.get(2);
		
		// containskey
		// - key값을 통해서 찾는 방법
		// - boolean 타입으로 결과를 반환한다.
		if(map1.containsKey(1)) {
			System.out.println(map1.get(3));
		}
		
		// containsvalue
		// - value로 값을 찾는 방법
		// - 어떤 방에 그 값이 있는지 검색은 불가능하기에 그 값의 존재 유무만 확인 가능하다.
		if(map1.containsValue(true)) {
			System.out.println("map1에는 true라는 값이 저장되어있습니다.");
		}
		//
		map1.remove(2);	// remove 함수를 통해서 파라미터에 해당하는 key 값을 제거
	} // main
}
