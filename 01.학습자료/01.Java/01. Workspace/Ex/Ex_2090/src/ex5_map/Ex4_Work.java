package ex5_map;

import java.util.HashMap;
import java.util.Scanner;

public class Ex4_Work {
	public static void main(String[] args) {
	
		// ����
		// - ���
		// - id : aaaa
		// - pw : 1111
		// - ���̵� �������� �ʽ��ϴ�.
		
		// - id : lee
		// - pw : 4444
		// - ��й�ȣ�� �������� �ʽ��ϴ�.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("kim", 1111);
		map.put("lee", 2222);
		map.put("park", 3333);
		//
		Scanner sc = new Scanner(System.in);
		System.out.println("id : ");
		String id = sc.next();
		//
		System.out.println("pw : ");
		int pw = sc.nextInt();
		//
		if(!map.containsKey(id)) {
			System.out.println("id�� �������� �ʽ��ϴ�.");
		} else {
			if(map.get(id)!=pw) {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}else {
				System.out.println("�α��ο� �����Ͽ����ϴ�.");
			}
		}
	} // main
}
