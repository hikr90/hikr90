package ex1_string;

import java.util.Scanner;

public class Ex2_String_Method {

	public static void main(String[] args) {
		
		/* 메소드
		 *		- 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것.
		 *		- 메소드는 선언부와 구현부로 구성되어 있다.
		 *		- 클래스와 다르게, 메소드는 반드시 소문자로 시작한다.
		 *		- '객체.메소드' 의 방식으로 동작한다.
		 *		- 메소드의 리턴 값은 반환타입과 같거나 적어도 자동 형변환이 가능한 것이여야 한다. 
		 *
		 *		사용 이유
		 *			(1) 높은 재사용성
		 *			(2) 중복된 코드 제거
		 *			(3) 프로그램 구조화	(하나의 클래스에서 여러 메소드로 구분하여 정리)
		 *
		 *		리턴 키워드
		 *			- 현재 실행 중인 메소드 작업을 종료하고 요청한 메소드로 되돌아간다.
		 *			- 반환 값과 상관없이 모든 메소드에는 적어도 하나의 리턴이 있어야 한다.
		 *			- 단 void 타입인 경우, 컴파일러가 메소드의 마지막에 암시적으로 리턴을 사용하므로 문제가 없다.
		 *
		 *		매개변수
		 *			- 자바에서 메소드 수행 시, 매개변수로 지덩한 값을 메소드의 매개변수에 복사해서 넘겨준다.
		 *			- 매개변수의 종류는 기본형, 참조형 (클래스, 배열)이 존재한다.
		 *			- 기본형은 값이 복사되며, 참조형의 경우는 인스턴스의 주소가 복사된다.
		 *				(1) 기본형 : 값의 읽기만 가능
		 *				(2) 참조형 :  값의 읽기, 수정 가능
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
		// - 인덱스는 0부터 시작하며 end 위치의 값은 결과에 포함되지 않는다.
		String res2 = str.substring(2,9);
		System.out.println("추출해낸 문장 : "+res2);
		
		System.out.println("----------------");
		
		// equals
		// - 문자열의 값을 비교하는 메소드
		// - 해당 메소드는 대소문자 값을 비교한다. (apple 과 Apple은 같지 않다.)
		String name1 = "apple";
		String name2 = "ApplE";
		
		if(name1.equals(name2)) {
			System.out.println("두 문장의 값이 같습니다.");
		}else {
			System.out.println("두 문장의 값이 다릅니다.");
		}
		
		System.out.println("----------------");
		
		// equalsIgnoreCase
		// - 알파벳 한정해서 대소문자 값을 무시해서 값을 비교하는 메소드
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
		
		// Integer.paresInt
		// - 문자열로 작성한 숫자 형태의 값을 정수 타입으로 반환하는 메소드
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		String number = sc.next();
		
		int number2 = Integer.parseInt(number);
		System.out.println(number2+1);
		
		System.out.println("----------------");
		
		// join
		// 	- 문자열 사이에 구분자 값을 추가하여 결합하는 메소드 (StringJoiner과 동일)
		//	- split 메소드의 반대 역할
		String [] arr = {"dog","cat","bear"};
		String join = String.join("-", arr);
		System.out.println("join : " + join);
		
		System.out.println("----------------");

		// valueOf
		// - 기본 형을 값을 String으로 변환하는 메소드
		// - "" + String 으로 변환하도한다.
		// - 성능적으로는 valueOf가 더 뛰어나나 문자열을 사용하는 방식이 편해서 더 많이 사용된다.
		int i = 0;
		String s1 = "" + i;
		String s2 = String.valueOf(i);
		System.out.println("s1 : " + s1 + " / s2 : "+s2);
		
		System.out.println("----------------");
		
		/* 래퍼 (Wrapper) 클래스 
		 *		- 기본 자료형을 포장하는 클래스
		 *		- 기본 자료형 값을 객체로 저장해야하는 경우 사용한다.
		 *		- 래퍼 클래스의 생성자는 매개변수로 문자열이나 각 자료형의 값들을 인자로 받는다.
		 *		- equals 메소드가 오버라이딩 되어있어 주소 값이 아닌 객체가 가지고 있는 값을 비교한다.
		 *
		 *			(1) int - Integer
		 *			(2) char - Character
		 *			(3) boolean - Boolean
		 *			(4) short - Short
		 *			(5) long - Long
		 *			(6) float - Float
		 *			(7) double - Double
		 *
		 *		[참고] 문자열 > 기본형 (parseInt 등...) , 문자열 > 래퍼 클래스 (valueOf)
		 *				- 오토박싱 : 기본형의 값을 래퍼 클래스의 객체로 자동 변환
		 *				- 언박싱 : 래퍼 클래스의 객체 값을 기본형의 값으로 자동 변환
		 */
		
		// 예) 문자열 타입을 실수형인 Wrapper 클래스의 Float으로 변환
		String f = "3.14";
		float ff = Float.parseFloat(f);
		System.out.println(ff+1);
	}
}
