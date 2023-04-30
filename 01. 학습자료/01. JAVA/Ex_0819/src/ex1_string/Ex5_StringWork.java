package ex1_string;

import java.util.Scanner;

public class Ex5_StringWork {

	public static void main(String[] args) {
		
		/*문제 회문수 구하기
		 회문수 : 앞으로 읽어도 뒤로 읽어도 똑같이 읽히는 숫자
		 
		 입력 : a1b1a
		 a1b1a는(은) 회문수입니다.
		 
		 입력 : aabb
		 aabb는(은) 회문수가 아닙니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 : ");
		String ori = sc.next();
		String rev = "";
		
		// String은 ""으로 해두지 않고 String rev;로 선언만 해두면 +=로 연결되지 않는다. ""이 있어야 연결이 가능하다. (만약 null을 하는 경우, null이 붙으므로 보통 ""으로 한다.)
		// null : 공기조차 없음 
		// "" : 공기라도 채워둔 상태
		for(int j=ori.length()-1;j>=0;j--) {
			rev += ori.charAt(j);
		}
		
		
		if(ori.equals(rev)) {
			System.out.println(ori+"는 회문수입니다.");
		}else {
			System.out.println(ori+"는 회문수가 아닙니다.");
		}
		
		
	}
}
