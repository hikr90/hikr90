package ex4_anonymous;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex2_Anony_Interface {
	public static void main(String[] args) {
		/*	�������̽��� �͸� Ŭ����
		 *		- �������̽��� �ν��Ͻ��� ���� ���������ϹǷ�, �ڽ��� ���ؼ� �����ϴ� ����� �ƴ� NewŰ����� �����ϴ� ���
		 * 		- �������̵� �޼ҵ带 �����ϵ��� �͸� Ŭ������ �����ȴ�.
		 */
		Frame f = new Frame();
		Button btn = new Button("�� �ҷ�?");
		//
		f.setSize(300,300);
		f.add(btn);
		f.setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�ȳ��ϼ���.");
				// frame����
				System.exit(0);
			}
		});
	}
}
