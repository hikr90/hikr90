package ex2_while;

import java.util.Random;

public class Ex2_do_while {
	
	public static void main(String[] args) {
		
		/* do-while : 선처리 ,후 비교
		제어문중 유일하게 ;으로 끝난다.
		
		do{
		조건식이 참일 때 실행되는 영역
		}while(조건식);
		
		
		while과 do-while의  차이
		while은 조건값이 거짓인 경우, 실행문을 실행하지않으나
		do while은 일단 한번 처리한 뒤, 참거짓을 판별하므로 거짓이더라도 한번은 실행된다. 
		*/

		int i = 11;
		
		do {
			System.out.println(i);
			
		}while(i<=10);
	
	System.out.println("------------------");
	
	/* 문제 java, jsp, android의 시험을 봤다. 
	 각과목별 점수는 랜덤으로 0~130점을 대입한다.
	 각 과목의 검사를 do-while을 진행하는데 0~100사이의 점수가 아닌 경우에는 반드시 0 ~ 100 사이의 값이 나올 때까지 자동으로 재실행 시킬 것
	 이렇게 세 과목의 점수가 0에서 100사이가 되면 do while을 빠져나와 과목별 점수를 화면에 출력
	 
	java : 96
	jsp : 95
	android : 99 
	 */
	
	int java = 0;
	int jsp = 0;
	int and = 0;
	
	do {

		java = new Random().nextInt(130-0+1)+0;
		jsp = new Random().nextInt(130-0+1)+0;
		and = new Random().nextInt(130-0+1)+0;
				
		System.out.println("java : "+java);
		System.out.println("jsp : "+jsp);
		System.out.println("and : "+and);
	
		
	}while(java>100||jsp>100||and>100);
	
	
	
	}
}
