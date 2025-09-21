package ex2_stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex1_Stack_Queue {
	public static void main(String[] args) {
		/*	Stack & Queue
		 *		- 자바에서 제공하는 자료구조
		 *		- 자바에서는 스택은 클래스로 구현하여 제공하나, 큐는 인터페이스로만 정의해두었으므로 큐를구현하는 클래스를 선택해야한다.
		 *		- 예) LinkedList
		 *		
		 *		(1) Stack
		 *			- 마지막에 저장한 데이터를 가장 먼저 꺼내게 되는 자료구조 (Last In First Out)
		 *			- 동전통 형태
		 *			- 순차적으로 데이터를 추가/삭제하는 방식은 ArrayList 사용 적합
		 *		
		 *		(2) Queue
		 *			- 처음에 저장한 데이터를 가장 먼저 꺼내게 되는 자료구조 (First In First Out)
		 *			- 파이프 형태
		 *			- 항상 첫번째의 데이터부터 삭제되므로 LinkedList 사용 적합
		 */
		Stack st = new Stack();
		Queue q = new LinkedList(); // 큐 인터페이스의 구현체인 링크드 리스트 사용
		
		// 추가
		st.add("0");
		st.add("1");
		st.add("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		// 출력
		System.out.println("= Stack =");
		while (!st.empty()) {
			System.out.println(st.pop());	// 객체 출력 (빈 경우 예외발생)
		}
		
		System.out.println("= Queue =");
		while (!q.isEmpty()) {
			System.out.println(q.poll());	// 객체 출력 (빈 경우 예외발생)
		}
	}
}
