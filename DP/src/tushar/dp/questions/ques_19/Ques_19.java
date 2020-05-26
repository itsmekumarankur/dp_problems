package tushar.dp.questions.ques_19;
public class Ques_19 {

	static boolean dictionaryContains(String word) {
		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
				"love", "ice", "cream" };

		for (int i = 0; i < dictionary.length; i++)
			if (dictionary[i].equals(word))
				return true;
		return false;
	}

	static boolean wordBreak(String str) {
		if (str.length() == 0) {
			return true;
		}
		for (int i = 1; i <= str.length(); i++) {
			String prefix = str.substring(0, i);
			if (dictionaryContains(prefix)) {
				boolean ans = wordBreak(str.substring(i));
				if (ans) {
					return true;
				}
			}
			else {
				if (i == str.length()) {
					return false;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		boolean ans = wordBreak("sungsam");
		System.out.println(ans);
		ans = wordBreak("ilovesamsungmobile");
		System.out.println(ans);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
