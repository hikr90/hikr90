package ex1_break;

public class Ex1_Break {

	public static void main(String[] args) {
		
		/*	Break
		 *		- 반복문 내에서 강제적으로 가까이에 있는 (break문을 감싸고있는) 반복문을 빠져나갈 때 사용하는 키워드	
		 *		- if, for, while등의 문에서 사용 가능하다.
		 *		- break문장 아래에 코드가 있는 경우 에러가 발생한다. 
		 */
		for(int i=1;i<=2;i++) {
			for(int j=1;j<=5;j++) {
				// if문이 참이 되는 순간, break가 있는 반복문을 나와 상위 for문으로 돌아간다.
				if(j%3==0) {
					break;
				}
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
