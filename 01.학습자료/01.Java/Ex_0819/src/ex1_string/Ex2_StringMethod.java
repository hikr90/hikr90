package ex1_string;

import java.util.Scanner;

public class Ex2_StringMethod {

	public static void main(String[] args) {
		
		/* 메소드
		 *		- 특정 작업을 수행하기위한 명령문들의 집합
		 *		- 반복적으로 수행되는 코드를 절약하기위해서 개발되었다.
		 *		- 클래스는 대문자로 시작하는 대신, 메소드는 반드시 소문자로 시작한다.
		 *		- 작성 후 ctrl + shift + space를 입력하여 메소드에대한 설명을 볼 수 있다.
		 *		- (예, length() : int : String 이라고 되어있으면 length라는 메소드는 String 에서 사용하여 int 값을 결과로 받는다.)
		 *		
		 *		- 코드 상에서 객체 뒤에 내부접근자 (.) 를 붙여서 실행한다.
		 *		- 객체.메소드() 혹은 객체.메소드(파라미터) 방식으로 동작한다.
		 */
		
		// length
		// - String 클래스의 길이를 정수로 반환하는 메소드
		String str = "Hong Gil Dong";
		int len = str.length();
		System.out.println("str의 길이 : "+len);
		
		System.out.println("----------------");
		
		// indexOf
		// - 문자열 중 맨 처음으로 만나는 문자의 위치를 정수 값으로 반환하는 메소드
		// - 찾고자하는 문자를 파라미터로 받아서 위치 값을 정수로 반환받는다.
		// - 위치의 시작 값은 0부터 시작한다.
		int index = str.indexOf('o'); 
		System.out.println("맨 처음 문자 o의 위치 : "+index);

		// - 파라미터에 문자열이 들어갈 경우, 문자열의 시작 위치를 반환한다.
		index = str.indexOf("Gil");
		System.out.println("Gil의 시작 위치 : "+index);
		
		System.out.println("----------------");
		
		// lastIndexOf
		// - 문자열에서 특정 문자가 위치한 가장 마지막의 값이 몇번째에 위치하고있는지 정수로 반환한다.
		// - 위치의 시작 값은 0부터 시작한다.
		index = str.lastIndexOf('o');
		System.out.println("마지막 문자 o의 위치 : "+index);
		
		System.out.println("----------------");

		// charAt
		// - 문자열에서 파라미터에 해당하는 정수 값의 위치에 있는 문자를 찾는 메소드
		char res = str.charAt(6);
		System.out.println("charAt()안에 들어간 위치의 문자 : "+res);
		
		System.out.println("----------------");
		
		// substring
		// - 파라미터로 정수 값인 시작 값과 종료 값을 받아서 해당 범위에 있는 내용을 String 타입으로 반환한다.
		String res2 = str.substring(2,9);
		System.out.println("추출해낸 문장 : "+res2);
		
		System.out.println("----------------");
		
		// equals
		// - 문자열의 값을 비교하는 메소드
		// - 해당 메소드는 대소문자를 비교한다. (apple 과 Apple은 같지 않다.)
		String name1 = "apple";
		String name2 = "ApplE";
		
		if(name1.equals(name2)) {
			System.out.println("두 문장의 값이 같습니다.");
		}else {
			System.out.println("두 문장의 값이 다릅니다.");
		}
		
		System.out.println("----------------");
		
		// equalsIgnoreCase
		// - 알파벳 한정해서 대소문자를 무시해서 값을 비교하는 메소드
		if(name1.equalsIgnoreCase(name2)) {
			System.out.println(name1+"과 "+name2+"는 같은 단어입니다.");
		}
		
		System.out.println("----------------");
		
		// trim
		// - 문장 앞 뒤의 의미없는 공백을 제거하는 메소드 (단, 중간 공백은 제외한다.)
		String id = " system  ";
		String id2 = id.trim();

		if(id2.equals("system")) {
			System.out.println("관리자로 로그인");
		}
	
		System.out.println("----------------");
		
		// 스트링 문자열이 아닌 메소드
		// Integer.paresInt
		// - 문자열로 작성한 숫자 형태의 데이터를 int 타입으로 반환하는 메소드
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		String number = sc.next();
		
		int number2 = Integer.parseInt(number);
		
		System.out.println(number2+1);
		
		System.out.println("----------------");

		/* Wrapper 클래스 
		 *		- 기본 자료형을 포장하는 클래스
		 *		- 기본 자료형인 변수들은 stack 영역에 저장되므로 내부 접근자 (.)를 사용하여 메소드 사용이 불가능하다.
		 *		- 그래서 Wrapper 클래스를 통해서 기본 자료형을 포장하여 메소드를 사용한다. 
		 *
		 *		int - Integer
		 *		char - Character
		 *		boolean = Boolean
		 *		short - Short
		 *		long - Long
		 *		float - Float
		 *		double - Double
		 */
		
		// 예) 문자열 타입을 실수형인 Wrapper 클래스의 Float으로 변환
		String f = "3.14";
		float ff = Float.parseFloat(f);
		System.out.println(ff+1);
	}
}
