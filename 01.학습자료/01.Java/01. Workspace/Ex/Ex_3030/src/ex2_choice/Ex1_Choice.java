package ex2_choice;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ex1_Choice implements ItemListener{
	// ItemListener �������̽� ���� �� ������
	@Override
	public void itemStateChanged(ItemEvent e) {
		// String ����
		String str = (String)e.getItem();
		//
		if(str.equals("�������� �����Դϱ�?")) {
			System.out.println("�Ѱ����� �ݵ�� �����ϼž��մϴ�.");
		}
	}
}
