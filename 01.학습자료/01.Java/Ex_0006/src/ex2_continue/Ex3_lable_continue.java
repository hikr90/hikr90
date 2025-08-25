package ex2_continue;

public class Ex3_lable_continue {

	public static void main(String[] args) {
		
		// continue 라벨을 사용하는 경우  라벨 명칭을 가진 반복문의 증감식으로 이동한다.
		outer : for(int i=1;i<=3;i++) {
			//
			for(int j=1;j<=5;j++) {
				//
				if(j%2==0) {
					continue outer;
				}
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
