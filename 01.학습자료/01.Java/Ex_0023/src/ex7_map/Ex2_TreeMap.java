package ex7_map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Ex2_TreeMap {
	public static void main(String[] args) {
		// TreeMap
		//		- 범위검색, 정렬이 가능한 Map 형태의 구조
		//		- 성능적으로는 HashMap이 더 뛰어나 범위검색, 정렬 외에는 잘 사용되지 않는다.
		String [] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K" ,"Z", "D"};
		TreeMap map = new TreeMap();
		
		for(int i = 0; i<data.length; i++) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer) map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
			} else {
				map.put(data[i], new Integer(1));
			}
		}

		// 기본 정렬 (오름차순)
		Iterator it = map.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			int value = (Integer) entry.getValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
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
