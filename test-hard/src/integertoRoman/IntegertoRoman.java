package integertoRoman;

import java.util.ArrayList;
import java.util.List;

public class IntegertoRoman {

	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			if (num >= 1000) {
				sb.append('M');
				num = num - 1000;
				continue;
			} else if (num >= 900) {
				sb.append('C');
				sb.append('M');
				num -= 900;
				continue;
			} else if (num >= 500) {
				sb.append('D');
				num -= 500;
				continue;
			} else if (num >= 400) {
				sb.append('C');
				sb.append('D');
				num -= 400;
				continue;
			} else if (num >= 100) {
				sb.append('C');
				num -= 100;
				continue;
			} else if (num >= 90) {
				sb.append('X');
				sb.append('C');
				num -= 90;
				continue;
			} else if (num >= 50) {
				sb.append('L');
				num -= 50;
				continue;
			} else if (num >= 40) {
				sb.append('X');
				sb.append('L');
				num -= 40;
				continue;
			} else if (num >= 10) {
				sb.append('X');
				num -= 10;
				continue;
			} else if (num == 9) {
				sb.append('I');
				sb.append('X');
				num -= 9;
				continue;
			} else if (num >= 5) {
				sb.append('V');
				num -= 5;
				continue;
			} else if (num == 4) {
				sb.append('I');
				sb.append('V');
				num -= 4;
				continue;
			} else {
				sb.append('I');
				num--;
			}
		}
		return sb.toString();
	}
}