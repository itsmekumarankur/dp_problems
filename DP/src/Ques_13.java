public class Ques_13 {

	static int eggDrop(int eggs, int floor) {
		if (floor == 1 || floor == 0)
			return floor;
		if (eggs == 1)
			return floor;

		int min = Integer.MAX_VALUE;
		int x, res;
		for (x = 1; x <= floor; x++) {
			res = Math.max(eggDrop(eggs - 1, x - 1), eggDrop(eggs, floor - x));
			if (res < min)
				min = res;
		}
		return min + 1;
	}

	public static void main(String args[]) {
		int n = 2, k = 10;
		System.out.print("Minimum number of " + "trials in worst case with " + n + " eggs and " + k + " floors is "
				+ eggDrop(n, k));
	}
}
