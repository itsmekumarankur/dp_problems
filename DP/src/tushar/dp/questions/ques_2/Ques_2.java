package tushar.dp.questions.ques_2;
public class Ques_2 {

	static int longestCommonSubSequence(String str1, String str2) {
		if (str1.length() == 0 || str2.length() == 0)
			return 0;
		if (str1.charAt(0) == str2.charAt(0))
			return 1 + longestCommonSubSequence(str1.substring(1), str2.substring(1));
		else
			return Math.max(longestCommonSubSequence(str1.substring(1), str2), longestCommonSubSequence(str1, str2.substring(1)));
	}
	
	public static void main(String[] args) {
		int ans = longestCommonSubSequence("abcdreqt","rqtabcd");
		System.out.println(ans);
	}
}
