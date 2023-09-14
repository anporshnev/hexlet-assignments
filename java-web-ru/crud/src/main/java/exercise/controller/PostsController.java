package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import exercise.util.Generator;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {
    private static final int POSTS_LIMIT = 5;

    // BEGIN
    public static void index(Context ctx) {
        var pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var posts = PostRepository.getEntities();

        var offset = (pageNumber - 1) * POSTS_LIMIT;
        List<Post> sliceOfPosts = posts.subList(offset, offset + POSTS_LIMIT);
        var page = new PostsPage(sliceOfPosts, pageNumber);

        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);

        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
