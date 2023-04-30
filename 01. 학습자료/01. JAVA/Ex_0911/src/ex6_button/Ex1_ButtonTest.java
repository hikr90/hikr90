package ex6_button;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex1_ButtonTest {
	public static void main(String[] args) {

		Frame f = new Frame("버튼 테스트");
		f.setBounds(500,400,400,400);

		// 버튼
		// 눈으로 확인 가능한 클래스의 부모(object격) : comp
		// frame은 기본적으로 add하는 객체를 자신의 영역에 가득 채우는 자동배치속성을 가지고 있다.
		// frame이 자식으로 가지는 객체들을 겹치지 않게 표현하려면 자동배치를 꺼줘야한다.
		// 즉, 버튼을 add로 두개 넣으면 추가 버튼위에 종료 버튼이 꽉차게 뒤덮이게된다. 

		// 자동배치 종료
		// 자동배치를 종료하면 버튼을 어디에 어느정도의 크기로 배치할지 몰라 지정해줘야한다.
		f.setLayout(null);
		
		Button btnOk = new Button("추가");
		Button btnClose  = new Button("종료");

		// 자동배치가 꺼져있으니 안쪽에 추가될 컴포넌트(button등)은 반드시 고유의 컴포넌트 고유의 위치와 사이즈 정보를 가져야한다.
		btnOk.setSize(100,50);
		btnOk.setLocation(70,90);
		
		btnClose.setBounds(230, 90, 100, 50);
		
		
		// frame에 버튼 부착
		f.add(btnOk);
		f.add(btnClose);

		// 우상단
		f.addWindowListener(new WindowAdapter() {


			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});





		f.setVisible(true);






















	}
}
