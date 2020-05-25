
public class Ques_22 {
	 /* minimum cost path from (0,0) to (m, n) in mat[R][C]*/
	static int minCost(int cost[][], int m, int n) {
		if (n < 0 || m < 0)
			return Integer.MAX_VALUE;
		else if (m == 0 && n == 0)
			return cost[m][n];
		else
			return cost[m][n]
					+ Math.min(minCost(cost, m - 1, n - 1), Math.min(minCost(cost, m - 1, n), minCost(cost, m, n - 1)));
	}

	public static void main(String args[]) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		System.out.print(minCost(cost, 2, 2));
	}
}
