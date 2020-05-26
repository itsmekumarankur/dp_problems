/*
 * Find minimum number of coins that make a given value
Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, 
what is the minimum number of coins to make the change?
 * */
public class Ques_11 {

	static int minCoins(int coins[], int V) {
		if (V == 0)
			return 0;

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= V) {
				int sub_res = minCoins(coins, V - coins[i]);
				if (sub_res != Integer.MAX_VALUE && sub_res < res)
					res = sub_res;
			}
		}
		return res+1;
	}

	public static void main(String args[]) {
		int coins[] = { 9, 6, 5, 1 };
		System.out.println("Minimum coins required is " + minCoins(coins, 11));
	}
}