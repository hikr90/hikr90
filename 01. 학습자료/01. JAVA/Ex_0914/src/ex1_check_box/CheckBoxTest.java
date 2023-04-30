package ex1_check_box;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout.Group;

public class CheckBoxTest {
	public static void main(String[] args) {
		
		Frame f = new Frame("�������� ����");
		f.setBounds(500, 200, 800, 250);
		f.setLayout(null);
		
		// �ؽ�Ʈ �߰�
		// ��ư�� ���������� ���̾ƿ��� null�� ���, ũ��� ��ġ�� ����������Ѵ�.
		Label q1 = new Label("1.���ɺоߴ� �����Դϱ�?");
		
		// ���� ��Ÿ���� ����
		// Font(����ü, ���� ��Ÿ��, ���� ũ��)
		Font font = new Font("�ü�ü", Font.BOLD, 30);
		
		q1.setFont(font);
		q1.setBounds(10, 50, 380, 50);
		
		// �����ӿ� Lable �߰�
		f.add(q1);
		
		// CheckBox �߰�
		Checkbox sports = new Checkbox("�");
		Checkbox movie = new Checkbox("��ȭ ����");
		Checkbox music = new Checkbox("���� ����");
		
		sports.setBounds(10, 110, 50, 30);
		sports.setBackground(Color.LIGHT_GRAY);
		f.add(sports);
		
		movie.setBounds(70, 110, 80, 30);
		movie.setBackground(Color.LIGHT_GRAY);
		f.add(movie);
		
		music.setBounds(160, 110, 80, 30);
		music.setBackground(Color.LIGHT_GRAY);
		f.add(music);
		
		// üũ �ڽ� ���� ���� ������
		// ��� üũ�� ���
		sports.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				// üũ �� 1, üũ ������ 2�� �Ѿ��. 
				String str = e.getStateChange() == 1 ? "� ����" : "� ����";
				System.out.println(str);
			}
		});
		
		
		// �ι�° ���̺�(�ؽ�Ʈ) ����
		Label q2 = new Label("2.������ �����Դϱ�?");
		q2.setFont(font);
		q2.setBounds(10, 150, 400, 30);
		f.add(q2);
		
		// ���� ��ư ����
		// �׷� ������, ���� �׷� �������� �ߺ� ������ �ȵȴ�. 
		// CheckBox�� ����Ʈ ���� �־���Ѵ�. 
		CheckboxGroup group = new CheckboxGroup();
		Checkbox male = new Checkbox("����",group,true);
		Checkbox female = new Checkbox("����",group,false);
		
		// ����, ���� ��ư �߰�
		male.setBounds(10, 190, 50, 30);
		female.setBounds(70, 190, 50, 30);
		
		// ��ư �߰�
		f.add(male);
		f.add(female);

		// ����, ���� ��ư �̺�Ʈ ������
		male.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("���� ���õ�");
			}
		});
		
		
		female.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("���� ���õ�");
			}
		});
				
		
		
		// ������ ���� ��ư ������ 
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
		
		
		
		
		
		
		
		
		
		
	} // main 
}
