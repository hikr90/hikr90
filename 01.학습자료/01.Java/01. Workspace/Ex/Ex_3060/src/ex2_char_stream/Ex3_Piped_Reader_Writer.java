package ex2_char_stream;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class Ex3_Piped_Reader_Writer {
	public static void main(String[] args) {
		/*	PipedReader & PipedWriter
		 * 		- 쓰레드 간 데이터를 주고 받을 때 사용하는 문자 기반 스트림
		 * 		- 입력과 출력 스트림을 하나의 스트림으로 연결하여 데이터를 주고 받는다.
		 * 		- 스트림 생성 뒤에 어느 한쪽의 스트림에서 connect()를 호출하여 입력과 출력 스트림을 연결한다.
		 * 		- 전송 후에는 어느 한쪽의 스트림만 닫아도 나머지 스트림은 자동으로 닫힌다.
		 */
		InputThread it = new InputThread("it");
		OutputThread ot = new OutputThread("ot");
		
		// piped reader, writer 연결
		it.connect(ot.getOutput());
		
		it.start();
		ot.start();
	}
}

//
class InputThread extends Thread {
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();
	
	public InputThread(String name) {
		super(name);
	}
	
	public void run() {
		try {
			int data = 0;
			
			while ((data=input.read()) != -1) {
				sw.write(data);
			}
			System.out.println("getName : " + getName() + " / received : " + sw.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public PipedReader getInput() {
		return input;
	}
	
	public void connect(PipedWriter output) {
		try {
			input.connect(output);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

//
class OutputThread extends Thread {
	PipedWriter output = new PipedWriter();
	
	public OutputThread(String name) {
		super(name);
	}
	
	public void run() {
		try {
			String msg = "Hello";
			System.out.println(getName() + " sent : " + msg);
			output.write(msg);
			output.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public PipedWriter getOutput() {
		return output;
	}
	
	public void connect(PipedReader input) {
		try {
			output.connect(input);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}