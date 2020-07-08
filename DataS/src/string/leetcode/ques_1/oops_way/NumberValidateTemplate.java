package string.leetcode.ques_1.oops_way;



public abstract class NumberValidateTemplate implements NumberValidate {

	public boolean validate(String s) {
		if (checkStringEmpty(s)) {
			return false;
		}

		s = checkAndProcessHeader(s);

		if (s.length() == 0) {
			return false;
		}

		return doValidate(s);
	}

	private boolean checkStringEmpty(String s) {
		if (s.equals("")) {
			return true;
		}

		return false;
	}

	private String checkAndProcessHeader(String value) {
		value = value.trim();

		if (value.startsWith("+") || value.startsWith("-")) {
			value = value.substring(1);
		}

		return value;
	}

	protected abstract boolean doValidate(String s);
}
