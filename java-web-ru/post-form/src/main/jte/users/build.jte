<!-- BEGIN -->
@template.layout.page (
  content = @`
  <div class="mb-3">Зарегистрировать нового пользователя</div>
  <form action="/users" method="post">
    <div class="mb-3">
      <label for="firstName" class="form-label">Имя</label>
      <input type="text" name="firstName" required class="form-control" id="firstName">
    </div>
    <div class="mb-3">
      <label for="lastName" class="form-label">Фамилия</label>
      <input type="text" name="lastName" required class="form-control" id="lastName">
    </div>
    <div class="mb-3">
      <label for="email" class="form-label">Email</label>
      <input type="email" name="email" required class="form-control" id="email">
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">Пароль</label>
      <input type="password" name="password" required class="form-control" id="password">
    </div>
    <button type="submit" class="btn btn-primary">Создать</button>
  </form>
  `
)
<!-- END -->
