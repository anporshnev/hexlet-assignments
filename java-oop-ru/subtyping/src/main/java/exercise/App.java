package exercise;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var test = Map.copyOf(storage.toMap());
//        storage.toMap().forEach((k, v) -> {
//            System.out.println(k + ": " + v);
//        });
        test.forEach((k, v) -> {
            storage.set(v, k);
            storage.unset(k);
        });
//        storage.toMap().forEach((k, v) -> {
//            System.out.println(k + ": " + v);
//        });
    }
}
// END
