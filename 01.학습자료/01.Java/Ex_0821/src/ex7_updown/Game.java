package ex7_updown;

import java.util.Random;

public class Game {
	
	/* 숙제 
	 * 사용자가 맞히게될 정답을 1에서 50사이의 난수중 하나로 지정한다.
	*/

	private int random = new Random().nextInt(3)+1;
	private boolean result = false;
	
	// 사용자가 입력한 값이 random과 일치하면 정답
	// 정답 처리를 위한 메서드를 여기서 생성
	// (정답인지, 오답인지)
	
	public boolean number(int n) {
		
		if(this.random>n){
			System.out.println("up");
		}else if(this.random<n){
			System.out.println("down");
		}else {
			System.out.println("정답입니다.");
			result = true;
		}
		return result;
	}
	






}
