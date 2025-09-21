package ex2_format;

import java.text.ChoiceFormat;

public class Ex3_Choice_Format {
	public static void main(String[] args) {
		//
		double [] limit = {60, 70, 80, 90};
		String [] grade = {"D", "C", "B", "A"};
		int [] score = {95, 88, 75, 52, 60, 71};
		
		// 특정 범위 안의 값을 문자열로 변환
		ChoiceFormat cf = new ChoiceFormat(limit, grade);
		
		for(int i=0; i<score.length; i++) {
			System.out.println(score[i] + " : " + cf.format(score[i]));
		}
	}
}
