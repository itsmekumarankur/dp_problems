public class Ques_12 {
	static int count(int input[], int index, int value) {
		if (value == 0)
			return 1;
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
