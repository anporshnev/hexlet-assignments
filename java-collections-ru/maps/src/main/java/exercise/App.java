package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        var words = sentence.split(" ");
        Map<String, Integer> map = new HashMap<>();

        if (sentence.length() == 0) {
            return map;
        }

        for (String word: words) {
            var wordCount = map.getOrDefault(word, 0);
            wordCount +=1;
            map.put(word, wordCount);
        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
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
