package ex5_anonymous;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex2_Anonymous_inner {
	public static void main(String[] args) {
		//
		Frame f = new Frame();
		Button btn = new Button("�� �ҷ�?");
		//
		f.setSize(300,300);
		f.add(btn);
		f.setVisible(true);
		
		// �������̽��� �͸� Ŭ����
		// - �������̽��� �ν��Ͻ��� ���� ���������ϹǷ�, �ڽ��� ���ؼ� �����ϴ� ����� �ƴ� New Ű����� ������ ���
		// - �������̵� �޼ҵ带 �����ϵ��� �͸� Ŭ������ �����ȴ�.
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
