package ex1_string;

import java.util.Scanner;

public class Ex5_StringWork {

	public static void main(String[] args) {
		
		/*���� ȸ���� ���ϱ�
		 ȸ���� : ������ �о �ڷ� �о �Ȱ��� ������ ����
		 
		 �Է� : a1b1a
		 a1b1a��(��) ȸ�����Դϴ�.
		 
		 �Է� : aabb
		 aabb��(��) ȸ������ �ƴմϴ�.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�Է� : ");
		String ori = sc.next();
		String rev = "";
		
		// String�� ""���� �ص��� �ʰ� String rev;�� ���� �صθ� +=�� ������� �ʴ´�. ""�� �־�� ������ �����ϴ�. (���� null�� �ϴ� ���, null�� �����Ƿ� ���� ""���� �Ѵ�.)
		// null : �������� ���� 
		// "" : ����� ä���� ����
		for(int j=ori.length()-1;j>=0;j--) {
			rev += ori.charAt(j);
		}
		
		
		if(ori.equals(rev)) {
			System.out.println(ori+"�� ȸ�����Դϴ�.");
		}else {
			System.out.println(ori+"�� ȸ������ �ƴմϴ�.");
		}
		
		
	}
}
