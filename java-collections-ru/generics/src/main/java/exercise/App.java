package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static <T, V> List<Map<T, V>> findWhere(List<Map<T, V>> data, Map<T, V> items) {
        List<Map<T, V>> result = new ArrayList<>();

        for (Map<T, V> book: data) {
            var bookSet = book.entrySet();
            var whereSet = items.entrySet();
            if (bookSet.containsAll(whereSet)) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
