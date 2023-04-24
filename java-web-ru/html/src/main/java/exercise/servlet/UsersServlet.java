package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {
    private final String START_HTML = """
            <!DOCTYPE html>
            <html lang=\"ru\">
              <head>
                <meta charset=\"UTF-8\">
                <title>Example application | Users</title>
                <link rel=\"stylesheet\" 
                      href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
                      integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" 
                      crossorigin=\"anonymous\">
              </head>
              <body>
            """;
    private final String END_HTML = """
              </body>
            </html>
            """;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<Map<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        ObjectMapper mapper = new ObjectMapper();
        Path path = Path.of("src/main/resources/users.json").toAbsolutePath();
        String content = Files.readString(path);
        return mapper.readValue(content, new TypeReference<>() { });
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        StringBuilder resultHtml = new StringBuilder(START_HTML);
        resultHtml.append("<div class=\"list-group\">");
        getUsers().forEach(user -> {
            String template = "<a href=\"/users/%s\" class=\"list-group-item list-group-item-action\">%s %s</a>";
            resultHtml.append(template.formatted(user.get("id"), user.get("firstName"), user.get("lastName")));
        });
        resultHtml.append("</div>");
        resultHtml.append(END_HTML);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(resultHtml.toString());
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        List filteredUsers = getUsers().stream().filter(user -> user.get("id").equals(id)).toList();

        if (filteredUsers.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        StringBuilder resultHtml = new StringBuilder(START_HTML);
        resultHtml.append("""
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">ID</th>
                      <th scope="col">FirstName</th>
                      <th scope="col">LastName</th>
                      <th scope="col">Email</th>
                    </tr>
                  </thead>
                  <tbody>
                """);
        var rowTemplate = """
                <tr>
                  <th scope="row">%s</th>
                  <td>%s</td>
                  <td>%s</td>
                  <td>%s</td>
                </tr>
                """;

        var currentUser = (Map) filteredUsers.get(0);
        resultHtml.append(rowTemplate.formatted(
                currentUser.get("id"),
                currentUser.get("firstName"),
                currentUser.get("lastName"),
                currentUser.get("email")));
        resultHtml.append("""
                  </tbody>
                </table>
                """);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(resultHtml.toString());
        // END
    }
}
