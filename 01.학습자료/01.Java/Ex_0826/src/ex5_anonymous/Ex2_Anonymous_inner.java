package ex5_anonymous;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 익명 내부 클래스
public class Ex2_Anonymous_inner {
	public static void main(String[] args) {
		
		// 테두리
		Frame f = new Frame();
		// 버튼
		Button btn = new Button("뭘 할래?");
		// 사이즈
		f.setSize(300,300);
		f.add(btn);
		// true면 보인다. (기본값 false)
		f.setVisible(true);
		
		// 인터페이스는 인스턴스를 직접 가질 수 없어서, 자식을 통해서 만들지 않으면(new로 만들면) 재정의해야한다.
		// 괄호안에 즉석에서 이름을 없는 객체를 익명 내부 클래스라고 한다. 
		
		// 이벤트 : 버튼 클릭시, 요청한 것에대한 피드백
		// 이벤트 감지자 : 이벤트 클릭시 하고자하는 이벤트
		// ()안에  actionlistener를 넣어야하는데 인터페이스이다.
		// 인터페이스는 인스턴스를 가질 수 없어서 그냥 new로 만들면 오버라이딩 메서드가 올라온다.
		// addactionlistener : 버튼을 클릭
		// (new actionlistener)는 익명 내부 클래스
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
