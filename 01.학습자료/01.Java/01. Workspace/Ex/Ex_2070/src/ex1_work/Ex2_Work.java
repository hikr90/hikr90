package ex1_work;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2_Work {
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
