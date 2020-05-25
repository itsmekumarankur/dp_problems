public class Ques_1 {

	public static int knapsack_01(int[] weight, int value[], int maxWeight, int index) {
		if (index == weight.length || maxWeight == 0) {
			return 0;
		}
		if (weight[index] > maxWeight) {
			return knapsack_01(weight, value, maxWeight, index + 1);

		}
		int x = knapsack_01(weight, value, maxWeight - weight[index], index + 1) + value[index];
		int y = knapsack_01(weight, value, maxWeight, index + 1);

		return Math.max(x, y);

	}
}