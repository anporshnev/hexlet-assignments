package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        if (apartments.isEmpty()) {
            return new ArrayList<>();
        }
        return apartments.stream()
                .limit(count)
                .sorted((a1, a2) -> a1.compareTo(a2))
                .map(i -> i.toString())
                .collect(Collectors.toList());
    }
}
// END
