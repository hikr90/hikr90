package ex3_frame_test;
/* 버튼 이벤트 등록자
 * Button : addActionListener
 * CheckBox : addItemListener
 * TextField, TextArea : addTextListener
 * 우상단 버튼 : addWindowListener
 * 키보드 입력 감지 : addKeyListener*/
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
		Frame frame = new Frame("문장 입력기");
		frame.setBounds(500, 200, 250, 400);
		frame.setBackground(Color.CYAN);
		
		// PLAIN : 일반
		Font font = new Font(Font.SANS_SERIF,Font.PLAIN,18);
		
		// 북쪽단 ---------------------
		// - 여러개의 컴포넌트(버튼)를 묶어서 한번에 관리하는 클래스 (기본 속성이 FlowLayout)
		Panel pNorth = new Panel();
		pNorth.setBackground(Color.GREEN);
		
		// - 텍스트 필드안에서 키보드 입력값을 받을 수 있게하는 클래스
		// - ()안의 숫자는 입력상자의 길이를 뜻한다. 
		TextField tf = new TextField(10);
		
		Button btn = new Button("입력");
		
		// - 버튼 비활성화
		// - 숫자가 입력되었을 때, true로 바꾸는 형식으로 많이 사용한다. 
		btn.setEnabled(false);
		
		// - pNorth의 패널에 플로우 레이아웃으로 tf와 버튼이 붙게된다.
		pNorth.add(tf);
		pNorth.add(btn);
		pNorth.setFont(font);
		
		// - 프레임에 넣어준다.
		// - 북쪽 방향을 BorderLayout으로 넣어줄 수 있다.
		// - (패널로 한꺼번에 묶어서 위치 지정해서 프레임에 넣어주는 방법)
		frame.add(pNorth,BorderLayout.NORTH);
		
		
		// 중앙단 ---------------------
		// - TextFiled는 짧은 문장
		// - TextArea는 긴 문장
		// - 행과 열의 수는 세로 길이와 가로 길이를 뜻하는데 어차피 중앙에 꽉 채워서 들어가니 0으로 처리해도 상관없다.
		// - TextArea.SCROLLBARS_VERTICAL_ONLY : 스크롤 세로만 존재
		TextArea ta = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setBackground(Color.LIGHT_GRAY);
		ta.setFont(font);
		
		// - ta에 값을 입력할 수 없도록 비활성화
		ta.setEditable(false);
		//
		frame.add(ta);
		

		// 남쪽단 ---------------------
		Panel pSouth = new Panel();
		pSouth.setBackground(Color.MAGENTA);
		
		Button btnSave = new Button("저장");
		Button btnClose = new Button("종료");
		
		pSouth.add(btnSave);
		pSouth.add(btnClose);
		
		frame.add(pSouth,BorderLayout.SOUTH);
		
		// - 프레임의 사이즈를 고정시키는 방법
		frame.setResizable(false);
		
		// - TextField에 값이 들어온 경우 입력 버튼을 활성화
		tf.addTextListener(new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent e) {
				// - tf에 쓰여져있는 내용을 가져오는 것이 getText이다.
				// - 공백을 제외한 값이 있는 경우 입력 버튼 활성화 
				if(tf.getText().trim().equals("")) {
					btn.setEnabled(false);
				}else {
					btn.setEnabled(true);
				}
			}
		});
		
		// - 입력 버튼을 클릭시 TextArea에 내용을 추가한다.
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// - ta에 값을 추가하는 방법
				ta.append(tf.getText().trim()+"\n");
				
				// - 텍스트 필드를 비운 후 포커스 이동
				tf.setText("");
				// - 한번 값을 입력하면 커서가 넘어간다. (입력한 값이 입력 공간에서 초기화)
				tf.requestFocus();
			}
		});
		
		
		// - 엔터값을 입력할 시, 입력버튼과 같은 기능을 하도록 처리
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
		
		// - 닫기 버튼 클릭시 종료
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// - 저장 버튼 선택시 TextArea의 내용을 txt파일로 메모장에 저장
		btnSave.addActionListener(new ActionListener() {
			
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// - 저장을 위한 TextArea의 값을 가져오자
				String msg = ta.getText();
				
				try {
					// - 경로를 잡기위한 Dialog생성
					// - frame을 기준으로 선택상자(저장위치)를 "저장"의 이름으로 띄운다. 
					FileDialog fd = new FileDialog(frame,"저장");
					fd.setVisible(true);
					
					// - path경로와 파일 이름을 가져온다.
					// - getDirectory : 선택상자의 경로 / getFile은 입력한 파일의 이름을 뜻한다.
					String path = fd.getDirectory()+fd.getFile()+".txt";
					System.out.println(path);
					
					// - TextArea에 있는 내용(msg)에 한글자라도 있다면 msg를 해당 경로에 문서이름으로 저장 
					if(!msg.equals("")) {
						fw = new FileWriter(path);
						bw = new BufferedWriter(fw);
						bw.write(msg);
						
						// - FileDialog의 취소 버튼을 누르지 않고 정상적으로 저장했다면... 
						if(fd.getFile()!=null) {
							JOptionPane.showMessageDialog(frame, "저장완료");							
						}
						
					} else {
						// - 내용이 없이 저장을 시도할 경우
						// - JOptionPane(기준이 되는 창, 메세지 창 내용)
						JOptionPane.showMessageDialog(frame, "내용이 있어야 저장이 가능합니다.");
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
		
		// 프레임 우상단 관리자
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
