package ex6_button;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex3_ButtonEvent {
	public static void main(String[] args) {
		//
		Frame f = new Frame();
		f.setBounds(600, 200, 1000, 500);
		f.setLayout(new FlowLayout());
		//
		Button btn1 = new Button("버튼1");
		Button btn2 = new Button("버튼2");
		Button btn3 = new Button("버튼3");
		Button btn4 = new Button("종료");
		//
		btn1.setPreferredSize(new Dimension(200,100));
		btn2.setPreferredSize(new Dimension(200,100));
		btn3.setPreferredSize(new Dimension(200,100));
		btn4.setPreferredSize(new Dimension(200,100));
		//
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
		
		// 이벤트 감지자 
		// - 감지자 생성이 등록보다 위에 있어야한다.
		// - 보통 인터페이스는 직접적으로 객체화를 잘 안한다. (추상메서드를 정의해야해서)

		// (2) ActionListener 사용
		// - 버튼 4개를 한번에 act로 감지
		ActionListener act = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// - e : 사용자가 클릭한 버튼의 정보를 가지고있다.
				// - e.getActionCommand() : 클릭한 버튼의 부착되어있는 제목을 의미한다.
				// - System.out.println(e.getActionCommand());
				switch (e.getActionCommand()) {
					case "버튼1":
						System.out.println("버튼1번 눌렀음");
						break;
	
					case "버튼2":
						System.out.println("버튼2번 눌렀음");
						break;
	
					case "버튼3":
						System.out.println("버튼3번 눌렀음");					
						break;
					
					case "종료":
						System.out.println("종료 눌렀음");
						Ex3_ExitEvent ee = new Ex3_ExitEvent();
						break;					
				} // switch
			} // overiding 
		}; // interface
		
		// 버튼에 이벤트 감지자 등록
		btn1.addActionListener(act);
		btn2.addActionListener(act);
		btn3.addActionListener(act);
		btn4.addActionListener(act);
		//
		f.addWindowListener(new WindowAdapter() {
			//
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		//
		f.setVisible(true);
	}
}
