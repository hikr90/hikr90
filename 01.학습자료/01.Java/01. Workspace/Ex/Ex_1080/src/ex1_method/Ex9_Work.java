package ex1_method;

import java.util.Scanner;

public class Ex9_Work {

	public static void main(String[] args) {
		
		// ����
		// - �Ʒ� �迭�� ���ؼ� ���� ��ǰ�� �˻��ϴ� ������ ������ּ���.
		// - �Է� : �۰�ȣ
		// - ���
		// - [�۰�ȣ]
		// - ����, ����, ����
		
		// �������� �ʴ� ������ �˻� ��
		// ��� : �ش� ��찡 �������� �ʽ��ϴ�.
		String[][] actor = {{"[�۰�ȣ]","����","����","����"},
								{"[�̺���]","����","�����ڵ�","����"},
								{"[������]","����Ȳ��","�λ���","���˵���"} };
		//
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		String actName = sc.next();
		int cnt = 0;
		//
		for(int i=0;i<actor.length;i++) {
			if(actor[i][0].equals("["+actName+"]")) {
				//
				for(int j=0;j<actor[i].length;j++) {
					System.out.println(actor[i][j]);
				}
			} else {
				cnt++;
				if(cnt==3) {					
					System.out.println("�ش� ���� �������� �ʽ��ϴ�.");
				}
			}
		}
	}
}
