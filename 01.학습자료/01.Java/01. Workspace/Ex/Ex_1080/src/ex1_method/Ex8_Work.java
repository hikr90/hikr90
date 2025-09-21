package ex1_method;

import java.util.Scanner;

public class Ex8_Work {

	public static void main(String[] args) {
		
		// 문제
		// - 회문수를 구해주세요.
		// - 회문수란 앞으로 읽어도 뒤로 읽어도 똑같이 읽히는 숫자입니다.

		// - 입력 : a1b1a
		// - 결과 : a1b1a는(은) 회문수입니다.
		
		// - 입력 : aabb
		// - 결과 : aabb는(은) 회문수가 아닙니다.
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 : ");
		String ori = sc.next();
		String rev = "";				// 밑에서 += 로 값을 붙여줘야하므로 "" 처리를 해줘야한다. (null : 공기조차 없음 / "" : 공기라도 채워진 상태)
		//
		for(int j=ori.length()-1;j>=0;j--) {
			rev += ori.charAt(j);
		}
		//
		if(ori.equals(rev)) {
			System.out.println(ori+"는 회문수입니다.");
		}else {
			System.out.println(ori+"는 회문수가 아닙니다.");
		}
	}
}
