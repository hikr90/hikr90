package ex3_inheritance;

public class Ex2_Parent_Child {
	public static void main(String[] args) {
		/* ��Ӱ����� �ν��Ͻ� ����
		 *		- �ڽ� Ŭ������ �ν��Ͻ��� �����ϸ� �θ� Ŭ������ ����� �ڽ� Ŭ������ ����� ������ �ν��Ͻ��� �����ȴ�.
		 *
		 *		(1) �ڽ� Ŭ����
		 *			- Object > Parent > Child
		 *			- �ڽ�Ŭ������ �ν��Ͻ� ���� ��, �ڽİ� �θ��� �ּ� ���� �����ϴ�.
		 *
		 *  	(2) �θ�
		 *  		- Object > Parents
		 *  		- �ڽİ� �θ��� �ּ� ���� �������� �ʴ�.
		 */
		CaptionTv ctv = new CaptionTv();
		
		ctv.channel = 10;	// �θ� ��� ��� ����
		ctv.channelUp();	// �θ� ��� ��� ����
		System.out.println(ctv.channel);
		
		ctv.displayCaption("Hello, World");
		ctv.caption = true;
		ctv.displayCaption("Hello, World");
	}
}

// �θ� Ŭ����
class Tv {
	boolean power;
	int channel;
	
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

// �ڽ� Ŭ����
class CaptionTv extends Tv {
	boolean caption;
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
}