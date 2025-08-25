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
		Button btn1 = new Button("��ư1");
		Button btn2 = new Button("��ư2");
		Button btn3 = new Button("��ư3");
		Button btn4 = new Button("����");
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
		
		// �̺�Ʈ ������ 
		// - ������ ������ ��Ϻ��� ���� �־���Ѵ�.
		// - ���� �������̽��� ���������� ��üȭ�� �� ���Ѵ�. (�߻�޼��带 �����ؾ��ؼ�)

		// (2) ActionListener ���
		// - ��ư 4���� �ѹ��� act�� ����
		ActionListener act = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// - e : ����ڰ� Ŭ���� ��ư�� ������ �������ִ�.
				// - e.getActionCommand() : Ŭ���� ��ư�� �����Ǿ��ִ� ������ �ǹ��Ѵ�.
				// - System.out.println(e.getActionCommand());
				switch (e.getActionCommand()) {
					case "��ư1":
						System.out.println("��ư1�� ������");
						break;
	
					case "��ư2":
						System.out.println("��ư2�� ������");
						break;
	
					case "��ư3":
						System.out.println("��ư3�� ������");					
						break;
					
					case "����":
						System.out.println("���� ������");
						Ex3_ExitEvent ee = new Ex3_ExitEvent();
						break;					
				} // switch
			} // overiding 
		}; // interface
		
		// ��ư�� �̺�Ʈ ������ ���
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
