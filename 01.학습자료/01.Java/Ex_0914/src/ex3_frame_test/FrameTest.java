package ex3_frame_test;
/* ��ư �̺�Ʈ �����
 * Button : addActionListener
 * CheckBox : addItemListener
 * TextField, TextArea : addTextListener
 * ���� ��ư : addWindowListener
 * Ű���� �Է� ���� : addKeyListener*/
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FrameTest {
	public static void main(String[] args) {
		//
		Frame frame = new Frame("���� �Է±�");
		frame.setBounds(500, 200, 250, 400);
		frame.setBackground(Color.CYAN);
		
		// PLAIN : �Ϲ�
		Font font = new Font(Font.SANS_SERIF,Font.PLAIN,18);
		
		// ���ʴ� ---------------------
		// - �������� ������Ʈ(��ư)�� ��� �ѹ��� �����ϴ� Ŭ���� (�⺻ �Ӽ��� FlowLayout)
		Panel pNorth = new Panel();
		pNorth.setBackground(Color.GREEN);
		
		// - �ؽ�Ʈ �ʵ�ȿ��� Ű���� �Է°��� ���� �� �ְ��ϴ� Ŭ����
		// - ()���� ���ڴ� �Է»����� ���̸� ���Ѵ�. 
		TextField tf = new TextField(10);
		
		Button btn = new Button("�Է�");
		
		// - ��ư ��Ȱ��ȭ
		// - ���ڰ� �ԷµǾ��� ��, true�� �ٲٴ� �������� ���� ����Ѵ�. 
		btn.setEnabled(false);
		
		// - pNorth�� �гο� �÷ο� ���̾ƿ����� tf�� ��ư�� �ٰԵȴ�.
		pNorth.add(tf);
		pNorth.add(btn);
		pNorth.setFont(font);
		
		// - �����ӿ� �־��ش�.
		// - ���� ������ BorderLayout���� �־��� �� �ִ�.
		// - (�гη� �Ѳ����� ��� ��ġ �����ؼ� �����ӿ� �־��ִ� ���)
		frame.add(pNorth,BorderLayout.NORTH);
		
		
		// �߾Ӵ� ---------------------
		// - TextFiled�� ª�� ����
		// - TextArea�� �� ����
		// - ��� ���� ���� ���� ���̿� ���� ���̸� ���ϴµ� ������ �߾ӿ� �� ä���� ���� 0���� ó���ص� �������.
		// - TextArea.SCROLLBARS_VERTICAL_ONLY : ��ũ�� ���θ� ����
		TextArea ta = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setBackground(Color.LIGHT_GRAY);
		ta.setFont(font);
		
		// - ta�� ���� �Է��� �� ������ ��Ȱ��ȭ
		ta.setEditable(false);
		//
		frame.add(ta);
		

		// ���ʴ� ---------------------
		Panel pSouth = new Panel();
		pSouth.setBackground(Color.MAGENTA);
		
		Button btnSave = new Button("����");
		Button btnClose = new Button("����");
		
		pSouth.add(btnSave);
		pSouth.add(btnClose);
		
		frame.add(pSouth,BorderLayout.SOUTH);
		
		// - �������� ����� ������Ű�� ���
		frame.setResizable(false);
		
		// - TextField�� ���� ���� ��� �Է� ��ư�� Ȱ��ȭ
		tf.addTextListener(new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent e) {
				// - tf�� �������ִ� ������ �������� ���� getText�̴�.
				// - ������ ������ ���� �ִ� ��� �Է� ��ư Ȱ��ȭ 
				if(tf.getText().trim().equals("")) {
					btn.setEnabled(false);
				}else {
					btn.setEnabled(true);
				}
			}
		});
		
		// - �Է� ��ư�� Ŭ���� TextArea�� ������ �߰��Ѵ�.
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// - ta�� ���� �߰��ϴ� ���
				ta.append(tf.getText().trim()+"\n");
				
				// - �ؽ�Ʈ �ʵ带 ��� �� ��Ŀ�� �̵�
				tf.setText("");
				// - �ѹ� ���� �Է��ϸ� Ŀ���� �Ѿ��. (�Է��� ���� �Է� �������� �ʱ�ȭ)
				tf.requestFocus();
			}
		});
		
		
		// - ���Ͱ��� �Է��� ��, �Է¹�ư�� ���� ����� �ϵ��� ó��
		tf.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar()==KeyEvent.VK_ENTER) {
					ta.append(tf.getText().trim()+"\n");					
					tf.setText("");
					tf.requestFocus();
				}
			}
		});
		
		// - �ݱ� ��ư Ŭ���� ����
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// - ���� ��ư ���ý� TextArea�� ������ txt���Ϸ� �޸��忡 ����
		btnSave.addActionListener(new ActionListener() {
			
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// - ������ ���� TextArea�� ���� ��������
				String msg = ta.getText();
				
				try {
					// - ��θ� ������� Dialog����
					// - frame�� �������� ���û���(������ġ)�� "����"�� �̸����� ����. 
					FileDialog fd = new FileDialog(frame,"����");
					fd.setVisible(true);
					
					// - path��ο� ���� �̸��� �����´�.
					// - getDirectory : ���û����� ��� / getFile�� �Է��� ������ �̸��� ���Ѵ�.
					String path = fd.getDirectory()+fd.getFile()+".txt";
					System.out.println(path);
					
					// - TextArea�� �ִ� ����(msg)�� �ѱ��ڶ� �ִٸ� msg�� �ش� ��ο� �����̸����� ���� 
					if(!msg.equals("")) {
						fw = new FileWriter(path);
						bw = new BufferedWriter(fw);
						bw.write(msg);
						
						// - FileDialog�� ��� ��ư�� ������ �ʰ� ���������� �����ߴٸ�... 
						if(fd.getFile()!=null) {
							JOptionPane.showMessageDialog(frame, "����Ϸ�");							
						}
						
					} else {
						// - ������ ���� ������ �õ��� ���
						// - JOptionPane(������ �Ǵ� â, �޼��� â ����)
						JOptionPane.showMessageDialog(frame, "������ �־�� ������ �����մϴ�.");
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				} finally {
					try {
						bw.close();
						fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		// ������ ���� ������
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//
		frame.setVisible(true);
	}
}
