package ex1_break;

public class Ex3_Label_Break {

	public static void main(String[] args) {

		/* Label 
		 *		- 식별자로 특정 반복문에 이름을 지정하여 한번에 두개 이상의 반복문을 제어할 수 있게 돕는 키워드
		 *		- 명칭은 임의로 작성 가능하다.
		 *		- break등의 제어자가 하위가 아닌 특정 상위에서 동작할 수 있게하는 등의 작업이 가능하다. 
		 */
		out : for(int i=1;i<=3;i++) {

			for(int j=1;j<=5;j++) {

				if(j%2==0) {
					// 라벨 out 의 반복문을 종료하고 나가시오.
					break out;
				}
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
