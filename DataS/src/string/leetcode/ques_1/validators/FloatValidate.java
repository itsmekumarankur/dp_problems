package string.leetcode.ques_1.validators;

import string.leetcode.ques_1.NumberValidateTemplate;
import string.leetcode.ques_1.NumberValidate;

public class FloatValidate extends NumberValidateTemplate {

	protected boolean doValidate(String floatVal) {
		int pos = floatVal.indexOf(".");
		if (pos == -1) {
			return false;
		}

		if (floatVal.length() == 1) {
			return false;
		}

		NumberValidate nv = new IntegerValidate();
		String first = floatVal.substring(0, pos);
		String second = floatVal.substring(pos + 1, floatVal.length());

		if (checkFirstPart(first) == true && checkFirstPart(second) == true) {
			return true;
		}

		return false;
	}

	private boolean checkFirstPart(String first) {
		if (first.equals("") == false && checkPart(first) == false) {
			return false;
		}

		return true;
	}

	private boolean checkPart(String part) {
		if (Character.isDigit(part.charAt(0)) == false || Character.isDigit(part.charAt(part.length() - 1)) == false) {
			return false;
		}

		NumberValidate nv = new IntegerValidate();
		if (nv.validate(part) == false) {
			return false;
		}

		return true;
	}
}
