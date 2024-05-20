package ex7_layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex1_FlowLayout {
	public static void main(String[] args) {
		//
		Frame f = new Frame();
		f.setBounds(500, 400, 400, 300);
		//
		Button btn1 = new Button("��ư1");
		Button btn2 = new Button("��ư2");
		Button btn3 = new Button("��ư3");
		Button btn4 = new Button("��ư4");
		Button btn5 = new Button("��ư5");
		Button btn6 = new Button("��ư6");
		
		// FlowLayout
		// - ������ ������ ��ġ�ϴ� ���̾ƿ� 
		// - ��ư�� ������ �� ��ġ ������ �� ��ƴ�.
		f.setLayout(new FlowLayout());
		f.add(btn1); f.add(btn2); f.add(btn3);
		f.add(btn4); f.add(btn5); f.add(btn6);
		//
		f.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		//
		f.setVisible(true);
	}
}
