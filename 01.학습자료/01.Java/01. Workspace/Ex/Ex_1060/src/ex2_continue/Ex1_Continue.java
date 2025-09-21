package ex2_continue;

public class Ex1_Continue {
	
	public static void main(String[] args) {
		
		/*	Continue
		 * 		- for, while 등의 반복문에서 특정 문장이나 여러 문장을 무시하고 건너뛰고자하는 경우 사용하는 키워드
		 * 		- 필요없다고 생각하는 문장을 뛰어넘어 가장 가까이 있는 증감식으로 이동한다. (증감식이 없는 경우 조건식으로 이동한다.)
		 * 		- break와 마찬가지로 가장 가까이 있는 for문에 적용되며 continue 문장 아래 코드가 있는 경우 오류가 발생한다.
		 * 
		 *		- continue 라벨 형식으로 작성하는 경우 라벨 명칭을 가진 반복문의 증감식으로 이동한다.
		 */
		for(int i=1;i<=2;i++) {
			for(int j=1;j<=5;) {
				// 
				if(j%2==0) {
					// 가장 가까이 있는 반복문의 증감식으로 이동
					continue;
				}
				//
				System.out.print(j+" ");
				j++;
			}
			System.out.println();
		}
	}
}
