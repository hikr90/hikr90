package ex2_choice;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex2_Choice {
	public static void main(String[] args) {
		
		Frame f = new Frame(); 
		f.setBounds(400, 100, 500, 250);
		f.setLayout(null);
		
		// ���û���
		Choice bloodType = new Choice();
		bloodType.add("�������� �����Դϱ�?");
		bloodType.add("A");
		bloodType.add("B");
		bloodType.add("O");
		bloodType.add("AB");
		
		// choice�� ����(200)�� ���� �ǹ̰� ����. 
		bloodType.setBounds(50, 100, 200, 200);
		bloodType.setBackground(Color.CYAN);

		bloodType.addItemListener(new ChoiceHandler());
		
		
		
		// ���� ������ �̺�Ʈ ������ ���
		// ���� Ŭ������ �����غ���
//		bloodType.addItemListener(new ItemListener() {
//			
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				// getSelectedItem�� �׸񿡼� Ư�� �׸��� �������� ��, �ش� �׸��� ��ȯ�ϴ� �޼����̴�.
//				System.out.println(bloodType.getSelectedItem());
//				
//			}
//		});
		
		
		
		
		
		f.add(bloodType);
		
		
		
		
		
		
		
		
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		
		
		
		
		
		
		f.setVisible(true);
		
		
		
		
		
		
		
		
		
	} // main
}
