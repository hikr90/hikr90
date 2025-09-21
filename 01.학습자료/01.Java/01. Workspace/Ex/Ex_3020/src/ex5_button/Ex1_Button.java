package ex5_button;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex1_Button {
	public static void main(String[] args) {
		//
		Frame f = new Frame("��ư �׽�Ʈ");
		f.setBounds(500,400,400,400);
		
		/*	��ư
		 * 	- ��ư Ŭ���� (������ ���� ���� ���̴� ��ư�̳� ���̾ƿ� ���� �繰�� ������Ʈ��� �θ���.)
		 * 	- �������� �⺻������ add�ϴ� ��ü�� �ڽ��� ������ ���� ä����� �ڵ� ��ġ �Ӽ��� ������ �ִ�.
		 * 	- �� �Ӽ��� off �ص��� ������ ��ư�� ���ļ� ������ �ʴ� ��찡 �ִ�.
		 */
		f.setLayout(null);	// �ڵ� ��ġ ���� (���� ��, �����ڰ� ���� ��ġ�� ����������Ѵ�.)
		//
		Button btnOk = new Button("�߰�");
		Button btnClose  = new Button("����");

		// - �ڵ���ġ�� ���������� ���ʿ� �߰��� ������Ʈ�� �ݵ�� ������ ��ġ�� ������ ������ �������Ѵ�.
		btnOk.setSize(100,50);
		btnOk.setLocation(70,90);
		//
		btnClose.setBounds(230, 90, 100, 50);
		
		// �����ӿ� ��ư�� �߰�
		f.add(btnOk);
		f.add(btnClose);

		// ���� �̺�Ʈ �߰�
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		//
		f.setVisible(true);
	}
}
