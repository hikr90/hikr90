package ex4_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1_Arrays {
	public static void main(String[] args) {
		/* Arrays
		 * 	- 배열을 다루는데 유용한 메소드가 있는 클래스
		 */
		
		// 복사
		int [] arr1 = {0,1,2,3,4};
		int [] arr2 = Arrays.copyOf(arr1, arr1.length);		// [0,1,2,3,4]
		int [] arr3 = Arrays.copyOfRange(arr1, 2, 4);		// [2,3]
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println("------------------");
		
		// 채우기
		int [] arr4 = new int[5];
		Arrays.fill(arr4, 9);			// [9,9,9,9,9]
		System.out.println(Arrays.toString(arr4));
		System.out.println("------------------");
		
		// 정렬, 검색
		int [] arr5 = {3, 2, 0, 1, 4};
		Arrays.sort(arr5);
		int idx = Arrays.binarySearch(arr5, 2);			// -5는 잘못된 값으로, 반드시 정렬이 된 상태에서 사용해야한다.
		
		/*	순차 검색, 이진 검색
		 * 	(1) 순차 검색
		 * 		- 배열의 첫 요소부터 순서대로 하나씩 검색하는 방식
		 * 		- 배열이 정렬되어있을 필요는 없으나 요소를 하나씩 비교하므로 시간이 많이 든다.
		 * 
		 *  	(2) 이진 검색
		 *  		- 검색할 범위를 반복적으로 절반씩 줄여가며 검색하는 방식
		 *  		- 검색 속도가 빠른 대신, 정렬이 되어있는 상태에서만 사용 가능하다.
		 */
		
		System.out.println(idx);
		System.out.println("------------------");
		
		// 비교, 출력
		int [] arr6 = {0, 1, 2, 3, 4};
		int [][] arr6D = {{11, 12}, {21, 22}};
		
		System.out.println(Arrays.toString(arr6));					// toString (1차원)
		System.out.println(Arrays.deepToString(arr6D));			// deepToString (다차원)
		
		String [][] strD = new String[][] {{"aaa", "bbb"}, {"AAA", "BBB"}};
		String [][] strD2 = new String[][] {{"aaa", "bbb"}, {"AAA", "BBB"}};
		
		System.out.println(Arrays.equals(strD, strD2));				// equals (1차원, 배열의 주소를 비교)
		System.out.println(Arrays.deepEquals(strD, strD2));		// deepEquals (다차원, 배열의 데이터를 재귀방식으로 비교)
		System.out.println("------------------");
		
		// Array > List 변환
		// - asList 메소드는 List의 크기를 변경할 수 없다.
		// - 추가, 삭제 X
		List list1 = Arrays.asList(new Integer[] {0, 1, 2, 3, 4, 5}); 	// [1, 2, 3, 4, 5]
		List list2 = Arrays.asList(1, 2, 3, 4, 5);									// [1, 2, 3, 4, 5] 
		
		// [참고] 크기를 변경할 수 있는 방식
		List list3 = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(list3);
		System.out.println("------------------");
	}
}
