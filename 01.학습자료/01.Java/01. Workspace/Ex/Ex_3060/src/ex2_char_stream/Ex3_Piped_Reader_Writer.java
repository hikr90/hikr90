package ex2_char_stream;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class Ex3_Piped_Reader_Writer {
	public static void main(String[] args) {
		/*	PipedReader & PipedWriter
		 * 		- ������ �� �����͸� �ְ� ���� �� ����ϴ� ���� ��� ��Ʈ��
		 * 		- �Է°� ��� ��Ʈ���� �ϳ��� ��Ʈ������ �����Ͽ� �����͸� �ְ� �޴´�.
		 * 		- ��Ʈ�� ���� �ڿ� ��� ������ ��Ʈ������ connect()�� ȣ���Ͽ� �Է°� ��� ��Ʈ���� �����Ѵ�.
		 * 		- ���� �Ŀ��� ��� ������ ��Ʈ���� �ݾƵ� ������ ��Ʈ���� �ڵ����� ������.
		 */
		InputThread it = new InputThread("it");
		OutputThread ot = new OutputThread("ot");
		
		// piped reader, writer ����
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