package ex2_array_list;

import java.util.ArrayList;

public class UserTest {
	public static void main(String[] args) {
		//
		ArrayList<User> arr = new ArrayList<User>();
		
		// User ��ü ����
		User u = new User();
		
		// - list ���� ��, heap ������ User�� arrayList ������ �����ȴ�.
		// - arrayList���� �ּ� ����, User���� ����� ������ ���� �����Ѵ�.
		u.setAge(20);
		u.setName("ȫ�浿");
		
		// User ��ü �߰�
		User u2 = new User();
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
