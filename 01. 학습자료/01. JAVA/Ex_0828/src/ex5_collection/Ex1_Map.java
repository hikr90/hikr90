package ex5_collection;

import java.util.HashMap;

public class Ex1_Map {
	public static void main(String[] args) {
		
		/* Map
		 * 맵은 key와 value의 값이 따로 존재하여 특정 key로 특정 value를 받을 수 있다.
		 * 즉, key와 value 두 종류의 제너릭이 있어야한다.
		 * 
		 * 키를 통해서 값을 검색하므로 많은 양의 데이터를 검색하는데 있어서 속도적으로 뛰어난 성능을 보여준다.
		 * (if문과 switch문의 속도 차이와 같다.) 
		 * 
		 * HashMap, TreeMap 의 차이는 같다. 
		 * 
		 */
		 
		HashMap<Integer, Boolean> map1 = new HashMap<Integer, Boolean>(); 
		
		// Map은 put을 사용해서 값을 저장한다.
		map1.put(1, true);
		map1.put(2, false);
		map1.put(3, true);
		
		
		// 맵은 value의 중복은 허용하나 key값의 중복을 허용하지 않는다.
		// 고로 가장 마지막에 적용된 키값의 value값을 따른다.
		map1.put(3, false);
		
		
		// 맵은 같은 값을 저장하는 것은 상관이 없다. 
		System.out.println("size : "+map1.size());
		System.out.println(map1);
		
		// 맵을 가져올 때, get을 사용한다.
		// object타입을 받으므로 어떤 타입이든 다 받아낼 수 있다.
		System.out.println(map1.get(1));
		
		// 담은 값은 그 값에 맞는 타입에 넣어줘야한다. 
		boolean res = map1.get(2);
		
		// containskey
		// key값을 통해서 찾는 방법
		// boolean 타입으로 유무를 확인할 수 있다.
		if(map1.containsKey(1)) {
			System.out.println(map1.get(3));
		}
		
		// containsvalue
		// value로 값을 찾는 방법
		// 어떤 방에 그 값이 있는지 검색은 불가능하기에 그 값의 존재 유무정도만 확인이 가능하다.
		if(map1.containsValue(true)) {
			System.out.println("map1에는 true라는 값이 저장되어있습니다.");
		}
		
		// key값을 검색하여 그 key값과 value를 제거
		map1.remove(2);

		
		
		
		
		
		
		
		
		
		
		
	} // main
}
