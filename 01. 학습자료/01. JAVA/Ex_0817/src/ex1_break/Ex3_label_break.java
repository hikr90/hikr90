package ex1_break;

public class Ex3_label_break {

	public static void main(String[] args) {

		/*
		 label(식별자) : 특정 반복문에 이름표를 붙여 한번에 두개 이상의 반복문을 제어할 수 있도록하는 키워드 


		 */

		out : for(int i=1;i<=3;i++) {

			for(int j=1;j<=5;j++) {

				if(j%2==0) {
					// out이라는 이름의 반복문을 빠져나가라
					break out;
				}
				System.out.print(j+" ");
			}
			System.out.println();
		}







	}
}
