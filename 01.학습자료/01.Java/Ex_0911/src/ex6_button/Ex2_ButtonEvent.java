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
		Button btn1 = new Button("��ư1");
		Button btn2 = new Button("��ư2");
		Button btn3 = new Button("��ư3");
		Button btn4 = new Button("��ư4");
		
		// - �θ� ���� �������� FlowLayout ���� �Ǿ��ִٸ� �ڽ� ���� ������Ʈ���� ������ ������ �ȵȴ�.
		btn1.setPreferredSize(new Dimension(200,100));	// �Ķ���� : �ʺ�, ����
		btn2.setPreferredSize(new Dimension(200,100));
		btn3.setPreferredSize(new Dimension(200,100));
		btn4.setPreferredSize(new Dimension(200,100));
		// - ��ư �߰�
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);

		// ��ư �̺�Ʈ ������
		// (1) addActionListener ���
		// - 1�� ��ư
		btn1.addActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {
				// 1�� ���� ����, actionPerformed�� �����ϰ� �޼��� �ȿ� ������ �۾��Ѵ�.
				System.out.println("1�� ��ư ������");
			}
		});

		// - 2�� ��ư
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("2�� ��ư ������");
			}
		});

		// - 3�� ��ư
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("3�� ��ư ������");
			}
		});
		
		// - 4�� ��ư
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("4�� ��ư ������");
			}
		})
		;
		// ������ �̺�Ʈ ������
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		//
		f.setVisible(true);
	}
}
