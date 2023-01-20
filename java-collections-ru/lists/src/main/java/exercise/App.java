package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String chars, String word) {
        var charsToLower = chars.toLowerCase();
        var wordToLower = word.toLowerCase();
        List<String> charsList = new ArrayList<>(Arrays.asList(charsToLower.split("")));
        List<String> lettersList = new ArrayList<>(Arrays.asList(wordToLower.split("")));

        for (var letter: lettersList) {
            if (charsList.contains(letter)) {
                charsList.remove(letter);
            } else {
                return false;
            }
        }
        return true;
    }
}

//END
