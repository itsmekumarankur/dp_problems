package string.leetcode.ques_1;

public class Solution {
	public boolean isNumber(String s) {
		NumberValidate nv = new NumberValidator();

		return nv.validate(s);
	}
}