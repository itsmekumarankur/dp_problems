package string.leetcode.ques_1.validators;

import string.leetcode.ques_1.NumberValidateTemplate;

public class HexValidate extends NumberValidateTemplate {

	private char[] valids = new char[] { 'a', 'b', 'c', 'd', 'e', 'f' };

	protected boolean doValidate(String hex) {
		hex = hex.toLowerCase();
		if (hex.startsWith("0x")) {
			hex = hex.substring(2);
		} else {
			return false;
		}

		for (int i = 0; i < hex.length(); i++) {
			if (Character.isDigit(hex.charAt(i)) != true && isValidChar(hex.charAt(i)) != true) {
				return false;
			}
		}

		return true;
	}

	private boolean isValidChar(char c) {
		for (int i = 0; i < valids.length; i++) {
			if (c == valids[i]) {
				return true;
			}
		}

		return false;
	}
}
