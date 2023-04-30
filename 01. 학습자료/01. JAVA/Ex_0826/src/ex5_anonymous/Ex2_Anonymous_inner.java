package ex5_anonymous;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// �͸� ���� Ŭ����
public class Ex2_Anonymous_inner {
	public static void main(String[] args) {
		
		// �׵θ�
		Frame f = new Frame();
		// ��ư
		Button btn = new Button("�� �ҷ�?");
		// ������
		f.setSize(300,300);
		f.add(btn);
		// true�� ���δ�. (�⺻�� false)
		f.setVisible(true);
		
		// �������̽��� �ν��Ͻ��� ���� ���� �� ���, �ڽ��� ���ؼ� ������ ������(new�� �����) �������ؾ��Ѵ�.
		// ��ȣ�ȿ� �Ｎ���� �̸��� ���� ��ü�� �͸� ���� Ŭ������� �Ѵ�. 
		
		// �̺�Ʈ : ��ư Ŭ����, ��û�� �Ϳ����� �ǵ��
		// �̺�Ʈ ������ : �̺�Ʈ Ŭ���� �ϰ����ϴ� �̺�Ʈ
		// ()�ȿ�  actionlistener�� �־���ϴµ� �������̽��̴�.
		// �������̽��� �ν��Ͻ��� ���� �� ��� �׳� new�� ����� �������̵� �޼��尡 �ö�´�.
		// addactionlistener : ��ư�� Ŭ��
		// (new actionlistener)�� �͸� ���� Ŭ����
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
