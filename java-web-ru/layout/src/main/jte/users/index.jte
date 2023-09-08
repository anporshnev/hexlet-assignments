<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(content = @`
  <table class="table">
    <thead>
    <tr>
      <th scope="col">Имя Фамилия</th>
      <th scope="col">Email</th>
      <th scope="col">#</th>
    </tr>
    </thead>
    <tbody>
    @for(var user: page.getUsers())
      <tr>
        <td>${user.getFirstName()} ${user.getLastName()}</td>
        <td>${user.getEmail()}</td>
        <td>
          <a href="/users/${user.getId()}">Перейти</a>
        </td>
      </tr>
    @endfor
    </tbody>
  </table>
`)
<!-- END -->
