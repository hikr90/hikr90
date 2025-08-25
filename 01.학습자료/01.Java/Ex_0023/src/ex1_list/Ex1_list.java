package ex1_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Ex1_list {
	public static void main(String[] args) {
		/*	�÷��� �����ӿ�ũ
		 *		- ������ �׷��� �����ϴ� Ŭ�������� ǥ��ȭ�� ����
		 *		- �÷����� �ټ��� ������ (������ �׷�)��, �����ӿ�ũ�� ǥ��ȭ�� ���α׷��� ����� ���Ѵ�.
		 *		- Vector ó�� �ټ��� �����͸� ������ �� �ִ� Ŭ������ �÷��� Ŭ������� �θ���.
		 */
		
		/*
		 *		List
		 *			- �÷��� �������̽��� ���
		 *			- ������ �ִ� �������� ���� (�迭�� ��������� ��������, �� ū �迭�� ���Ӱ� �����Ͽ� ������ �� ���)
		 *			- �������� �ߺ� ���
		 *			- �뷮 ���� ��, ���ο� �迭�� �����Ͽ� ���� ������ �� �ּҸ� �����ϴ� �����̹Ƿ� ���� �� ȿ���� ���� ��������.
		 *			- ArrayList, LinkedList, Stack
		 */
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		// ����1���� ����2������ ����� ��ü�� ��ȯ�Ѵ�.
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);
		
		// ��ü ����
		Collections.sort(list1);
		Collections.sort(list2);
		
		print(list1, list2);
		
		// ��ü ����
		list2.add("AA");
		list2.add("BB");
		list2.add("CC");
		
		// ��ü�� �ε����� �����Ǵ� ��� ������ ��ҵ��� �ڸ��̵��ϴ� ���� �����ϱ� ���ؼ� �ݺ����� ���� �������� �ۼ�
		for(int i=list2.size()-1;i>=0;i--) {
			if(list1.contains(list2.get(i))) list2.remove(i);
		}
		
		print(list1, list2);
		
		/*	(1.1) LinkedList
		 * 	- List�� ������ �����ϱ����ؼ� ������ �ڷᱸ��
		 * 		1. ũ�⸦ ������ �� ����.
		 * 		2. ��������� �������� �߰�, ������ �ð��� ���� ���. (����, �̵�)
		 * 
		 * 	- ������ list�� �ٸ���, �ҿ��������� �����ϴ� �����͸� ���� ������ ����
		 * 	- ��ũ�� ����Ʈ�� �� ��Ҵ� �ڽŰ� ����� ���� ��ҿ� ���� ���� (�ּ�)�� �����ͷ� �����Ǿ��ִ�.
		 * 	- �׷��Ƿ� �� ���� �� �����ϰ����ϴ� ����� ���� ��Ұ� �����ϰ����ϴ� ���� ����� �ּ� ���� �����ϸ� �ȴ�.
		 * 	- ��, ��ũ�� ����Ʈ�� �̵������� �ܹ�����̹Ƿ� ���� ��ҿ����� ������ ��ƴ�.
		 * 
		 * 	- �̸� �����ϰ���, LinkedList Ŭ������ doubleLinkedList�� �����Ǿ� ���� ����� �ּұ��� ������ ���·� �����Ǿ��ִ�.
		 * 
		 * 	[���]
		 * 		1. ���������� �߰�/�����ϴ� ���, ArrayList�� �� ������.
		 * 		2. �߰� �����͸� �߰�/�����ϴ� ��� LinkedList�� �� ������.
		 * 		3. LinkedList�� ����� �������� ���� ���� ���� �����͸� �о���µ� �ð��� ���� ���. (�ҿ����̹Ƿ�)
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
