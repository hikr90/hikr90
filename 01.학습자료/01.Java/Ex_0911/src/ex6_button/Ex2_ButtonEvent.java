package ex6_button;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex2_ButtonEvent {
	public static void main(String[] args) {
		//
		Frame f = new Frame();
		f.setBounds(600, 200, 1000, 500);
		f.setLayout(new FlowLayout());
		//
		Button btn1 = new Button("버튼1");
		Button btn2 = new Button("버튼2");
		Button btn3 = new Button("버튼3");
		Button btn4 = new Button("버튼4");
		
		// - 부모 격인 프레임이 FlowLayout 으로 되어있다면 자식 격의 컴포넌트들은 사이즈 변경이 안된다.
		btn1.setPreferredSize(new Dimension(200,100));	// 파라미터 : 너비, 높이
		btn2.setPreferredSize(new Dimension(200,100));
		btn3.setPreferredSize(new Dimension(200,100));
		btn4.setPreferredSize(new Dimension(200,100));
		// - 버튼 추가
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);

		// 버튼 이벤트 감지자
		// (1) addActionListener 사용
		// - 1번 버튼
		btn1.addActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {
				// 1번 누른 순간, actionPerformed로 감지하고 메서드 안에 동작을 작업한다.
				System.out.println("1번 버튼 눌렀음");
			}
		});

		// - 2번 버튼
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("2번 버튼 눌렀음");
			}
		});

		// - 3번 버튼
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("3번 버튼 눌렀음");
			}
		});
		
		// - 4번 버튼
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("4번 버튼 눌렀음");
			}
		})
		;
		// 프레임 이벤트 감지자
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		//
		f.setVisible(true);
	}
}
