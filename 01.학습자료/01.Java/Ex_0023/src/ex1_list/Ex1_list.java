package ex1_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Ex1_list {
	public static void main(String[] args) {
		/*	컬렉션 프레임워크
		 *		- 데이터 그룹을 저장하는 클래스들을 표준화한 설계
		 *		- 컬렉션은 다수의 데이터 (데이터 그룹)를, 프레임워크는 표준화된 프로그래밍 방식을 뜻한다.
		 *		- Vector 처럼 다수의 데이터를 저장할 수 있는 클래스를 컬렉션 클래스라고 부른다.
		 */
		
		/*
		 *		List
		 *			- 컬렉션 인터페이스에 상속
		 *			- 순서가 있는 데이터의 집합 (배열에 저장공간이 없어지면, 더 큰 배열을 새롭게 생성하여 복사한 뒤 사용)
		 *			- 데이터의 중복 허용
		 *			- 용량 변경 시, 새로운 배열을 생성하여 값을 복사한 뒤 주소를 이전하는 형태이므로 남용 시 효율이 많이 떨어진다.
		 *			- ArrayList, LinkedList, Stack
		 */
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		// 변수1부터 변수2까지의 저장된 객체를 반환한다.
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);
		
		// 객체 정렬
		Collections.sort(list1);
		Collections.sort(list2);
		
		print(list1, list2);
		
		// 객체 삭제
		list2.add("AA");
		list2.add("BB");
		list2.add("CC");
		
		// 객체의 인덱스가 삭제되는 경우 나머지 요소들이 자리이동하는 것을 방지하기 위해서 반복문을 감소 형식으로 작성
		for(int i=list2.size()-1;i>=0;i--) {
			if(list1.contains(list2.get(i))) list2.remove(i);
		}
		
		print(list1, list2);
		
		/*	(1.1) LinkedList
		 * 	- List의 단점을 보완하기위해서 개선된 자료구조
		 * 		1. 크기를 변경할 수 없다.
		 * 		2. 비순차적인 데이터의 추가, 삭제에 시간이 많이 든다. (복사, 이동)
		 * 
		 * 	- 기존의 list와 다르게, 불연속적으로 존재하는 데이터를 서로 연결한 형태
		 * 	- 링크드 리스트의 각 요소는 자신과 연결된 다음 요소에 대한 참조 (주소)와 데이터로 구성되어있다.
		 * 	- 그러므로 값 삭제 시 삭제하고자하는 요소의 이전 요소가 삭제하고자하는 다음 요소의 주소 값을 참조하면 된다.
		 * 	- 단, 링크드 리스트는 이동방향이 단방향뿐이므로 이전 요소에대한 접근은 어렵다.
		 * 
		 * 	- 이를 보완하고자, LinkedList 클래스는 doubleLinkedList로 구현되어 이전 요소의 주소까지 가지는 형태로 구현되어있다.
		 * 
		 * 	[결론]
		 * 		1. 순차적으로 추가/삭제하는 경우, ArrayList가 더 빠르다.
		 * 		2. 중간 데이터를 추가/삭제하는 경우 LinkedList가 더 빠르다.
		 * 		3. LinkedList는 저장된 데이터의 수가 많을 수록 데이터를 읽어오는데 시간이 많이 든다. (불연속이므로)
		 */
		LinkedList link = new LinkedList();
		link.add(new Integer(1));
		link.add(new Integer(2));
		link.add(new Integer(3));
		link.remove(1);
		
		System.out.println(link);
	}
	
	//
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println("----------------------");
	}
}
