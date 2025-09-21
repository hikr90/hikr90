package ex2_Syso;

public class Ex1_Sysout {
	/* 메인 메소드
	 * 	- 컴파일 시 가장 먼저 호출되는 영역으로 우선적으로 컴파일이 진행된다.
	 * 	- 자바 애플리케이션 내에는 반드시 1개의 메인 메소드를 포함한 클래스가 있어야한다.
	 */	
		public static void main( String [] args) {

			/*	System.out.println
			 * 		- 문자, 숫자, 문자열 등의 데이터를 한줄씩 개행하여 출력하는 기능
			 * 		- syso 입력 후 Ctrl + Space를 입력하여 자동 완성으로 작성 가능하다.
			 * 
			 * 		- 출력문은 형에 따라서 자동으로 연산된다.
			 * 		- 숫자를 사용하는 경우 + 등의 문자로 연산이 가능하며 " " 에 담는 경우 문자로 처리한다.
			 */
			
			// 형에 따라서 자동으로 연산
			System.out.println( 100 + 100 );
			
			// 문자 혹은 문장으로 출력하는 경우 쌍 따음표로 묶어준다.
			System.out.println( "홍길동 hello" );

			// 숫자를 쌍따음표 내에 넣는 경우 문자로 취급된다.
			// 숫자의 + 는 연산을, 문자의 + 는 단어를 서로 연결한다. ( "" + 숫자는 문자가 된다.)
			System.out.println( "홍" + 100 + 50 );
			
			// 숫자를 우선 처리하고자한다면 괄호를 사용하여 구분한다.
			System.out.println( "10 + 10 = " + (10 + 10) );
			System.out.println(10 + 1 + "안녕" + 1 + 1);
			
			/* System.out.print
			 * 	- 문자, 숫자, 문자열 등의 데이터를 개행 없이 출력하는 기능
			 * 	
			 *  (1) System.out.printf
			 *  	- 변수의 타입에 따라서 변환하여 출력하는 기능
			 *  	- 개행 기능이 없어 따로 개행문자를 사용한다.
  			 *  	- 출력할 문장, %자료형, 값을 파라미터로 받는다.
  			 *  
			 *  		(1.1) 개행문자의 종류		
			 *  			- \n : line feed (New Line 새로운 라인)
			 *  			- \t : tab
			 *  			- \b : backspace
			 *  			- \f : form feed (프린트 출력 시, 현재 페이지를 마침)
			 *  			- \r : carriage return (맨 앞으로 이동하는 뜻)
			 *  			- \\ : 역슬래쉬 (참고, 한글 윈도우에서는 역슬래쉬가 / 대신 \으로 표현되며 리눅스에서는 /으로 표현된다.
			 *  			- \' : 작은 따옴표
			 *  			- \" : 큰 따옴표
			 *  			- \ + u + 숫자 : 유니코드 (예, char c = '\u0041')
			 *  
			 *  	포맷 자료형
			 *  		- %s 	: 	String
			 *  		- %c 	: 	char
			 *  		- %d 	: 	int
			 *  		- %f 	: 	float
			 *  		- %o 	: 	정수 (8진수)
			 *  		- %x 	:	정수 (16진수) 
			 * */
			// String & char
			String name = "홍길동"; 
			char bt = 'B';
			System.out.printf("안녕하세요. 제 이름은 %s이고 혈액형은 %c형입니다.\n",name,bt);
			
			// int
			int year = 2000;
			int month = 9;
			int day = 21;
			System.out.printf("오늘은 %d년 %d월 %d일입니다.\n",year,month,day);		
			System.out.printf("오늘의 당첨번호는 %d번, %02d번, %03d번입니다.\n",3,5,9);	// 포맷의 형태를 월단위로 수정하고싶은 경우 %출력할 0의 수 d 로 표현할 수 있다.
			
			// float
			float co = 36.5f;
			System.out.printf("%f, %.2f, %.3f\n",co,co,co);			
			
			// 포맷의 앞에 숫자 값을 추가하는 경우 출력될 값이 차지할 공간을 숫자로 지정할 수 있다.
			// 실수의 경우 . 도 한 자리를 차지한다.
			System.out.printf("[%5d]\n", 10);			// 우측 정렬
			System.out.printf("[%-5d]\n", 10);			// 좌측 정렬
			System.out.printf("[%05d]\n", 10);			// 공백만큼 0으로 채움
		}
}
