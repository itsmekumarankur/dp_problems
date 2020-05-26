package tushar.dp.questions.set_2.ques_17;
public class Ques_17 {
	static int longestCommonSubString(String input1, String input2, int maxSoFar) {

		if (input1.length() == 0 || input2.length() == 0) {
			return maxSoFar;
		}

		int countWhenEqual = 0;
		if (input1.charAt(0) == input2.charAt(0)) {
			countWhenEqual = longestCommonSubString(input1.substring(1), input2.substring(1), maxSoFar + 1);
		}
		int countWhenNotEqual1 = longestCommonSubString(input1, input2.substring(1), 0);
		int countWhenNotEqual2 = longestCommonSubString(input1.substring(1), input2, 0);

		return getMaxOfAll(maxSoFar, countWhenEqual, countWhenNotEqual1, countWhenNotEqual2);
	}

	static int getMaxOfAll(int a, int b, int c, int d) {
		return Math.max(a, Math.max(b, Math.max(c, d)));
	}

	public static void main(String[] args) {
		int ans = longestCommonSubString("abcdesop0", "lcdesolokpoabcdeso", 0);
		System.out.println(ans);
	}
}
