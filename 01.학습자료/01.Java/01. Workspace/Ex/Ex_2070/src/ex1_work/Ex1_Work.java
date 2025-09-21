package ex1_work;

import java.util.ArrayList;

public class Ex1_Work {
	public static void main(String[] args) {
		
		/*		List
		 * 		- ����(�ε���)�� �ִ� �������� ����
		 * 		- �迭�� ����� �����Ǿ��ְ� �ε����� ���ؼ�, Ư�� �ε����� �� �߰��� �����ϴ�.
		 * 		- ��ü ������ �����Ͽ� ���� Ÿ���� �����͸� ������ �� �ִ�.
		 * 		- �������� �ߺ��� ����Ѵ�.
		 * 
		 * 		list�� �ڽ� Ŭ����
		 * 			- arrayList
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);	// add�� ���ؼ� ���� �߰��Ѵ�. (���� �ڿ� �߰��ȴ�.)
		
		System.out.println(list.size());	// size�� list�� ���̸� ��ȯ�Ѵ�.
		
		int res = list.get(2);			// get���� �Ķ���Ϳ� �ش��ϴ� �ε����� ���� Ȯ��
		System.out.println(res);	// 300 �� Ȯ��
		
		System.out.println("----------------");
		
		// Ư�� �ε����� �� �߰�
		list.add(1, 400);				// add �Լ��� �ε����� �߰��ϴ� ���, �߰��� 1�� �ε����� �߰��Ǹ鼭 ���� �ε������� �ϳ��� �ڷ� �и��� �ȴ�. (���� �����ֱ�)
		System.out.println(list);
		
		
		// Ư�� �ε����� ���� ����
		list.set(2, 500);
		list.add(600); 
		System.out.println(list);
		
		// Ư�� �ε����� ����
		list.remove(2);	// remove �Լ��� ���ؼ� 2�� �ε����� ����, �ε����� ���ŵǸ� ���� �ε��� �ּ� ���� ������ �ϳ��� �������.
		
		// �ݺ����� ���ؼ� ���
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
