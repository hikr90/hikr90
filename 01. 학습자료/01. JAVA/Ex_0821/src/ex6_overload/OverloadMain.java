package ex6_overload;

public class OverloadMain {
	public static void main(String[] args) {
		
	Ex_Overload ov = new Ex_Overload();
	
	// 같은 메서드를 호출해도 파라미터의 여부에따라서 다른 결과값이 나온다. 
	ov.result();
	ov.result(20);
	ov.result('A');
	// 파라미터를 받는 순서도 일치해야한다. 
	ov.result("dd",10);
	ov.result(10,"dd");
	
	// syso도 오버로딩을 사용해서 만들어진 메서드이다.
	System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
