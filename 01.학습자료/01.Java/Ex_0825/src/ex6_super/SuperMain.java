package ex6_super;

public class SuperMain {
	
	public static void main(String[] args) {
		
		Child c = new Child();
		
		// 자식은 부모에게서 상속받았기에 부모가 가지고있는 10이 나온다. 
		System.out.println(c.getNumber());
		
		
		// child에서는 int number;변수가 없기에 부모의 int로 들어갔다.
		// 자식한테는 set number를 통해서 값을 집어넣기위한 this.number가 없는데 그로인해서 파라미터로 넘어갈 값이 부모쪽으로 간 것이다.
		// 이 경우에는 문법상 this가 아닌 super를 해줘야한다. 
		c.setNumber(500);
		System.out.println(c.number);
		
		
		
	}
}
