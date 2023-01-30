package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static String getForwardedVariables(String cfg) {
        String[] rows = cfg.split("\n");
        return Arrays.stream(rows)
                .filter(row -> row.startsWith("environment="))
                .map(row -> row.replaceAll("environment=", ""))
                .map(row -> row.replaceAll("\"", ""))
                .map(row -> row.split(","))
                .flatMap(Arrays::stream)
                .filter(acc -> acc.startsWith("X_FORWARDED_"))
                .map(acc -> acc.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
