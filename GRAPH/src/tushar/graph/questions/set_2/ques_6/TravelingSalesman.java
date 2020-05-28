package tushar.graph.questions.set_2.ques_6;

/**
 * https://www.youtube.com/watch?v=JE0JE8ce1V0&t=539s
 */
public class TravelingSalesman {

	static int INT_MAX = 999999;

	static int n = 4;
	static int dist[][] = { { 0, 20, 42, 25 }, { 20, 0, 30, 34 }, { 42, 30, 0, 10 }, { 25, 34, 10, 0 } };
	static int VISITED_ALL = (1 << n) - 1;

	static int dp[][] = new int[16][4];

	static int tsp(int mask, int pos) {

		if (mask == VISITED_ALL) {
			return dist[pos][0];
		}
		if (dp[mask][pos] != -1) {
			return dp[mask][pos];
		}

		// Now from current node, we will try to go to every other node and take the min
		// ans
		int ans = INT_MAX;

		// Visit all the unvisited cities and take the best route
		for (int city = 0; city < n; city++) {

			if ((mask & (1 << city)) == 0) {

				int newAns = dist[pos][city] + tsp(mask | (1 << city), city);
				ans = Math.min(ans, newAns);
			}
		}

		return dp[mask][pos] = ans;
	}

	public static void main(String[] args) {

		for (int i = 0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println("Travelling Saleman Distance is " + tsp(1, 0));

	}

}
