package ex4_work;

import java.util.Scanner;

public class Ex1_Work {
	public static void main(String[] args) {
		
		// ���� ���� �˷��ִ� �޼��� ȣ��
		Ex2_Work game = new Ex2_Work();
		Scanner sc = new Scanner(System.in);
		
		// Ű���忡�� �����̶�� �����Ǵ� ���� main���� �޾Ƽ� 
		// gameŬ�������� 10�� �������� �ƴ��� üũ
		// �����̸� main���� �˷��ְ� ���� �ݺ��ϴ� while���� �������� �Ѵ�.
		
		boolean bool = true;
		
		while(bool) {
			
			System.out.print("������??");
			int select = sc.nextInt();
			
			if(game.number(select)==bool) {
				break;
			}
			
		}
		
		
		
		
		
	}
}
