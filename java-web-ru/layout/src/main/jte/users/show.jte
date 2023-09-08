<!-- BEGIN -->
@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
  <table class="table">
    <thead>
    <tr>
      <th scope="col">Имя Фамилия</th>
      <th scope="col">Email</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</td>
      <td>${page.getUser().getEmail()}</td>
    </tr>
    </tbody>
  </table>
`)
<!-- END -->
