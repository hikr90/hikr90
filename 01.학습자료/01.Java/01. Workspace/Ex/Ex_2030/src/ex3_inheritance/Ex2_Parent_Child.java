package ex3_inheritance;

public class Ex2_Parent_Child {
	public static void main(String[] args) {
		/* 상속관계의 인스턴스 생성
		 *		- 자식 클래스의 인스턴스를 생성하면 부모 클래스의 멤버와 자식 클래스의 멤버가 합쳐진 인스턴스로 생성된다.
		 *
		 *		(1) 자식 클래스
		 *			- Object > Parent > Child
		 *			- 자식클래스의 인스턴스 생성 시, 자식과 부모의 주소 값은 동일하다.
		 *
		 *  	(2) 부모
		 *  		- Object > Parents
		 *  		- 자식과 부모의 주소 값은 동일하지 않다.
		 */
		CaptionTv ctv = new CaptionTv();
		
		ctv.channel = 10;	// 부모 멤버 사용 가능
		ctv.channelUp();	// 부모 멤버 사용 가능
		System.out.println(ctv.channel);
		
		ctv.displayCaption("Hello, World");
		ctv.caption = true;
		ctv.displayCaption("Hello, World");
	}
}

// 부모 클래스
class Tv {
	boolean power;
	int channel;
	
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

// 자식 클래스
class CaptionTv extends Tv {
	boolean caption;
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
}