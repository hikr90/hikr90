package ex4_collection;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex1_Set {
	
	public static void main(String[] args) {
	
	   /* 	컬렉션 프레임워크
		*		- 다수의 데이터 (객체) 를 표준화된 프로그램 방식으로 개발 가능하도록 돕는 클래스를 의미한다.
		*		- 핵심 인터페이스로 set, map, list 가 있다.
		*		- 위 세가지는 제너릭 타입을 요구한다.
		*/
		
		/*		set
		 * 		- java.util 패키지에 존재하는 인터페이스
		 * 		- 순서 (인덱스)가 없는 데이터의 집합
		 * 		- 중복된 값을 저장할 수 있으나 중복이 허용되지 않는다.
		 * 
		 * 		set의 자식클래스
		 * 			(1.1) HashSet : 정렬 기능이 존재
		 * 			(1.2) TreeSet : 오름차순 정렬
		 */

		// hashSet 선언
		HashSet<Integer> hs1 = new HashSet<Integer>();
		//
		hs1.add(100);		// add 값으로 값을 추가한다.
		hs1.add(60);			// 같은 값을 추가할 수 있으나 중복되는 값은 제외한다.
		hs1.add(15);
		hs1.add(15);
		//
		hs1.remove(15);	// remove로 값을 제거한다. (파라미터로는 실제 값을 넣는다.)
		hs1.add(37);			// 메모리 상에서 순서로 연결되어있지 않아서 값이 중간에서 나오기도 한다.
	
		// set 은 주소 값이 없으므로 반복문없이 객체를 통째로 확인한다.
		System.out.println(hs1);
	
		hs1.clear();			// clear 함수로 set 내에 있는 모든 내용을 제거한다.
	
		// HashSet을 통한 로또 번호 생성기 
		while(true) {
			int r = new Random().nextInt(45)+1;
			hs1.add(r);
			
			if(hs1.size()==6) {
				break;
			}
		}
	
		System.out.println(hs1);
		System.out.println("-----------------");
	
	
		// TreeSet을 통해서 로또 생성
		TreeSet<Integer> ts1 = new TreeSet<Integer>();
	
		while(true) {
			int r = new Random().nextInt(45)+1;
			ts1.add(r);
			
			if(ts1.size()==6) {
				break;
			}
		}
		
		System.out.println(ts1);
		System.out.println("-----------------");
		//
		TreeSet<String> ts2 = new TreeSet<String>();
		ts2.add("홍길동");
		ts2.add("차길순");
		ts2.add("김초복");
		ts2.add("이중복");
		
		System.out.println(ts2);
	} // main
}
