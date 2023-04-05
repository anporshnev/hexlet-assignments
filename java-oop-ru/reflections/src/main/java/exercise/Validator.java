package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> invalid = new ArrayList<>();

        for (Field field: address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            try {
                field.setAccessible(true);
                if (notNull != null && field.get(address) == null) {
                    invalid.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return invalid;
    }

    public static Map<String, List> advancedValidate(Address address) {
        Map<String, List> invalid = new HashMap<>();

        for (Field field: address.getClass().getDeclaredFields()) {
            List<String> errors = new ArrayList<>();

            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLength = field.getAnnotation(MinLength.class);

            try {
                field.setAccessible(true);
                var fieldValue = field.get(address);

                if (notNull != null && fieldValue == null) {
                    errors.add("can not be null");
                } else if (minLength != null && String.valueOf(fieldValue).length() < minLength.minLength()) {
                    errors.add("length less than " + minLength.minLength());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (errors.size() > 0) {
                invalid.put(field.getName(), errors);
            }
        }
        return invalid;
    }
}
// END
