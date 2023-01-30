package exercise;

import java.util.StringJoiner;

// BEGIN
class App {
    private static final String TARGET_VARIABLE = "X_FORWARDED_";

    public static String getForwardedVariables(String cfg) {
        String[] arr = cfg.split("\n");
        StringJoiner result = new StringJoiner(",");
        for (String item: arr) {
            if (item.startsWith("environment")) {
                var str = item.replaceAll("environment=\"", "");
                var str1 = str.split(",");
                for (String word: str1) {
                    if (word.startsWith("X_FORWARDED_")) {
                        var res = word.replaceAll("X_FORWARDED_", "");
                        result.add(res.replaceAll("\"", ""));
                    }
                }
            }
        }
        return result.toString();
    }
}
//END
