package exercise;

import java.util.Map;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> data = Map.copyOf(storage.toMap());
        data.forEach((k, v) -> storage.unset(k));
        data.forEach((k, v) -> storage.set(v, k));
    }
}
// END
