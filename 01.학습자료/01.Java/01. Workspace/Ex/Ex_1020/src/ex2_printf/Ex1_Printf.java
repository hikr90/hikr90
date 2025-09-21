package ex2_printf;

public class Ex1_Printf {

	public static void main(String[] args) {
		
		// println : 출력 후, 한줄을 띄우는 출력방식
		int age = 21;
		System.out.println("제 나이는 "+age+"세 입니다.");
		
		// printf(포맷) : 변수의 타입에따라서 출력이 가능한 방식
		// \n : 한줄 띄우기
		// 포맷의 형태
		// %d : 정수
		// %c : 문자
		// %f : 실수
		// %s : 문자열
		System.out.printf("제 나이는 %d세 입니다.\n",age);
		
		int year = 2000;
		int month = 10;
		int day = 9;
		
		// 2000-10-9
		System.out.printf("%d-%d-%d\n",year,month,day);
		
		// 저는 21세 A형입니다.
		char bt = 'A';
		float co = 36.5f;
		System.out.printf("저는 %d세 %c형 입니다. 체온은 %.1f도 입니다.\n",age,bt,co);
		
		// %d의 경우 02 : 앞에 0을 붙여서 두자리 / 03 : 세자리
		// 02부분에 두자리가 들어갈 경우, 두자리로 나온다.
		System.out.printf("%d-%02d-%03d\n",9,10,9);
		// %f의 경우, 소수점자리에따라서 조정이 가능하다.
		System.out.printf("%f, %.2f, %.3f",co,co,co);
		
		// %o : 정수 (8진수)
		// %x :  정수 (16진수)
	}

}
