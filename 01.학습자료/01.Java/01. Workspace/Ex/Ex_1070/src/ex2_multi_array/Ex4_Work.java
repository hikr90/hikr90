package ex2_multi_array;

public class Ex4_Work {

	public static void main(String[] args) {
		
		// 문제
		// - 2차원 배열에 담긴 모든 값을 합과 평균을 콘솔에 보여주세요.
		int [][] arr = {{3,6,5,1,8},
				{10,15,11,14,3,6},
				{1,4,7,1},
				{11,7,20,21},
				{3,7} };
		//
		int total = 0;
		float avg = 0;
		int count = 0;
		//
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				total += arr[i][j];
				count ++;
			}
			avg = (float)total/count;
		}
		//
		System.out.println("총 합 : "+total);
		System.out.printf("평 균 : %.2f\n",avg);
	}
}
