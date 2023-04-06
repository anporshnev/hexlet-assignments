package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        try {
            Files.writeString(path, car.serialize());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path path) {
        try {
            var content = Files.readString(path);
            return Car.deserialize(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
