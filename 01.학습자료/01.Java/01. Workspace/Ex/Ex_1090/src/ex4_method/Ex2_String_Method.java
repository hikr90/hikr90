package ex4_method;

public class Ex2_String_Method {
	
	// 메소드 생성
	public void greet() {
		System.out.println("안녕하세요.");
		System.out.println("반갑습니다.");
	}
	
	// 메소드 생성
	// - void 형태에서도 return 의 사용이 가능은 하다. (기본적으로는 생략된다.)
	public void test1(int n) {
		n+=100;
		System.out.println("n : "+n);
	}
	
	// 반환타입이 int 값인 메소드 생성
	// void 와 달리 값을 복제하는 것이 아니라 아예 값을 반환한다.
	public int test0(int n) {
		n+=100;
		System.out.println("n : "+n);
		return n;
	}
	
	
	// 반환타입이 String인 메소드 생성
	public String test2(int age) {
		if(age>=20) {
			return "합격";
		}
		return "불합격";
	}
	
	
	// 반환타입이 boolean 인 메소드 생성
	public boolean test3(String gender, int age){
		if(gender.equals("남")&&age>=19) {
			return true;
		}else {
			return false;
		}
	}
}
