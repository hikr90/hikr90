package ex3_scanner;

// 스캐너 사용을 위해서는 해당 클래스가 import 되어있어야한다.
// 직접 작성할 필요없이 문장에서 스캐너 입력 시 자동으로 추가된다.
import java.util.Scanner;


public class Ex1_Scanner {
	public static void main(String[] args) {
		
		/* 스캐너
		 *		- 키보드에서 값을 전달받아 코드 내에서 사용할 수 있게하는 클래스
		 *		- 해당 클래스는 java.util.scanner 라는 패키지에 존재하므로 가져다 사용하기위해서 import가 되어야한다.
		 *		- 개발자의 확인 용도를 위해서 사용된다.

		 *		- nextInt, next 메소드를 통해서 숫자 혹은 문자 값을 받을 수 있다.
		 *		- 위 두가지 메소드를 사용하는 순간, 콘솔 창은 값을 입력받기위한 대기 상태에 들어가며 개발자는 콘솔 내에 직접 값을 작성할 수 있다.
		 */
		
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		
		// 사용자 편의를 위한 입력 값에대한 설명
		System.out.print("정수를 입력하세요. : ");
		
		// 키보드 값으로부터 정수값을 받아, n이라는 변수에 저장
		int n = sc.nextInt();
		
		// 저장한 값 확인
		System.out.print("입력받은 값 : "+n);
		
		// 스캐너는 문자는 String 타입만 받는다.
		System.out.print("문장을 입력해주세요. : ");
		
		// 상수 역시 상수 형태의 문자열 값으로 받는다.
		String s = sc.next();
		System.out.print("입력받은 값 : "+s);
	}
}
