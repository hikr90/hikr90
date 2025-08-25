package ex2_multi_array;

public class Ex1_multi_array {
	
	public static void main(String[] args) {
		
		/* 다차원 배열
		 * 	- 1차원 배열이 2개 모이면 2차원 배열로 부른다.
		 * 	- 기본적으로 2차원 배열을 뜻하며 3차원은 거의 사용되지 않는다.
		 * 
		 * 	- 자료형 [][] 배열의 명칭 = new 자료형 [1차원 배열의 큰방][1차원 배열 각 방의 수];
		 * 
		 * 	- 2차원 배열에는 가장 작은 방에만 값을 넣을 수 있고, 큰 방에는 값을 담을 수 없다.
		 *		- 큰 방은 작은 방에 진입하기위한 진입로의 역할만 한다.
		 *
		 *		- 2차원 배열은 이중 반복문을 통해서 값을 조회할 수 있다.
		 */

		// 2차원 배열 선언
		// [2] : 1차원 배열의 수 (큰 방)
		// [3] : 각 1차원 배열의 index수 (작은 방)
		int [][] test = new int[2][3];		// 2행 3열
		
		// 2차원 배열 값 저장
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		test[1][0] = 400;
		test[1][1] = 500;
		test[1][2] = 600;
		
		// 이중 반복문을 통한 2차원 배열의 확인
		// test.length : 큰방의 수
		// test[i].length : 작은방의 수
		for(int i=0;i<test.length;i++) {	// y축
			//
			for(int j=0;j<test[i].length;j++) { // x축
				System.out.print(test[i][j]+" ");
			}
			System.out.println();
		}
	}
}
