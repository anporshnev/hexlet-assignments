package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {

    private final List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Post> index(@PathVariable Integer id) {
        return posts.stream()
                .filter(p -> p.getUserId() == id)
                .toList();
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Post create(@PathVariable Integer id, @RequestBody Post data) {
        var newPost = new Post();
        newPost.setUserId(id);
        newPost.setTitle(data.getTitle());
        newPost.setSlug(data.getSlug());
        newPost.setBody(data.getBody());
        posts.add(newPost);
        return newPost;
    }
}
// END
