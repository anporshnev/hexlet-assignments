package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static <T, V> List<Map<T, V>> findWhere(List<Map<T, V>> books, Map<T, V> where) {
        List<Map<T, V>> result = new ArrayList<>();

        for (Map<T, V> book: books) {
            var bookSet = book.entrySet();
            var whereSet = where.entrySet();
            if (bookSet.containsAll(whereSet)) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
