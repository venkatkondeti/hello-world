package expandString;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpandString {
	public static void main(String[] args) {
		String x = "1..5,8,11..15,18,22..25";
		Stack<Integer> stack = new Stack<Integer>();
		Matcher matcher = Pattern.compile("\\d+").matcher(x);
		while (matcher.find()) {
			System.out.println(matcher.group());
			stack.push(Integer.parseInt(matcher.group()));
		}

		StringBuffer buffer = new StringBuffer();
		int j = 0;
		for (int i = 0; i < x.length(); i++) {
			char ch = x.charAt(i);
			if (ch == ',') {
				buffer.append(stack.get(j) + ",");
				j++;
			} else if (ch == '.' && x.charAt(i + 1) == '.') {
				i++;
				
				int present = stack.get(j);
				int next = stack.get(j + 1);
				while (present != next) {
					buffer.append(present + ",");
					present++;
				}
				j++;
			}
		}
		buffer.append(stack.get(j));
		System.out.println(buffer.toString());
	}
}
