package ex1_byte_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex4_Byte_Array_Stream {
	public static void main(String[] args) {
		/*	ByteArrayStream
		 * 		- 바이트 배열(메모리)에 데이터를 입출력하는데 사용되는 스트림
		 * 		- 주로 다른 곳에 입출력하기 전에 데이터를 임시로 바이트 배열에 담아서 변환 등의 작업을 하는데 사용된다.
		 */
		byte [] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte [] outSrc = null;
		byte [] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		try {
			//
			while (input.available() > 0) {
				int len = input.read(temp);		// 읽어온 데이터의 개수를 반환
				output.write(temp, 0, len); 	// 읽어온만큼만 쓴다.
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//
		outSrc = output.toByteArray();
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Temp : " + Arrays.toString(temp));
		System.out.println("Output Source : " +  Arrays.toString(outSrc));

	}
}
