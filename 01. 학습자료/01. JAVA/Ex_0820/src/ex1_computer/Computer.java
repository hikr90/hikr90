package ex1_computer;

public class Computer {
		// 컴퓨터를 대량 생산하기 위한 설계도
		// (중요!)설계도(클래스)는 main에서 만들지 않는다. 
		/* 특정 제품을 여러 곳에서 대량 생산하기위해서는 설계도를 제작하여 여러곳에서 생산할 수 있도록하는데 
		 * 여기서 설계도는 클래스의 개념과 같다.
		 * */
		int hdd = 500;
		int ram = 16;
		float cpu = 2.5f;
		String color = "white";
		
		// 제조사와 같이 타 클래스에서 변경될 수 없는 정보는 private(현 클래스에서만 사용가능) 으로 묶는다.
		// private는 보안의 목적으로, 많이 사용된다. 
		private String company = "LG";
		
	
		// 메서드 생성
		// 컴퓨터의 정보를 반환하는 메서드 생성
		// 모든 매서드는 뒤에 ()가 붙는다. 
		// heap의 c1이라는 객체에 getInfo라는 기능이 추가된 것이다.
		// 메서드란 어떠한 작업을 수행하기위한 명령문의 집합
		// 자주 사용되는 코드를 메서드로 묶어두면 필요할 때마다 호출만 해서 사용할 수 있다. 
		public void getInfo() {
			System.out.println("제조사 : "+company);
			System.out.println("hdd : "+hdd+"GB");
			System.out.println("ram : "+ram+"GB");
			System.out.println("cpu : "+cpu+"GHz");
			System.out.println("color : "+color);
			System.out.println("------------------");
		}
		
		// (중요!)메서드의 구성
		// public void getInfo(){}
		// public : 접근제한자
		// 접근 제한자의 종류
		// 1 public : 같은 프로젝트 내의 모든 객체들에게 사용을 허가
		// 2 private : 현재 클래스에서만 사용을 허가하는 접근제한자
		// 3 protected : 상속관계의 객체에서만 사용을 허가
		// 4 default(public자리에 아무것도 쓰지 않은) : 같은 패키지내의 객체만 사용을 허가
		
		// void : 반환형 (값을 넣었을 때, 돌려주는 리턴값이 있다.)
		
		// getInfo(파라미터(인자)){메서드의 실행영역} : 메서드명 (메서드 명의 첫글자는 반드시 소문자로 작성하자)
		// 파라미터(인자, 매개변수, args) : 메서드의 실행 영역 내용에따라서 넣을수도 넣지 않을 수도 있다. 넣을 경우, 메서드 사용시 해당 값을 넣어야한다. 
		
		
		
		// 클래스의 구성요소
		// 변수(속성,멤버), 메서드(함수)
		// 변수만 있거나 매서드만 있는 경우도 있으나 둘다 없는 경우는 없다.
		
		
	public static void main(String[] args) {
		
		
		
		
	}
}
