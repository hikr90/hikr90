package ex2_work;

import java.util.ArrayList;

public class Ex2_Work {
	public static void main(String[] args) {
		//
		ArrayList<Ex1_Work> arr = new ArrayList<Ex1_Work>();
		
		// User ��ü ����
		Ex1_Work u = new Ex1_Work();
		
		// - list ���� ��, heap ������ User�� arrayList ������ �����ȴ�.
		// - arrayList���� �ּ� ����, User���� ����� ������ ���� �����Ѵ�.
		u.setAge(20);
		u.setName("ȫ�浿");
		
		// User ��ü �߰�
		Ex1_Work u2 = new Ex1_Work();
		u2.setAge(30);
		u2.setName("��浿");
		
		// - User ��ü�� �Ķ���ͷ� �� �� �ִ�.
		arr.add(u);
		arr.add(u2);
		
		// arrayList�� �ִ� User ��ü�� �ݺ������� Ȯ��
		for(int i=0;i<arr.size();i++) {
			//
			System.out.println(arr.get(i)); // arrayList�� Ȯ�� �� �ּ� ���� ��ȸ�ȴ�.
			//
			System.out.println("-----------------------");
			System.out.println(arr.get(i).getName());
			System.out.println(arr.get(i).getAge());
			System.out.println("-----------------------");
		}
	}
}
