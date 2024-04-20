package ex2_continue;

public class Ex1_continue {
	
	public static void main(String[] args) {
		
		/*
		 continue문 : 반복문 내에서 특정문장이나 여러 문장을 무시하고 건너뛰고자할 때 사용하는 키워드
		 (필요없다고 생각하는 문장을 뛰어넘는다, break와 마찬가지로 가장 가까운 for문에 적용된다.)
		 */

	for(int i=1;i<=2;i++) {
		
		for(int j=1;j<=5;) {
			
			// continue는 참값인 경우, 아래에 있는 문장을 뛰어넘는다. (continue를 만난 순간, 가장 가까운 반복문의 증감식으로 간다.)
			// continue 바로 밑에 식을 넣는 것 역시 오류이다. 
			// 만약 증감식이 없으면 continue를 만난 뒤, 조건식으로 간다.
			if(j%2==0) {
				continue;
			}
			
			System.out.print(j+" ");
			j++;
		}
		System.out.println();
	}
	
	
	
	
	
	
	}
}
