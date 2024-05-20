package ex4_array;

public class Ex3_single_array {

	public static void main(String[] args) {
		
		// 문제
		// - 배열 내 담긴 모든 값의 합을 구하세요.
		// - 일반 반복문과 개선된 반복문으로 보여주세요.
		int [] arr = {15,22,17,30,50};
		int result = 0;
		//
		for(int i=0;i<arr.length;i++) {
			result += arr[i];
		}
		System.out.printf("총 합 : %d\n",result);
		
		System.out.println("------------");
		result = 0;
		
		//
		for(int i : arr) {
			result += i;
		}
		System.out.println("총 합 : "+result);
	}
}
