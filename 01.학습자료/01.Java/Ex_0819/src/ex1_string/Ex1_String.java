package ex1_string;

import java.util.StringJoiner;

public class Ex1_String {

	public static void main(String[] args) {
		
		/*	String
		 * 	- 여러개의 문자로 구성된 문자열
		 * 	- 암시적, 명시적 방법으로 생성된다.
		 * 	- 한번 생성된 문자열의 내용은 변하지 않는 특징을 가진다.
		 * 
		 *		(1) 암시적 객체 생성
		 *			- 문자열 리터럴을 지정한다고 부르기도 한다.
		 *			- 문자열 리터럴은 클래스가 메모리에 로드될 때 자동으로 미리 생성되어 클래스 파일에 저장된다. (JVM의 상수저장소에 저장)
		 *			- 새로운 인스턴스 생성없이, 같은 내용의 문자열 리터럴은 한번만 생성된다. (기존에 생성된 값과 같은 데이터인 객체 간 주소값을 공유)
		 *
		 *		(2) 명시적 객체 생성
		 *			- new 키워드로 생성하는 방식
		 *			- 사용할 때마다 인스턴스가 새롭게 생성되는 방식으로 equals 메소드로 주소 값을 비교할 수 있다.
		 */
		
		// 암시적 객체 생성
		String s1 = "abc";			// 문자열 리터럴 "abc"의 주소가 str1에 저장
		String s2 = "abc";			// 문자열 리터럴 "abc"의 주소가 str2에 저장
		// 
		if(s1==s2) {
			System.out.println("암시적으로 생성된 같은 리터럴은 서로 주소 값을 공유");
		}
		
		// 명시적 객체 생성
		String s3 = new String("abc");
		
		// 명시적으로 생성한 객체는 암시적으로 생성한 객체와 서로 다른 주소 값을 가진다.
		if(s1!=s3) {
			System.out.println("명시적으로 생성한 객체는 암시적으로 생성한 객체와 다른 주소 값을 보유");
		}
		
		System.out.println("---------------");
		
		/* equals 메소드 
		 *		- 참조변수 값을 비교하여 결과 값을 boolean 형태로 반환
		 *		- 등가비교연산자 (==) 로 비교 시, 객체의 주소 값을 서로 비교한다.
		 */
		
		// s1, s2 (암시적)
		// s3 (명시적)
		if(s1.equals(s3)) {
			System.out.println("참조변수 s1과 s3의 값은 동일하다.");
		}
		if(s1 == s3) {
			System.out.println("참조변수 s1과 s3의 주소 값은 서로 다르다.");
		}
		
		System.out.println("---------------");

		/*	String 의 불변적 특징
		 *		- 한번 생성된 문자열의 내용은 변하지 않는 특성
		 *
		 * 		(1) greet 문자열은 heap 영역에 메모리 (안녕) 할당을 받음
		 * 		(2) greet의 문자열을 변경할 경우, heap 영역에서는 기존의 영역 (안녕)의 연결을 끊어버린 뒤, 새로운 영역 (안녕하세요) 을 할당받음
		 * 		(3) 연결이 끊어진 기존의 영역 (안녕)은 추후 가비지 컬렉터에 의해서 자동으로 삭제된다.
		 * 
		 * 	- String 클래스는 문자열을 저장하기위해서 문자형 배열 참조변수 (char [ ]) value 값을 인스턴스 변수로 정의하고 있다.
		 * 	- 명시적 생성 시 문자형 배열 (char [ ]) 을 파라미터로 받고 있어, 문자열을 수정할 때마다 수정없이, 아예 새롭게 인스턴스가 생성된다.
		 */
		String greet = "안녕";
		greet += "하세요.";
		System.out.println(greet);

		System.out.println("---------------");

		// StringBuilder 
		// - String의 불변적 특성을 대체하기위한 클래스
		// - 내부적으로 문자열 편집을 위한 버퍼가 있으므로 인스턴스 생성 시, 문자열을 파라미터러 넣어 크기 지정이 가능하다.
		// - 생성자의 파라미터로 버퍼의 길이 값을 받으며, 아무 값도 넣지 않는 경우 버퍼의 크기는 16이 된다.
		StringBuilder sb = new StringBuilder();
		sb.append("abc");			//  문자열 추가
		sb.append("abc");			// append는 자신의 주소 값을 반환하므로 append(문자열).append(문자열) 방식의 작성이 가능하다.
		System.out.println(sb.toString());

		// [참고] StringBuffer와 StringBuilder의 차이
		// - StringBuffer는 멀티쓰레드에 안전하도록 동기화 되어있다.
		// - 동기화가 StringBuffer의 성능을 떨어트리므로 StringBuffer에서 동기화 기능만 빠진 StringBuilder가 많이 사용된다. (아주 큰 차이는 아닌지라 굳이 변경할 필요는 없다.) 
		
		System.out.println("---------------");

		// StringJoiner
		// - String.join과 같은 기능
		// - 문자열 사이에 구분자 값을 넣어서 결합하는 기능
		StringJoiner sj = new StringJoiner("-", "[", "]");
		String [] strArr = {"aaa", "bbb", "ccc"};
		
		for(String s : strArr) {
			sj.add(s);
		}
		//
		System.out.println("strArr : " + sj.toString());

		System.out.println("---------------");
		
		// StringBuffer
		// - String 클래스에서는 equals 메소드가 오버라이딩되어 문자열의 내용 대신 주소 값을 비교하도록 되어있으나
		// - StringBuffer 클래스는 equals 메소드가 따로 오버라이딩 되어있지 않아 equals을 사용해도 등가비교연산자 (==)로 비교한 것과 같은 결과가 나온다.
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println("sb1 == sb2 : " + (sb1 == sb2));
		System.out.println("sb1.equals(sb2) : " + (sb1.equals(sb2)));
		
		// - 만약 문자열을 비교하자고하는 경우에는 StringBuffer 인스턴스에서 toString을 사용하여 String 인스턴스 값을 얻은 뒤 equals을 사용해서 비교한다.
		String str1 = sb1.toString();
		String str2 = sb2.toString();
		
		System.out.println("str1.equals(str2) : " + str1.equals(str2));

	}
}
