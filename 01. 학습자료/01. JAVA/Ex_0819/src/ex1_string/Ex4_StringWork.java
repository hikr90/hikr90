package ex1_string;

import java.util.Scanner;

public class Ex4_StringWork {

	public static void main(String[] args) {
		
		/* �ֹι�ȣ �Ǵ� ���� �����ϱ� 
		 �ֹι�ȣ�� �Է��ϼ���. (-����) : 
		 991203-1022334
		 
		 ��� : ����� 99�� 12�� 03�Ͽ� �¾ �����Դϴ�.
		 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է��ϼ���. (-����)\n");
		System.out.print(">>");
		String id = sc.next();
		
		String year = id.substring(0,2);
		String month = id.substring(2, 4);
		String day = id.substring(4, 6);
		
		String gender = id.substring(7,8);
	
		int i_gender = Integer.parseInt(gender);
		String s_gender = "����";
		
		if(i_gender==1||i_gender==3) {
			s_gender = "����";
		}
		
		System.out.printf("����� %s�� %s�� %s�Ͽ� �¾ %s�Դϴ�.",year,month,day,s_gender);
	}
}
