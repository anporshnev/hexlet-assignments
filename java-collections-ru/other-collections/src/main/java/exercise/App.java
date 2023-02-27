package exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App {
    public static LinkedHashMap<String, Object> genDiff(HashMap<String, Object> map1, HashMap<String, Object> map2) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        Set<String> joined = Stream.of(map1, map2)
                .flatMap(m -> m.keySet().stream())
                .collect(Collectors.toSet());
        for (String item: joined) {
            if (map1.containsKey(item) && map2.containsKey(item)) {
                if (map1.get(item).equals(map2.get(item))) {
                    result.put(item, "unchanged");
                } else {
                    result.put(item, "changed");
                }
            } else if (map1.containsKey(item)) {
                result.put(item, "deleted");
            } else {
                result.put(item, "added");
            }
        }
        return result;
    }
}
//END
