package ex4_array;

public class Ex2_single_array {
	
	public static void main(String[] args) {
	
		char [] ch = new char[4];
		
		ch[0] = 'A';
		ch[1] = 'B';
		ch[2] = 'C';
		ch[3] = 'D';
		
		for(int i=0;i<ch.length;i++) {
			System.out.print(ch[i]);
		}
		System.out.println();
		
		
		// ch 배열의 값을 개선된 for문으로 출력
		for(char c : ch) {
			System.out.print(c);
		}
		System.out.println();
		
		System.out.println("------------------");

		
		// 배열의 선언과 생성, 초기화를 한번에 하는 방법
		String[] strs = {"hong","kim","lee","park"};
	
		for(int i=0;i<strs.length;i++) {
			System.out.println(strs[i]);
		}
		
		System.out.println("------------------");
		
		
		// 개선된 for문(향상된 for문)
		for(String s : strs) {
			System.out.println(s);
		}
		
		
		/* 개선된 for문의 장단점
		 개선된 for문
		 장점 : 전체적으로 출력하는데 용이하다.
		 단점 : 배열의 각 index에대한 수정과 삭제가 불가능하다.
		
		 */ 
		
		
	}
}
