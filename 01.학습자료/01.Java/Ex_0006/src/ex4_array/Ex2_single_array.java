package ex4_array;

public class Ex2_single_array {
	
	public static void main(String[] args) {
		//
		char [] ch = new char[4];
		//
		ch[0] = 'A';
		ch[1] = 'B';
		ch[2] = 'C';
		ch[3] = 'D';
		//
		for(int i=0;i<ch.length;i++) {
			System.out.print(ch[i]);
		}
		System.out.println();
		
		
		// 개선된 반복문
		// - 인덱스 상관없이 배열 내의 모든 인덱스를 보여주는데 용이하다.
		// - 배열의 각 인덱스에대한 수정과 삭제 등의 작업이 불가능하다.
		for(char c : ch) {
			System.out.print(c);
		}
		System.out.println();
		
		System.out.println("------------------");

		/* String 배열 
		 * 	- 참조형 변수의 기본 값은 null 이며, null은 어떤한 객체도 가르키고 있지 않음을 뜻한다.
		 * 	- 참조형 변수 중, String 클래스만 특별히 new 키워드 없이 객체 생성이 가능하다.
		 * 	- 참조형 배열의 경우 배열에 저장되는 값은 객체의 주소이다.
		 */

		// 선언과 생성, 초기화 동시 진행
		String[] strs = {"hong","kim","lee","park"};
	
		for(int i=0;i<strs.length;i++) {
			System.out.println(strs[i]);
		}
		
		System.out.println("------------------");
		
		// 개선된 반복문
		for(String s : strs) {
			System.out.println(s);
		}
	}
}
