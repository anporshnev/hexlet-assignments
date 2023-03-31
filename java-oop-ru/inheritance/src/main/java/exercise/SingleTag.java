package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("<" + tagName);
        attributes.forEach((name, value) -> {
            result.append(" %s=\"%s\"".formatted(name, value));
        });
        result.append(">");
        return result.toString();
    }
}
// END
