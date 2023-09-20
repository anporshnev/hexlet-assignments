package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import java.util.Collections;
import java.util.zip.CheckedInputStream;

import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }
    // BEGIN
    public static void show(Context ctx) {
        var token = ctx.cookie("auth");
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));

        if (token != null && token.equals(user.getToken())) {
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }

    public static void register(Context ctx) {
        var firstName = StringUtils.capitalize(ctx.formParam("firstName"));
        var lastName =StringUtils.capitalize(ctx.formParam("lastName"));
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var token = Security.generateToken();

        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        ctx.cookie("auth", token);

        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }
    // END
}
