package ex6_button;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex1_ButtonTest {
	public static void main(String[] args) {

		Frame f = new Frame("��ư �׽�Ʈ");
		f.setBounds(500,400,400,400);

		// ��ư
		// ������ Ȯ�� ������ Ŭ������ �θ�(object��) : comp
		// frame�� �⺻������ add�ϴ� ��ü�� �ڽ��� ������ ���� ä��� �ڵ���ġ�Ӽ��� ������ �ִ�.
		// frame�� �ڽ����� ������ ��ü���� ��ġ�� �ʰ� ǥ���Ϸ��� �ڵ���ġ�� ������Ѵ�.
		// ��, ��ư�� add�� �ΰ� ������ �߰� ��ư���� ���� ��ư�� ������ �ڵ��̰Եȴ�. 

		// �ڵ���ġ ����
		// �ڵ���ġ�� �����ϸ� ��ư�� ��� ��������� ũ��� ��ġ���� ���� ����������Ѵ�.
		f.setLayout(null);
		
		Button btnOk = new Button("�߰�");
		Button btnClose  = new Button("����");

		// �ڵ���ġ�� ���������� ���ʿ� �߰��� ������Ʈ(button��)�� �ݵ�� ������ ������Ʈ ������ ��ġ�� ������ ������ �������Ѵ�.
		btnOk.setSize(100,50);
		btnOk.setLocation(70,90);
		
		btnClose.setBounds(230, 90, 100, 50);
		
		
		// frame�� ��ư ����
		f.add(btnOk);
		f.add(btnClose);

		// ����
		f.addWindowListener(new WindowAdapter() {


			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});





		f.setVisible(true);






















	}
}
