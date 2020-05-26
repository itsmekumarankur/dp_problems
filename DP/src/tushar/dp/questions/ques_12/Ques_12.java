/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: 
{1,1,1,1},{1,1,2},{2,2},{1,3}.
 So output should be 4.
 * */
package tushar.dp.questions.ques_12;
public class Ques_12 {
	static int count(int input[], int index, int value) {
		if (value == 0)
			return 1; // very important returning 1
		if (value < 0)
			return 0;
		if (index == input.length && value >= 1)
			return 0;
		return count(input, index + 1, value) + count(input, index, value - input[index]);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		System.out.println(count(arr, 0, 5));
	}
}
