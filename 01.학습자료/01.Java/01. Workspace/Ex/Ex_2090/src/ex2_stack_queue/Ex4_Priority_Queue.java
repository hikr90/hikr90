package ex2_stack_queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Ex4_Priority_Queue {
	public static void main(String[] args) {
		/*	PriorityQueue 
		 * 	- 큐 인터페이스의 구현체 중 하나로, 저장 순서에 관계없이 우선순위가 높은 것부터 꺼내는 자료구조
		 * 	- null 저장 시 예외 발생
		 * 	- 저장공간으로 배열을 사용하며, 각 요소를 힙이라는 자료구조에 저장한다.
		 * 	- (자료 구조 힙은 JVM의 힙과는 다르다.)
		 */
		Queue pq = new PriorityQueue();
		
		pq.offer(3);
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);
		
		Object obj = new Object();
		
		// 큐 안에 저장된 요소를 하나씩 꺼낸다.
		while ((obj = pq.poll()) != null) {
			// 우선순위는 숫자가 작을수록 높다.
			System.out.println(obj);	
		}
	}
}
