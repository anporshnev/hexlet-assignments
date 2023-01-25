package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    List<Integer> numbers;

    @BeforeEach
    void initNumbers() {
        this.numbers = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Test
    void testTake() {
        // BEGIN
        List<Integer> actual = Arrays.asList(1, 2, 3);
        List<Integer> expected = App.take(numbers, 3);
        assertThat(actual).isEqualTo(expected);

        List<Integer> actual1 = new ArrayList<>();
        List<Integer> expected1 = App.take(actual1, 3);
        assertThat(actual1).isEqualTo(expected1);

        List<Integer> expected2 = App.take(numbers, 7);
        assertThat(numbers).isEqualTo(expected2);
        // END


    }
}
