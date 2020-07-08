package string.leetcode.ques_1.validators;

import string.leetcode.ques_1.NumberValidateTemplate;

public class SienceFormatValidate extends NumberValidateTemplate {

	protected boolean doValidate(String s) {
		s = s.toLowerCase();
		int pos = s.indexOf("e");
		if (pos == -1) {
			return false;
		}

		if (s.length() == 1) {
			return false;
		}

		String first = s.substring(0, pos);
		String second = s.substring(pos + 1, s.length());

		if (validatePartBeforeE(first) == false || validatePartAfterE(second) == false) {
			return false;
		}

		return true;
	}

	private boolean validatePartBeforeE(String first) {
		if (first.equals("") == true) {
			return false;
		}

		if (checkHeadAndEndForSpace(first) == false) {
			return false;
		}

		NumberValidate integerValidate = new IntegerValidate();
		NumberValidate floatValidate = new FloatValidate();
		if (integerValidate.validate(first) == false && floatValidate.validate(first) == false) {
			return false;
		}

		return true;
	}

	private boolean checkHeadAndEndForSpace(String part) {

		if (part.startsWith(" ") || part.endsWith(" ")) {
			return false;
		}

		return true;
	}

	private boolean validatePartAfterE(String second) {
		if (second.equals("") == true) {
			return false;
		}

		if (checkHeadAndEndForSpace(second) == false) {
			return false;
		}

		NumberValidate integerValidate = new IntegerValidate();
		if (integerValidate.validate(second) == false) {
			return false;
		}

		return true;
	}
}
