package ex4_image;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ex1_Image {
	
	static boolean test = false;
	
	public static void main(String[] args) {

		// �̹��� ���� ��, �ڹ� ������Ʈ Ŭ���� �� �ٿ��ֱ�
		Frame f = new Frame();
		f.setLayout(null);
		f.setBounds(500, 200, 600, 600);
		
		// �̹���
		ImageIcon img1 = new ImageIcon("���̾�.png");
		
		// JLable : �̹����� �ؽ�Ʈ�� ���� �ִ� Ŭ����
		JLabel jl1 = new JLabel(img1);
		jl1.setBounds(10, 50, 200, 200);
		//
		ImageIcon img2 = new ImageIcon("�ɽ�.jpg");
		JLabel jl2 = new JLabel(img2);
		jl2.setBounds(50, 60, 300, 300);
		
		// ��ư �߰�
		Button btn = new Button("Ȯ��");
		btn.setBounds(360, 60, 100, 100);
		
		// ��ư ������
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// - ���� ������ true, false�� ���� (flag���)
				test = !test;
				if(test) {
					// - setIcon : �̹��� ����
					jl2.setIcon(img1);
				}else {
					jl2.setIcon(img2);
				}
			}
		});
		
		// - �̹����� ���ļ� ������� �� �ִ�, ���� ���߿� add�� ���� �� �ؿ� ���δ�.
		f.add(jl1);
		f.add(jl2);
		f.add(btn);
		
		// �̺�Ʈ ����
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//
		f.setVisible(true);
	} // main
}
