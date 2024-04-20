package ex4_collection;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex1_Set {
	
	public static void main(String[] args) {
		
	
	/* 컬렉션 프레임 워크 : 다수의 데이터(객체)를 표준화된 프로그램 방식으로 개발 가능하게 하는 클래스들을 의미한다.
	 * 
	 * 컬렉션은 핵심인터페이스 set과 map, list가 있다.
	 * 위 셋은 전부 제너릭 타입을 요구한다.
	 * 
	 * Set : java.util패키지에 존재하는 인터페이스
	 * 특정 코드에서 중복된 값을 허용해서는 안될 때 사용하는 인터페이스
	 * 
	 * Set의 자식클래스
	 * HashSet : 정렬 기능이 없다. 
	 * TreeSet : 오름차순 정렬이 가능하다.
	 * 
	 * 
	 */
		
	// (1분) 정수타입만 저장하고 꺼내는 것이 가능하다.
	// 컬렉션은 배열과는 다르게 방 갯수의 제한이 없다.
	HashSet<Integer> hs1 = new HashSet<Integer>();
	// add에 적은 정수값을 hs1에 저장
	// add시마다 size(length)라는 값이 1씩 증가한다. 같은 값을 추가하면 늘지 않는다.
	hs1.add(100);
	hs1.add(60);
	hs1.add(15);
	// 중복된 값을 넣을 수는 있어도 출력시에는 중복되는 값은 제외한다. 
	hs1.add(15);
	
	// remove는 값을 삭제하는데 방번호가 아닌 실제 값을 입력한다.
	hs1.remove(15);
	
	// 메모리가 연결되어있지 않아 마지막에 저장된 값이 중간에서 출력되기도 한다.
	hs1.add(37);
	
	
	
	// 배열과 컬렉션의 차이
	// 배열은 방마다 각자의 주소값이 순차적으로 붙어있지만
	// 컬렉션은 값이 붙어있는 구조는 아니여서 주소값이 순차적으로 없다. 즉, index가 없다.
	
	// 컬렉션은 주소값이 없어, for문으로 출력이 불가능하다. 그래서 객체를 통째로 출력한다.
	System.out.println(hs1);
	
	//hs1의 모든 내용이 제거된다.
	hs1.clear();
	
	
	// 컬렉션 HashSet을 통한 로또 번호 생성기 
	while(true) {
		int r = new Random().nextInt(45)+1;
		hs1.add(r);
		
		if(hs1.size()==6) {
			break;
		}
	}
	
	System.out.println(hs1);
	System.out.println("-----------------");
	
	
	// 컬렉션 TreeSet을 통해서 로또 생성
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
	
	
	TreeSet<String> ts2 = new TreeSet<String>();
	ts2.add("홍길동");
	ts2.add("차길순");
	ts2.add("김초복");
	ts2.add("이중복");
	
	System.out.println(ts2);
	
	
	
	
	
	
	
	} // main
}
