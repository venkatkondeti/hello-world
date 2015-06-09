package wordsofparagraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class WordsOfParagraphWithMap {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\kondeti.venkatarao\\Documents\\java.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int paraNum = 1;
		int count = 0;
		String line;
		int paragraphWithMaxWords = 0;
		int maxWords = 0;
		
		Map<String, Integer> map = new HashMap<String, Integer>();

		while ((line = bufferedReader.readLine()) != null) {
			if (line.trim().isEmpty()) {
				continue;
			} else {
				break;
			}
		}

		do {
			if (line != null) {

				if (line.trim().isEmpty()) {
					if (maxWords < count) {
						paragraphWithMaxWords = paraNum;
						maxWords = count;
					}
					paraNum++;
					count = 0;
					while ((line = bufferedReader.readLine()) != null) {
						if (line.trim().isEmpty()) {
							continue;
						} else {
							break;
						}
					}
				}

				String[] words = line.split("\\s");
				for (String word : words) {
					if (!map.containsKey(word)) {
						count++;
					} else {
						int paraNumber = map.get(word);
						if (paraNumber != paraNum) {
							count++;
						}
					}
					map.put(word, paraNum);
				}
			}
		} while ((line = bufferedReader.readLine()) != null);

		if (maxWords < count){
			paragraphWithMaxWords = paraNum;
			maxWords = count;
		}

		System.out.println(map.size());
		System.out.println("paragraph num : " + paragraphWithMaxWords);
		
		if (map.size() == maxWords)
			System.out.println("paragraph num : " + paragraphWithMaxWords);
		else
			System.out.println("no such paragraph");
	}
}
