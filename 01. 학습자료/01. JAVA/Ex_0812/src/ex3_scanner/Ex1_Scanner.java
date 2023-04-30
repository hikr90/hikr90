package ex3_scanner;

// IMPORT할 것이 많은 경우 CTRL+SHIFT+O로 IMPORT가 가능하다.
import java.util.Scanner;


public class Ex1_Scanner {
	public static void main(String[] args) {
		
		/* 
		Scanner : 입력값을 받는 클래스
		:: 키보드에서 값을 입력받아 전달하기 위한 클래스
		:: 입력받는 값을 sc에 저장한다.
		:: scanner 클래스는 java.utll.scanner라는 패키지에 있다, 그래서 가져다쓰기위해서 import라는 문장이 있어야한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		// 사용자 편의를 위한 입력값에대한 설명
		System.out.print("정수를 입력하세요. : ");
		
		// 키보드 값으로부터 정수값을 받아, n이라는 변수에 저장
		int n = sc.nextInt();
		// 저장한 값 
		System.out.print("입력받은 값 : "+n);
	
		// scanner는 문자에서는 String타입만 받는다.
		System.out.print("문장을 입력해주세요. : ");
		// 키보드값으로부터 문자를 받아(상수도 상수값의 문자로 받는다.), s변수에 저장
		String s = sc.next();
		
		System.out.print("입력받은 값 : "+s);
	}
}
