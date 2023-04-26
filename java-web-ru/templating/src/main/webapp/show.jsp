<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- BEGIN -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Users</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous"
        >
    </head>
    <body>
       <h1 style="padding: 0 10px">${user.get("firstName")} ${user.get("lastName")}</h1>
       <div style="width: 30vw">
         <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">ID</th>
                      <th scope="col">Email</th>
                      <th scope="col"></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>${user.get("id")}</td>
                      <td>${user.get("email")}</td>
                      <td>
                        <a
                          class="btn btn-outline-danger btn-sm"
                          href='/users/delete?id=${user.get("id")}'
                          role="button"
                        >
                          Delete
                        </a>
                      </td>
                    </tr>
                  </tbody>
                </table>
       </div>
    </body>
</html>
<!-- END -->
