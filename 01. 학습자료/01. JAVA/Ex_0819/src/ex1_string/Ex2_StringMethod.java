package ex1_string;

import java.util.Scanner;

public class Ex2_StringMethod {

	public static void main(String[] args) {
		
		/* Method
		 	어떠한 작업을 수행하기위한 명령문들의 집합
		 	반복적으로 수행되는 코드를 줄이기위해서 개발되었다.
		 	
		 	객체에서 내부 접근자(.)을 통해서 실행할 수 있는 기능을 뜻한다.
		 	메서드는 제어문처럼 반드시 뒤에 ()을 가진다. 
		 */
		
		// length : String 클래스의 길이값을 정수로 반환해주는 메서드 
		String str = "Hong Gil Dong";
		int len = str.length();
		System.out.println("str의 길이 : "+len);
		
		// 클래스의 ()안에서 CTRL+SHIFT+SPACE를 통하여 반환 방식을 확인하는 방법
		// length() : int : String
		// String클래스의 length()라는 메서드를 사용하여 int타입으로 결과를 받는다. 
		
		System.out.println("----------------");
		
		// 스트링 클래스의 메서드 
		// indexOf : indexOf는 맨 처음으로 만나는 문자의 위치를 정수값으로 반환하는 메서드
		// indexOf(int ch) : int - String : ()안에 int값과 char값을 받아 String클래스에 있는 indexOf를 사용하여 정수값을 반환받는다.
		// (중요!) length를 제외한 모든 메서드는 0부터 시작한다. 
		int index = str.indexOf('o'); 
		System.out.println("맨 처음 문자 o의 위치 : "+index);
		
		System.out.println("----------------");
		
		// lastIndexOf : 해당 문자열에서 제일 뒤쪽에 있는 문자가 몇번째에 위치했는지 숫자로 반환하는 메서드 
		index = str.lastIndexOf('o');
		System.out.println("마지막 문자 o의 위치 : "+index);
		
		System.out.println("----------------");
		
		// indexOf에 문자열을 넣을 경우, 해당 단어의 시작 위치를 뜻한다.
		index = str.indexOf("Gil");
		System.out.println("Gil의 시작 위치 : "+index);
		
		System.out.println("----------------");
		
		// charAt : 특정 긴 문장에서 ()안에 있는 숫자의 위치에 있는 문자만 추출하는 메서드 
		char res = str.charAt(6);
		System.out.println("charAt()안에 들어간 위치의 문자 : "+res);
		
		System.out.println("----------------");
		
		// substring : 문장을 추출하는 메서드
		// (시작값, 마지막값에서 -1)의 범위에 해당하는 내용을 String타입으로 반환한다.  
		String res2 = str.substring(2,9);
		System.out.println("추출해낸 문장 : "+res2);
		
		System.out.println("----------------");
		
		// equals : 값을 비교하는 메서드
		// equals는 대소문자를 구분한다. (apple과 ApplE은 같지 않은 것으로 판단	
		String name1 = "apple";
		String name2 = "ApplE";
		
		if(name1.equals(name2)) {
			System.out.println("두 문장의 값이 같습니다.");
		}else {
			System.out.println("두 문장의 값이 다릅니다.");
		}
		
		System.out.println("----------------");
		
		// equalsIgnoreCase : 알파벳 한정해서 대소문자를 무시하는 메서드
		if(name1.equalsIgnoreCase(name2)) {
			System.out.println(name1+"과 "+name2+"는 같은 단어입니다.");
		}
		
		System.out.println("----------------");
		
		// trim : 문장 앞 뒤의 의미없는 공백을 제거하는 메소드 (단, 중간 공백은 제외한다.)
		// 문자열의 비교는 길이(length)로 한다.  
		String id = " system  ";
		String id2 = id.trim();
		if(id2.equals("system")) {
			System.out.println("관리자로 로그인");
		}
	
		System.out.println("----------------");
		// 스트링 클래스는 아니지만 많이 사용하는 매서드
		// Integer.parseInt : 문자열로 작성한 숫자형태의 데이터를 int타입으로 변환해주는 메서드
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		String number = sc.next();
		
		int number2 = Integer.parseInt(number);
		
		System.out.println(number2+1);
		
		System.out.println("----------------");
		// 기본자료형은 stack에 저장되므로 .을 사용하여 메서드 사용이 불가능하다. 
		// Wrapper클래스 : 기본자료형을 포장하는 클래스
		// int -> Integer
		// char -> Character
		// boolean -> Boolean
		// short -> Short
		// long -> Long
		// float -> Float
		// double -> Double
		
		// 예) 문자열 타입의 f를 실수형인 ff에 Wrapper으로 변환하여 대입
		String f = "3.14";
		float ff = Float.parseFloat(f);
		System.out.println(ff+1);
		
		
		
		
	}
}
