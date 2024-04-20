package ex2_multi_array;

public class Ex1_multi_array {
	
	public static void main(String[] args) {
		
		
		/* 다차원배열 : 1차원 배열이 2개 모이면 2차원 배열이 된다.
		 (1차원 배열이 3개 모여있는 경우, 3차원 배열으로 부른다.) */
		
		// 2차원 배열 선언
		// [2] : 1차원 배열의 수 (큰 방)
		// [3] : 각 1차원 배열의 index수 (작은 방)
		// 2차원배열은 2행 3열의 표가 생성된다고 이해하면 된다. 
		int [][] test = new int[2][3];
		
		// 2차원 배열에 값을 넣는 방법
		// 2차원 배열은 가장 작은 방에만 값을 넣을 수 있고, 큰 방에는 값을 담을 수 없다. (작은 방에 진입하기위한 진입로 : 큰 방)		
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		test[1][0] = 400;
		test[1][1] = 500;
		test[1][2] = 600;
		
		// for문을 통한 2차원 배열 출력
		// test.length : 큰방의 수
		// test[i].length : 작은방의 수
		for(int i=0;i<test.length;i++) {	// y축
			
			for(int j=0;j<test[i].length;j++) { // x축
				System.out.print(test[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
