package ex7_updown;

import java.util.Random;

public class Game {
	
	/* ���� 
	 * ����ڰ� �����Ե� ������ 1���� 50������ ������ �ϳ��� �����Ѵ�.
	*/

	private int random = new Random().nextInt(3)+1;
	private boolean result = false;
	
	// ����ڰ� �Է��� ���� random�� ��ġ�ϸ� ����
	// ���� ó���� ���� �޼��带 ���⼭ ����
	// (��������, ��������)
	
	public boolean number(int n) {
		
		if(this.random>n){
			System.out.println("up");
		}else if(this.random<n){
			System.out.println("down");
		}else {
			System.out.println("�����Դϴ�.");
			result = true;
		}
		return result;
	}
	






}
