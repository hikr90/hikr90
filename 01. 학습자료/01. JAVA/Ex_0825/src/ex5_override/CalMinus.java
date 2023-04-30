package ex5_override;

public class CalMinus extends Calculator{
	
	@Override
	public void getResult(int num1, int num2) {
		System.out.println(num1-num2);
	}
}
