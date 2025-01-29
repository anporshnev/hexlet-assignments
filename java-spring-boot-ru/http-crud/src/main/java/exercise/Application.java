package exercise;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.Post;

@SpringBootApplication
@RestController
@RequestMapping("/posts")
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping
    public List<Post> index(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {
        int fromIndex = (page - 1) * limit;
        int toIndex = Math.min(fromIndex + limit, posts.size());
        return posts.subList(fromIndex, toIndex);
    }

    @GetMapping("/{id}")
    public Optional<Post> show(@PathVariable String id) {
        return posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable String id, @RequestBody Post data) {
        var updatedPost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (updatedPost.isPresent()) {
            var post = updatedPost.get();
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
        }
        return data;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
    // END
}
