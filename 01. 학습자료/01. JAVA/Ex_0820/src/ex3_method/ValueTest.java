package ex3_method;

public class ValueTest {
	
	// 메서드 생성
	public void greet() {
		System.out.println("안녕하세요.");
		System.out.println("반갑습니다.");

		
	} //greet()
	
	
	
	
	// 파라미터를 받는 다른 메서드 생성
	// 메서드 사용시 ()안에 있는 값을 넣어줘야한다.
	public void test1(int n) {
		
		n+=100;
		System.out.println("n : "+n);
	}
	
	// 반환형의 메서드
	// 복사본의 값을 가지고오는 방법
	// void가 아닌 경우, return이라는 키워드를 넣어야한다.
	// int는 반환하는 값의 타입을 뜻한다.
	// 반환하는 타입과 return의 타입은 반드시 일치해야한다.
	public int test0(int n) {
		n+=100;
		System.out.println("n : "+n);
		
		return n;
	}
	
	// String식의 리턴 매서드
	// 리턴 식 밑에는 break나 continue같이 어떤 코드도 넣을 수 없다.
	// void를 쓰고도 리턴을 사용할 수는 있다. (생략이 가능해서 딱히 넣지는 않는다.)
	// return은 하나만 사용할 수 있지만 if문에서는 실행 여부에따라서 하나인 경우만 되면 되기에 코드상 두개 이상일 순 있다.
	public String test2(int age) {
		
		if(age>=20) {
			return "합격";
		}
		return "불합격";
		
	}
	
	
	// boolean으로 반환하는 메서드
	// 파라미터의 제한은 없다. (많아봐야 7개정도)
	public boolean test3(String gender, int age){
		
		if(gender.equals("남")&&age>=19) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
}
