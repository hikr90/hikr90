package ex6_layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex2_Border_Layout {
	public static void main(String[] args) {
		//
		Frame f = new Frame();
		f.setBounds(500, 400, 400, 300);
		//
		f.setLayout(new BorderLayout());
		//
		Button btn1 = new Button("북쪽"); 
		Button btn2 = new Button("서쪽"); 
		Button btn3 = new Button("중앙"); 
		Button btn4 = new Button("동쪽"); 
		Button btn5 = new Button("남쪽"); 
		Button btn6 = new Button("난 땅부자"); 
		
		// Border 속성은 위치 지정이 되어야한다. (기본 값은 중앙이다.)
		f.add(btn1, BorderLayout.NORTH);
		f.add(btn2, BorderLayout.WEST);
		f.add(btn3,BorderLayout.CENTER);
		f.add(btn4,BorderLayout.EAST);
		f.add(btn5,BorderLayout.SOUTH);
		// f.add(btn6,BorderLayout.NORTH); 같은 영역에는 중복으로 넣을 수 없다. (넣어도 마지막에 넣은 것만 뜬다.)
		
		// 아래와 같이도 넣을 수 있다. 단, 첫글자를 대문자로 해야한다.
		// f.add(btn6,"North")
		
		// 이벤트 추가
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		//
		f.setVisible(true);
	} 
}
