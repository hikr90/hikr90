package ex1_array_list;

import java.util.ArrayList;

public class Ex1_ArrayList {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		
		System.out.println(list.size());
		
		// 300�� ����濡 �ִ��� Ȯ��
		int res = list.get(2);
		System.out.println(res);
		
		System.out.println("----------------");
		
		// ArrayList���� 400�̶�� ���� 1�� �ε����� �߰��ϴ� ���
		// �߰��� 1�����̶�� ���ο� ���� ����鼭 ������ ����� 1�������� ���� �ּҰ�
		// ���ο� 1���濡 ����ȴ�. �׿� ���ÿ� �ε����� �ϳ��� �ڷ� �и��Եȴ�.
		// �� �����ִ� ������� ���� �߰��Ѵ�.
		list.add(1, 400);	
		System.out.println(list);
		
		
		// �������� �ʰ� ���� �ٲٴ� ���
		list.set(2, 500);
		list.add(600); // �ε��� ��ȣ ���� ���� add�ϸ� �� �ڿ� �߰��ȴ�.
		System.out.println(list);

		// ArrayList �� 2�� index�� ���� ����
		// 1����� 3������ �ּҸ� ���� ����, 2������ �����ǰ� 2���濡 ����� �ּҶ����� �����Ǹ鼭 3������ �ε����� 2�������� ����ȴ�.
		// ���� �����ų� �߰��Ǵ��� �ε����� ������ �������� �ʴ´�.
		list.remove(2);
		
		// ArrayList�ȿ� ��� ���� for���� ���ؼ� ���
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		
		
		
	}
}
