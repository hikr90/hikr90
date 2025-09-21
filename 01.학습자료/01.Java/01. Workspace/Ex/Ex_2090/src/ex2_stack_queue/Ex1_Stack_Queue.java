package ex2_stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex1_Stack_Queue {
	public static void main(String[] args) {
		/*	Stack & Queue
		 *		- �ڹٿ��� �����ϴ� �ڷᱸ��
		 *		- �ڹٿ����� ������ Ŭ������ �����Ͽ� �����ϳ�, ť�� �������̽��θ� �����صξ����Ƿ� ť�������ϴ� Ŭ������ �����ؾ��Ѵ�.
		 *		- ��) LinkedList
		 *		
		 *		(1) Stack
		 *			- �������� ������ �����͸� ���� ���� ������ �Ǵ� �ڷᱸ�� (Last In First Out)
		 *			- ������ ����
		 *			- ���������� �����͸� �߰�/�����ϴ� ����� ArrayList ��� ����
		 *		
		 *		(2) Queue
		 *			- ó���� ������ �����͸� ���� ���� ������ �Ǵ� �ڷᱸ�� (First In First Out)
		 *			- ������ ����
		 *			- �׻� ù��°�� �����ͺ��� �����ǹǷ� LinkedList ��� ����
		 */
		Stack st = new Stack();
		Queue q = new LinkedList(); // ť �������̽��� ����ü�� ��ũ�� ����Ʈ ���
		
		// �߰�
		st.add("0");
		st.add("1");
		st.add("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		// ���
		System.out.println("= Stack =");
		while (!st.empty()) {
			System.out.println(st.pop());	// ��ü ��� (�� ��� ���ܹ߻�)
		}
		
		System.out.println("= Queue =");
		while (!q.isEmpty()) {
			System.out.println(q.poll());	// ��ü ��� (�� ��� ���ܹ߻�)
		}
	}
}
