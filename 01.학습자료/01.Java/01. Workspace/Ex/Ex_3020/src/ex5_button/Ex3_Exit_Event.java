package ex5_button;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex3_Exit_Event {
	//
	Frame f = new Frame();
	// 프레임 종료 이벤트
	public Ex3_Exit_Event() {
		//
		f.setBounds(840, 300, 500, 250);
		f.setVisible(true);
		f.setLayout(null);
		//
		Button btn1 = new Button("종료하겠습니다.");
		Button btn2 = new Button("종료하지 않겠습니다.");
		//
		btn1.setBounds(100, 70, 150, 100);
		btn2.setBounds(260, 70, 150, 100);
		//
		f.add(btn1);
		f.add(btn2);
		
		// 버튼 이벤트 감지자 등록
		// - 종료하겠습니다. 선택
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	// 현재 열려있는 모든 프레임을 강제로 종료
			}
		});
		
		// - 종료하지 않겠습니다. 선택
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// dispose() 
				// - 지금 열려있는 프레임만 종료
				f.dispose();
			}
		});
		
		// - Exit창의 우상단 x버튼 클릭시 해당 창만 꺼지도록 지정
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			};
		});
		//
		f.setVisible(true);
	}
}
