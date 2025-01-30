package exercise.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Post {
    private int userId;
    private String slug;
    private String title;
    private String body;

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
