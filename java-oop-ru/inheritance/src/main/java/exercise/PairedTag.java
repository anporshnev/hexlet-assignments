package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> children;

    public PairedTag(
            String tagName,
            Map<String, String> attributes,
            String tagBody,
            List<Tag> children
    ) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(new SingleTag(tagName, attributes));
        children.forEach((item) -> {
            result.append(item.toString());
        });
        result.append(tagBody);
        result.append("</" + tagName + ">");
        return result.toString();
    }
}
// END
