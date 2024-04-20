package ex4_array;

public class Ex1_single_array {
	public static void main(String[] args) {
		
		/* 배열 : 같은 자료형끼리 모아두는 하나의 묶음
		효율적인 자료관리를 위해 반드시 필요한 개념 (공통된 변수의 이름을 지정)*/
	
	// 1 배열 선언 (su라는 명칭의 배열을 생성)
	int [] su;
	
	// 2 배열 생성
	su = new int[4];
	
	// 선언과 생성을 동시에 작업
	int [] su0 = new int[5];
	
	// 3 배열의 초기화 (배열의 각 index에 값을 넣어주는 작업)
	// 존재하지 않는 index에는 값을 넣을 수 없다.
	su[0] = 10;
	su[1] = 20;
	su[2] = 30;
	su[3] = 40;
	
	// 인덱스 번호 출력
	System.out.println(su); // <- stack에 저장된 배열의 주소값을 확인
	System.out.println(su[0]); // <- heap에 저장된 해당 index에 저장된 값을 확인
	
	// for문을 통한 전체 index번호에 저장된 값 출력
	for(int i=0;i<=3;i++) {
		System.out.println(su[i]);
	}

	// for문을 통해서 각 index의 저장공간에 값을 부여하는 것도 가능하다. 
	for(int i=0;i<=3;i++) {
		su[i] = (i + 1)*100;
		System.out.println(su[i]);
	}

	// 배열은 생성 후에 저장공간의 수를 조절할 수 없다.
	// 만약, 5개의 방을 만들어서 4개의 방까지만 값을 집어넣은 경우, 값이 부여되지 않은 방의 값은 숫자 데이터에 한해서 0이다.
	// length를 사용하는 경우 < <= 구분을 잘 해야한다. 
	for(int i=0;i<su.length;i++) {
		System.out.println(su[i]);
	}

	
	}
}
