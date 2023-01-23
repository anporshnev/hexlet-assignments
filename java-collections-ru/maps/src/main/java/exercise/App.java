package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        var words = sentence.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();

        if (sentence.length() == 0) {
            return wordCount;
        }

        for (String word: words) {
            if (wordCount.containsKey(word)) {
                var currentCount = wordCount.get(word);
                wordCount.replace(word, currentCount + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.size() == 0) {
            return "{}";
        }
        var result = new StringJoiner("\n");
        result.add("{");
        for (var key: map.keySet()) {
            var newRow = "  %s: %s".formatted(key, map.get(key));
            result.add(newRow);
        }
        result.add("}");
        return result.toString();
    }
}
//END
