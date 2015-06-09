package StringCompress;

public class StringCompress {
	public String stringCompress(String str) {
		if (str == null || str.isEmpty())
			return str;
		char last = str.charAt(0);
		int count = 1;
		StringBuffer sb = new StringBuffer();
		for (int pass = 1; pass < str.length(); pass++) {
			if (str.charAt(pass) == last) {
				count++;
			} else {
				sb.append(last);
				sb.append(count);
				last = str.charAt(pass);
				count = 1;
			}
		}
		sb.append(last);
		sb.append(count);
		if (sb.toString().length() < str.length()) {
			return sb.toString();
		} else {
			return str;
		}
	}

	public static void main(String[] args) {
		StringCompress compress = new StringCompress();
		System.out.println(compress.stringCompress("aaabcccccddd"));
		System.out.println(compress.stringCompress("abcd"));
	}
}
