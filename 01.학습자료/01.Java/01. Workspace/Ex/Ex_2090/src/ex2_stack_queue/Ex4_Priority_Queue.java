package ex2_stack_queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Ex4_Priority_Queue {
	public static void main(String[] args) {
		/*	PriorityQueue 
		 * 	- ť �������̽��� ����ü �� �ϳ���, ���� ������ ������� �켱������ ���� �ͺ��� ������ �ڷᱸ��
		 * 	- null ���� �� ���� �߻�
		 * 	- ����������� �迭�� ����ϸ�, �� ��Ҹ� ���̶�� �ڷᱸ���� �����Ѵ�.
		 * 	- (�ڷ� ���� ���� JVM�� ������ �ٸ���.)
		 */
		Queue pq = new PriorityQueue();
		
		pq.offer(3);
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);
		
		Object obj = new Object();
		
		// ť �ȿ� ����� ��Ҹ� �ϳ��� ������.
		while ((obj = pq.poll()) != null) {
			// �켱������ ���ڰ� �������� ����.
			System.out.println(obj);	
		}
	}
}
