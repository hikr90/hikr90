package ex1_control_statement;

public class Ex3_else_if {

	public static void main(String[] args) {
		
		// 다중 if문(else if) : 여러개의 조건비교가 필요한 경우 사용하는 제어문
		// else if문은 조건이 거짓인 경우 식을 뛰어넘고, 참인 경우부터는 그 이후의 코드를 검토하지 않고 그대로 else if문을 종료한다.
		// else : 위쪽의 조건이 모두 거짓인 경우 무조건 실행되는 영역을 뜻한다.
		
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
