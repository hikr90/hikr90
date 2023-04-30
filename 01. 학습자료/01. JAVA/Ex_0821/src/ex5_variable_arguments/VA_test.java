package ex5_variable_arguments;

public class VA_test {
	
	// 파라미터의 자료형 뒤에 ...이 있으면 variable argument로 부른다.
	// ...를 사용하는 경우 해당 숫자가 배열로 바뀐다.
	// 1~5값이 들어가는 int형의 배열 n이 생성
	public void test(int... n) {
		
		for(int i=0;i<n.length;i++) {
			System.out.println(n[i]);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
