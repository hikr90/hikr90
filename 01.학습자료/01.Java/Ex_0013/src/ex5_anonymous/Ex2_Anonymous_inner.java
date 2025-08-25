package ex5_anonymous;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex2_Anonymous_inner {
	public static void main(String[] args) {
		//
		Frame f = new Frame();
		Button btn = new Button("뭘 할래?");
		//
		f.setSize(300,300);
		f.add(btn);
		f.setVisible(true);
		
		// 인터페이스의 익명 클래스
		// - 인터페이스는 인스턴스를 직접 가지지못하므로, 자식을 통해서 선언하는 방법이 아닌 New 키워드로 선언할 경우
		// - 오버라이딩 메소드를 구현하도록 익명 클래스가 생성된다.
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("안녕하세요.");
				// frame종료
				System.exit(0);
			}
		});
	}
}
