package tushar.dp.questions.set_3.ques_25;
public class Ques_25 {

	public static boolean isPalindrome(String X, int i, int j) {
		while (i <= j) {
			if (X.charAt(i++) != X.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	public static int minPalinPartition(String X, int start, int end) {
		if (start == end || isPalindrome(X, start, end)) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = start; k < end; k++) {
			int count = 1 + minPalinPartition(X, start, k) + minPalinPartition(X, k + 1, end);

			if (count < min)
				min = count;
		}

		return min;
	}

	public static void main(String[] args) {
		String X = "amnnmarrtuvuty";
		System.out.print("The minimum cuts required are " + minPalinPartition(X, 0, X.length() - 1));
	}

}