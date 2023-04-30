package ex4_array;

public class Ex3_single_array {

	public static void main(String[] args) {
		
		/* 배열 arr {15,22,17,30,50} 에 담긴 모든 값의 합을 출력하세요. */
		// 일반 for문
		int [] arr = {15,22,17,30,50};
		int result = 0;
		
		for(int i=0;i<arr.length;i++) {
			result += arr[i];
		}
		System.out.printf("총 합 : %d\n",result);
		
		
		System.out.println("------------");
		result = 0;
		
		// 개선된 for문
		for(int i : arr) {
			result += i;
		}
		System.out.println("총 합 : "+result);

	
	
	}
}
