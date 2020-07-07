package string.leetcode.ques_1;
import java.util.ArrayList;

import string.leetcode.ques_1.validators.FloatValidate;
import string.leetcode.ques_1.validators.HexValidate;
import string.leetcode.ques_1.validators.IntegerValidate;
import string.leetcode.ques_1.validators.SienceFormatValidate;
class NumberValidator implements NumberValidate {

	private ArrayList<NumberValidate> validators = new ArrayList<NumberValidate>();

	public NumberValidator() {
		addValidators();
	}

	private void addValidators() {
		validators.add(new IntegerValidate());
		validators.add(new FloatValidate());
		validators.add(new HexValidate());
		validators.add(new SienceFormatValidate());
	}

	@Override
	public boolean validate(String s) {
		for (NumberValidate nv : validators) {
			if (nv.validate(s) == true) {
				return true;
			}
		}

		return false;
	}

}