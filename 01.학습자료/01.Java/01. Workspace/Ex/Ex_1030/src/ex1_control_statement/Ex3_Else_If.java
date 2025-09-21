package ex1_control_statement;

public class Ex3_Else_If {

	public static void main(String[] args) {
		
		// else if
		// - 여러 조건 중 맞는 조건의 값을 찾아내는 분기문
		// - 다중 if문이라고 부르며 여러 조건 비교가 필요한 경우 사용하는 분기문
		// - 조건이 거짓인 경우 해당 구문을 넘기고, 참인 경우 그 이후의 코드를 검토하지 않고 그대로 분기문을 종료한다.
		int num = 67;
		String str = "";
		
		if(num>=90) {
			str = "A";
		} else if(num>=80) {
			str = "B";			
		} else if(num>=70) {
			str = "C";			
		} else if(num>=60) {
			str = "D";
		} else {
			str = "F";
		}
		
		System.out.printf("당신의 학점은 %s입니다.",str);
		
	}
}
