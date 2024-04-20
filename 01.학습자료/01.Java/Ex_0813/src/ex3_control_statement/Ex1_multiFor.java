package ex3_control_statement;

public class Ex1_multiFor {
	public static void main(String[] args) {
		
		/* 
		 다중 for문 : for문안에 for문이 포함되어있는 경우
		 1 2 3 4 5
		 1 2 3 4 5
		 1 2 3 4 5
		 1 2 3 4 5
		 다중 for문은 행과 열의 데이터 처리가 가능하다.
		 
		  상위 for문에서 사용한 변수는 하위 for문에서 사용할 수 있다. 
		  즉, 상위 for문에서 선언한 변수는 하위 for문에서는 전역변수처럼 쓰인다.
		 
		 이중 for문에서 하위 for문을 다시 만나게되면 다시 초기화를 하게 된다.
		 */

		for(int i=1;i<=4;i++) { 			// y축
			
			for(int j=1;j<=5;j++) { 		// x축
				System.out.print(j + " ");
			} // inner : 이중포문안에 있는 for문
		
			// syso에서 아무것도 치지 않으면 라인만 내린다.
			System.out.println();
		} // outer : 이중 for문 밖에 있는 for문
	
		
		System.out.println("------------------");
		
		/* 숙제 
		A B C D
		E F G H
		I J K L
		*/
		
		// tip) for문에서 항상 i와 j로 for문을 완성할 것이라는 고정관념을 버려야한다.
		int a = 65;
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=4;j++) {
				System.out.print((char)a+" ");
				a++;
			}
			System.out.println();
		}
		
		
		/*선생님
		 char ch = 'A';
		 for(int i=1;i<=3;i++){
		 	for(int j=1;j<=4;j++){
		 		
		 		System.out.print(ch++ + " ");

		 	}
		 	System.out.println();
		 }
		 */
		
		
	}
}
