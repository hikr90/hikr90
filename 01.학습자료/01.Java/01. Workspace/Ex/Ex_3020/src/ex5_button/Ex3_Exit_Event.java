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
	// ������ ���� �̺�Ʈ
	public Ex3_Exit_Event() {
		//
		f.setBounds(840, 300, 500, 250);
		f.setVisible(true);
		f.setLayout(null);
		//
		Button btn1 = new Button("�����ϰڽ��ϴ�.");
		Button btn2 = new Button("�������� �ʰڽ��ϴ�.");
		//
		btn1.setBounds(100, 70, 150, 100);
		btn2.setBounds(260, 70, 150, 100);
		//
		f.add(btn1);
		f.add(btn2);
		
		// ��ư �̺�Ʈ ������ ���
		// - �����ϰڽ��ϴ�. ����
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	// ���� �����ִ� ��� �������� ������ ����
			}
		});
		
		// - �������� �ʰڽ��ϴ�. ����
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// dispose() 
				// - ���� �����ִ� �����Ӹ� ����
				f.dispose();
			}
		});
		
		// - Exitâ�� ���� x��ư Ŭ���� �ش� â�� �������� ����
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			};
		});
		//
		f.setVisible(true);
	}
}
