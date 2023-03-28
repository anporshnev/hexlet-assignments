package exercise;

import java.util.Map;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var test = Map.copyOf(storage.toMap());
        test.forEach((k, v) -> storage.unset(k));
        test.forEach((k, v) -> storage.set(v, k));
    }
}
// END
