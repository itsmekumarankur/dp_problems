package string.leetcode.ques_1.validators;

import string.leetcode.ques_1.NumberValidateTemplate;

public class IntegerValidate extends NumberValidateTemplate {

	protected boolean doValidate(String integer) {
		for (int i = 0; i < integer.length(); i++) {
			if (Character.isDigit(integer.charAt(i)) == false) {
				return false;
			}
		}

		return true;
	}
}