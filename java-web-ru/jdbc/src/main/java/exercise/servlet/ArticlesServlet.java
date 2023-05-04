package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.sql.Statement;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import exercise.TemplateEngineUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class ArticlesServlet extends HttpServlet {

    private String getId(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return null;
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 1, null);
    }

    private String getAction(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return "list";
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 2, getId(request));
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String action = getAction(request);

        switch (action) {
            case "list":
                showArticles(request, response);
                break;
            default:
                showArticle(request, response);
                break;
        }
    }

    private void showArticles(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");
        // BEGIN
        final int LIMIT = 10;
        int currentPage = request.getParameter("page") == null
                ? 1
                : Integer.parseInt(request.getParameter("page"));
        int offset = currentPage == 1 ? 0 : (currentPage - 1) * LIMIT;
        float maxPageCount;
        String queryPager = "SELECT * FROM articles ORDER BY id LIMIT ? OFFSET ?";
        String queryMaxCount = "SELECT COUNT(id) FROM articles";
        List<Map<String, String>> articles = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(queryPager);
            statement.setInt(1, LIMIT);
            statement.setInt(2, offset);

            ResultSet rs = statement.executeQuery();
//            rs.first();
            while (rs.next()) {
                articles.add(Map.of(
                        "id", rs.getString("id"),
                        "title", rs.getString("title")
                ));
            }

            Statement statement1 = connection.createStatement();
            ResultSet rs1 = statement1.executeQuery(queryMaxCount);
            rs1.next();
            maxPageCount = (float) (rs1.getInt(1) + 1) / LIMIT;
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        request.setAttribute("articles", articles);
        request.setAttribute("page", currentPage);
        request.setAttribute("maxPageCount",maxPageCount);
        // END
        TemplateEngineUtil.render("articles/index.html", request, response);
    }

    private void showArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");
        // BEGIN

        int id = Integer.parseInt(getId(request));
        String query = "SELECT * FROM articles WHERE id = ?";
        Map<String, String> article;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            article = Map.of(
                    "title", rs.getString("title"),
                    "body", rs.getString("body")
            );
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        request.setAttribute("article", article);
        // END
        TemplateEngineUtil.render("articles/show.html", request, response);
    }
}
