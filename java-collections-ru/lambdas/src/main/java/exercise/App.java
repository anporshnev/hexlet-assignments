package exercise;

import java.util.Arrays;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .map(row -> Arrays.stream(row)
                        .flatMap(items -> Arrays.stream(new String[]{items, items}))
                        .toArray(String[]::new)
                )
                .flatMap(items -> Arrays.stream(new String[][]{items, items}))
                .toArray(String[][]::new);
    }
}

// END
