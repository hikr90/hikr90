package ex1_array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2_ArrayList {
	public static void main(String[] args) {
		
		// ����
		// - id : aaa
		// - [aaa]
		
		// - id : bbb
		// - [aaa, bbb]
		
		// - id : aaa �� �ߺ��� �� �߰� ��
		// - �ߺ��� ���̵��Դϴ�. ��� �����ּ���.
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		//
		out : while(true) {
			//
			System.out.println("id : ");
			String id = sc.next();
			
			// �ߺ�üũ
			for(int i=0;i<list.size();i++) {
				if(list.get(i).equalsIgnoreCase(id)) {
					System.out.println("�ߺ�");
					continue out;
				}
			}
			//
			list.add(id);
			System.out.println(list);
		}
	}
}
