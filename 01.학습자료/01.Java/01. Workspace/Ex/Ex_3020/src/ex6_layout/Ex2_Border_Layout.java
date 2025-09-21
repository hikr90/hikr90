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
		Button btn1 = new Button("����"); 
		Button btn2 = new Button("����"); 
		Button btn3 = new Button("�߾�"); 
		Button btn4 = new Button("����"); 
		Button btn5 = new Button("����"); 
		Button btn6 = new Button("�� ������"); 
		
		// Border �Ӽ��� ��ġ ������ �Ǿ���Ѵ�. (�⺻ ���� �߾��̴�.)
		f.add(btn1, BorderLayout.NORTH);
		f.add(btn2, BorderLayout.WEST);
		f.add(btn3,BorderLayout.CENTER);
		f.add(btn4,BorderLayout.EAST);
		f.add(btn5,BorderLayout.SOUTH);
		// f.add(btn6,BorderLayout.NORTH); ���� �������� �ߺ����� ���� �� ����. (�־ �������� ���� �͸� ���.)
		
		// �Ʒ��� ���̵� ���� �� �ִ�. ��, ù���ڸ� �빮�ڷ� �ؾ��Ѵ�.
		// f.add(btn6,"North")
		
		// �̺�Ʈ �߰�
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		//
		f.setVisible(true);
	} 
}
