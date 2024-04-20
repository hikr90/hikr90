package ex3_overload;

public class Bread {

	/*문제 Overriding을 통해서 여러 종류의 빵을 만드는 메서드를 만드세요.*/
	public void makeBread() {
		System.out.println("빵을 만들었습니다.");
	}

	public void makeBread(int n) {
		for(int i=0;i<n;i++) {
			System.out.println("빵을 만들었습니다.");
		}
		System.out.printf("요청하신 %d개의 빵을 만들었습니다.\n",n);
	}

	
	
	public void makeBread(int n,String name) {
		for(int i=0;i<n;i++) {
			System.out.println(name+"을(를) 만들었습니다.");
		}
		System.out.printf("요청하신 %d개의 %s을 만들었습니다.\n",n,name);
	}





}
