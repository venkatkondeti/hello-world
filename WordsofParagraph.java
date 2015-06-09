package wordsofparagraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordsofParagraph {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\kondeti.venkatarao\\Documents\\java.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int paraNum = 1;
		int count = 0;
		String line;
		int paraWithMaxWords = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		while ((line = bufferedReader.readLine()) != null) {
			if (line.trim().isEmpty())
				if ((line = bufferedReader.readLine()) != null) {
					if(line.isEmpty()){
						if(paraWithMaxWords<count)
							paraWithMaxWords= paraNum;
						paraNum++;
						count = 0;
						continue;
					}
				} 
				
					String[] words = line.split("\\s");
					for (String word : words) {
						if(!map.containsKey(word)){
							count++;
						}
						map.put(word, paraNum);
					}
		}
		if(paraWithMaxWords<count)
			paraWithMaxWords= paraNum;
		System.out.println(map.size());
		System.out.println("paragraph num : "+paraWithMaxWords );
	}
}
