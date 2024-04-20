package ex2_throws;

public class Throws1 {
	
	public void test() throws Exception{
		
		int n = 0;
		int result = 0; 
		
			// try안에서 생성되는 변수는 그 안에서만 사용가능한 지역변수이므로 사용하고싶다면 전역변수로 변경해줘야한다.
			result = 10/n; 
		System.out.println(result);
		
	}
	
	
	
}
