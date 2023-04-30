package ex1_computer;

public class ComMain {
	public static void main(String[] args) {
		// 클래스를 사용하는 클래스는 메인이 필요하다.
		
		// Computer에서 (컴퓨터를 다른 공장에서 생산한 컴퓨터를 내가 삼)
		// stack에 c1(객체)의 주소값 이 생기고 heap에  컴퓨터에 해당하는 클래스의 모든 데이터가 담기게 된다. 
		Computer c1 = new Computer();
		
		// 클래스. 는 c1이 가지고있는 hdd라는 데이터에 접근해서 hdd의 값인 500을 꺼내올 수 있다.
		// 설계도에대한 정보를 가져옴
		System.out.println(c1.hdd);
		System.out.println(c1.ram);
		System.out.println(c1.cpu);
		System.out.println(c1.color);
		
		System.out.println("---------------");
		
		// 다른 친구가 똑같은 사양의 컴퓨터를 사는 행위
		// 당연히 같은 사양이니 같은 정보가 꺼내져온다. 
		Computer c2 = new Computer();
		
		System.out.println(c2.hdd);
		System.out.println(c2.ram);
		System.out.println(c2.cpu);
		System.out.println(c2.color);
		
		System.out.println("---------------");

		// 왜 new로 다른 영역을 가지는가?
		// 내 컴퓨터가 망가진다고 내 친구 컴도 망가지지는 않기 때문이다.
		
		// 친구가 하드를 업그레이드 시킨다면
		// stack의 c2에 접근하여 주소값을 통해서 heap의 c2데이터로 이동하여 hdd 500을 1000으로 변경하게 된다.
		// 즉, 특정 개체에 접근하여 개체의 데이터를 변경하는 것이 가능하다. 
		c2.hdd = 1000;
		System.out.println(c2.hdd);
		
		System.out.println("---------------");
		
		// 반복되는 코드 작업을 피하기위한 용도로서 매서드가 사용된다. 
		// c2(친구)의 hdd만 1000으로 변경되어있으니 1000으로 변경되어있는 것을 확인할 수 있다. 
		c1.getInfo();
		c2.getInfo();
		
		// private가 걸린 변수나 매서드는 타 클래스에서 사용할 수 없다.
		//(오류)c2.company = "apple";
	
	
	
	}
}
