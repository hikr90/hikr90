package ex2_array_list;

import java.util.ArrayList;

// ���� : �������� Ÿ���� �����͸� ��ü�μ� �Բ� ������ �� �ִ�.

public class UserTest {
	public static void main(String[] args) {
		
		ArrayList<User> arr = new ArrayList<User>();
		
		// user ��ü ����
		User u = new User();
		
		// �� ������ �ΰ��� ������ ��̸���Ʈ ������ ����
		// ���� ��ü�� �̸��� ���̸� �Է��� ��, ��� ����Ʈ��
		// �ּҸ� �ѱ�� ����
		u.setAge(20);
		u.setName("ȫ�浿");
		
		// ���� �߰�
		User u2 = new User();
		u2.setAge(30);
		u2.setName("��浿");
		
		
		
		// user ��ü�� �Ķ���ͷ� �� �� �ִ�.
		arr.add(u);
		arr.add(u2);
		
		// arr�� ��� user��ü�� ������ ���
		for(int i=0;i<arr.size();i++) {
			
			// ��̸���Ʈ �������� �ּҰ��� ����ֱ� ������ �ּҰ��� ���´�.
			// System.out.println(arr.get(i));
			System.out.println(arr.get(i).getName());
			System.out.println(arr.get(i).getAge());
			System.out.println("-----------------------");
		}
		
		
		
		
		
		
		
		
	}
}
