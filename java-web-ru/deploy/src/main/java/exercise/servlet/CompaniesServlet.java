package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        var queryString = request.getQueryString();
        PrintWriter pw = response.getWriter();
        List<String> companies = getCompanies();

        if (queryString == null) {
            companies.forEach(company -> pw.write(company + "\n"));
        } else {
            if (request.getQueryString().contains("search")) {
                var filteredCompanies = companies.stream()
                        .filter(company -> company.contains(request.getParameter("search")))
                        .toList();
                if (filteredCompanies.isEmpty()) {
                    pw.write("Companies not found");
                } else {
                    filteredCompanies.forEach(filteredCompany -> pw.write(filteredCompany + "\n"));
                }
            }
        }
        pw.close();
        // END
    }
}
