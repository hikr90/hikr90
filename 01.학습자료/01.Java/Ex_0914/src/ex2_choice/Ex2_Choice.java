package ex2_choice;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex2_Choice {
	public static void main(String[] args) {
		
		Frame f = new Frame(); 
		f.setBounds(400, 100, 500, 250);
		f.setLayout(null);
		
		// 선택상자
		Choice bloodType = new Choice();
		bloodType.add("혈액형은 무엇입니까?");
		bloodType.add("A");
		bloodType.add("B");
		bloodType.add("O");
		bloodType.add("AB");
		
		// choice는 높이(200)의 값이 의미가 없다. 
		bloodType.setBounds(50, 100, 200, 200);
		bloodType.setBackground(Color.CYAN);

		bloodType.addItemListener(new ChoiceHandler());
		
		
		
		// 선택 상자의 이벤트 감지자 등록
		// 따로 클래스로 생성해보자
//		bloodType.addItemListener(new ItemListener() {
//			
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				// getSelectedItem은 항목에서 특정 항목을 선택했을 때, 해당 항목을 반환하는 메서드이다.
//				System.out.println(bloodType.getSelectedItem());
//				
//			}
//		});
		
		
		
		
		
		f.add(bloodType);
		
		
		
		
		
		
		
		
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		
		
		
		
		
		
		f.setVisible(true);
		
		
		
		
		
		
		
		
		
	} // main
}
