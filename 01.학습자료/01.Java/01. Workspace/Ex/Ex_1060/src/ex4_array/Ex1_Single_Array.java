package ex4_array;

import java.util.Arrays;

public class Ex1_Single_Array {
	public static void main(String[] args) {
		
		/* 배열
		 *		- 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
		 *		- 배열 내의 각 저장 공간은 인덱스로 부르며 인덱스는 0부터 시작된다.
		 *		- 인덱스는 배열의 요소라고도 부른다.
		 *
		 *		(1) 배열의 장점
		 *			- 여러 자료형에 공통된 변수의 명칭으로 지정하므로 자료 관리가 용이하다.
		 *			- 선언 시 특정한 자료형으로 지정할 수 있다.
		 *
		 *		(2) 배열의 선언 방식
		 *			- (2.1) 선언과 동시에 데이터를 추가
		 *			- (2.2) 값의 추가 없이 배열의 틀만 선언
		 * 
		 * 		(3) 배열의 규칙
		 * 			- (3.1) 배열은 선언 후 인덱스의 값을 수정할 수 없다.
		 * 			- (3.2) 배열의 선언은 참조변수를 위한 공간만이 존재하는 것으로 값을 넣기 전까지는 배열의 기본 값이 존재한다.
		 * 					- (int의 경우, default인 0으로 존재)
		 */
	
		// 배열의 틀만 선언
		int [] su;
		
		// 배열의 데이터 추가
		su = new int[4];
		
		// 선언과 함께 데이터 추가
		int [] su0 = new int[5];

		// 배열의 초기화
		// - 존재하지 않는 인덱스에는 값을 넣을 수 없다.
		su[0] = 10;
		su[1] = 20;
		su[2] = 30;
		su[3] = 40;
		//
		System.out.println(su); 	// stack에 저장된 배열의 주소 값
		System.out.println(su[0]); 	// heap에 저장된 해당 인덱스에 저장된 값
		
		// 반복문을 통해서 배열 인덱스의 값 확인
		for(int i=0;i<=3;i++) {
			System.out.println(su[i]);
		}
		
		// 메소드 방식으로 값 확인
		System.out.println(Arrays.toString(su));
	
		// 반복문을 통해서 각 인덱스에 값 부여
		for(int i=0;i<=3;i++) {
			su[i] = (i + 1)*100;
			System.out.println(su[i]);
		}
		
		// length는 배열 사이즈를 뜻한다.
		for(int i=0;i<su.length;i++) {
			System.out.println(su[i]);
		}
	}
}
