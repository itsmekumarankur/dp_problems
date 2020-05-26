package tushar.dp.questions.ques_3;
public class Ques_3 {
	static int MatrixChainOrder(int input[], int start, int end) {
		if (start == end)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int k = start + 1; k < end; k++) {
			int count = MatrixChainOrder(input, start, k) + MatrixChainOrder(input, k + 1, end)
					+ input[start - 1] * input[k] * input[end];

			if (count < min)
				min = count;
		}
		return min;
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int arr[] = new int[] { 1, 2, 3, 4, 3 };
		int n = arr.length;

		System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, 1, n - 1));

	}
}
