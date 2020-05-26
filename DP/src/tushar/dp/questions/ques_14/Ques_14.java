package tushar.dp.questions.ques_14;
public class Ques_14 {

	/*
	 * 1- If there were no stars the problem very easy 
	 * 2- When a star present, #
	 * check many different suffixes of the text and see if they match the rest of
	 * the pattern.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Examples:
	 * .*cat
	         	cat	
                9393cat	
                the old cat
	 */
	static boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty())
			return text.isEmpty();
	
		boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		//the second char of pattern is "*"
		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
		} else {
			//the second char of pattern is not "*"
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}

	static boolean match_Alternate(String text, String pattern) {
		System.out.println(text+"   "+pattern);
		if (pattern.isEmpty())
			return text.isEmpty();
		if (text.length() == 0 && pattern.length() > 1 && pattern.charAt(0) == '*' ) {
			return false;
		}

		if ((pattern.length() > 1 && pattern.charAt(0) == '.')
				|| (pattern.length() != 0 && text.length() != 0 && pattern.charAt(0) == text.charAt(0))) {
			return match_Alternate(text.substring(1), pattern.substring(1));
		}

		if (pattern.length() > 0 && pattern.charAt(0) == '*') {
			return match_Alternate( text, pattern.substring(2)) || match_Alternate( text.substring(1), pattern);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Text  Pattern");
		System.out.println(match_Alternate("aa", "a")); // false
		System.out.println(match_Alternate("aa", "a*"));// true
		System.out.println(match_Alternate("ab", ".*"));// true
		System.out.println(match_Alternate("aab", "c*a*b"));// true
		System.out.println(match_Alternate("mississippi", "mis*is*p*.")); // false
	}
}


/*
 * 
 * First of all, this is one of the most difficulty problems. 
 * It is hard to think through all different cases. 
 * The problem should be simplified to handle 2 basic cases:
		the second char of pattern is "*"
		the second char of pattern is not "*"
	# For the 1st case, 
	if (the first char of pattern is not "."){
	  the first char of pattern and string should be the same. 
	  Then continue to match the remaining part.
	}

	# For the 2nd case, 
	if (the first char of pattern is "." or first char of pattern == the first i char of string) 
		continue to match the remaining part.
 * 
 * */
