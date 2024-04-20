package ex2_continue;

public class Ex3_lable_continue {

	public static void main(String[] args) {
		
		/* continue에서 label을 사용하는 경우, label의 증감식으로 간다.
		 증감식이 존재하지않으면 기존과 같이 조건식으로 간다. */
		
		outer : for(int i=1;i<=3;i++) {
			
			for(int j=1;j<=5;j++) {
				
				if(j%2==0) {
					continue outer;
				}
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
