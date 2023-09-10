<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(content = @`
  <form>
    <div class="mb-3">
      <input
          type="search"
          class="form-control"
          name="term"
          value="${page.getTerm()}"
      >
    </div>
    <button type="submit" class="btn btn-primary">Искать</button>
  </form>
  @if(page.getUsers().isEmpty())
    <div style="text-align: center">Нет данных</div>
  @else
    <table class="table">
      <thead>
      <tr>
        <th scope="col">Имя Фамилия</th>
        <th scope="col">Email</th>
      </tr>
      </thead>
      <tbody>

      @for(var user: page.getUsers())
        <tr>
          <td>${user.getFirstName()} ${user.getLastName()}</td>
          <td>${user.getEmail()}</td>
        </tr>
      @endfor
      </tbody>
    </table>
  @endif
`)
<!-- END -->
