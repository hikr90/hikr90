package ex4_array;

import java.util.Arrays;

public class Ex1_single_array {
	public static void main(String[] args) {
		
		/* 배열
		 *		- 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
		 *		- 배열 내의 각 저장 공간을 인덱스라고 부르며 0번부터 시작한다.
		 *
		 *		- 여러 자료형에 공통된 변수의 명칭으로 지정하므로 자료 관리가 용이하다.
		 *		- 선언 시 특정한 자료형으로 지정할 수 있다.
		 *		- 선언은 선언과 함께 데이터를 추가하는 방식과 값의 추가 없이 틀만 추가하는 선언 방식이 있다. 
		 * 
		 * 	- 배열은 선언 후 인덱스의 값을 수정할 수 없다.
		 * 	- 배열을 선언하는 것은 참조변수를 위한 공간이 만들어지는 것 뿐이며, 배열을 생성해야만 값을 저장할 수 있는 공간이 만들어진다.
		 * 	- 배열 생성 시, 각 배열 요소는 자동적으로 타입의 default값으로 지정된다. (int 형의 변수인 경우 default 인 0 으로 생성된다.)
		 * 	- 생성된 배열의 각 저장공간을 배열의 요소라고 부르며 각 저장공간은 배열명[인덱스] 로 접근 가능하다.
		 * 	- 인덱스는 배열의 요소마다 붙여진 일련번호로 0부터 시작한다. (인덱스의 범위는 0부터 배열길이 -1 까지이다.)
		 * 
		 * 	생성 방법
		 * 		타입 [] 변수 이름 = new 타입[길이]; 
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
		System.out.println(su); // stack에 저장된 배열의 주소 값
		System.out.println(su[0]); // heap에 저장된 해당 인덱스에 저장된 값
		
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
