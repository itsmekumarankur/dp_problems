package tushar.dp.questions.set_2.ques_13;
public class Ques_13 {

	/*
	 * Must Watch, very imp question
	 * https://www.youtube.com/watch?v=S49zeUjeUL0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=43
	*/
	static int eggDrop(int eggs, int floor) {
		if (floor == 1 || floor == 0)
			return floor;
		if (eggs == 1)
			return floor;

		int min = Integer.MAX_VALUE;
		int  res;
		for (int k = 1; k <= floor; k++) {
			res = Math.max(eggDrop(eggs - 1, k - 1), eggDrop(eggs, floor - k));
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
