package ex7_updown;

import java.util.Scanner;

public class GameMain {
	public static void main(String[] args) {
		
		// ���� ���� �˷��ִ� �޼��� ȣ��
		Game game = new Game();
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
