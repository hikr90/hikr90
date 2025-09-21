package ex5_button;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex1_Button {
	public static void main(String[] args) {
		//
		Frame f = new Frame("버튼 테스트");
		f.setBounds(500,400,400,400);
		
		/*	버튼
		 * 	- 버튼 클래스 (프레임 내에 눈에 보이는 버튼이나 레이아웃 등의 사물을 컴포넌트라고 부른다.)
		 * 	- 프레임은 기본적으로 add하는 객체를 자신의 영역에 가득 채우려는 자동 배치 속성을 가지고 있다.
		 * 	- 이 속성을 off 해두지 않으면 버튼이 겹쳐서 보이지 않는 경우가 있다.
		 */
		f.setLayout(null);	// 자동 배치 종료 (종료 시, 개발자가 직접 위치를 지정해줘야한다.)
		//
		Button btnOk = new Button("추가");
		Button btnClose  = new Button("종료");

		// - 자동배치가 꺼져있으니 안쪽에 추가될 컴포넌트는 반드시 고유의 위치와 사이즈 정보를 가져야한다.
		btnOk.setSize(100,50);
		btnOk.setLocation(70,90);
		//
		btnClose.setBounds(230, 90, 100, 50);
		
		// 프레임에 버튼을 추가
		f.add(btnOk);
		f.add(btnClose);

		// 우상단 이벤트 추가
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		//
		f.setVisible(true);
	}
}
