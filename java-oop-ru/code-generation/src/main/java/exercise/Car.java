package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public static Car deserialize(String serializeCar) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(serializeCar, Car.class);
    }
    // END
}
