package ex1_break;

public class Ex1_break {

	public static void main(String[] args) {
		
		/* 
		 break문 : 반복문 내에서 강제적으로 가까운(break를 포장하고있는) 반복문을 빠져나갈 때 사용하는 키워드 
		 
		 */

	for(int i=1;i<=2;i++) {
		
		for(int j=1;j<=5;j++) {
		
			// j가 3이 되어 if문이 참값이 되는 순간, break가 속해있는 반복문을 나온 뒤, i for문으로 바로 간다.
			// break문이 동작하는 순간 아래에는 어떠한 코드도 추가될 수 없다..
			if(j%3==0) {
				break;
			}
			
			System.out.print(j+" ");
		}
		System.out.println();
	}
	
	
	
	}
}
