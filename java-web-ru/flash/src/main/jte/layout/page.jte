@import gg.jte.Content
@import exercise.dto.BasePage
@param Content content
@param BasePage page = null


<!-- BEGIN -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Hexlet Javalin Example</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
</head>
<body>
  @if(page != null && page.getNotifyMessage() != null)
      <div class="alert alert-success" role="alert">
          ${page.getNotifyMessage()}
      </div>
  @endif
  <div class="mx-auto p-4 py-md-5">
      ${content}
  </div>
</body>
</html>
<!-- END -->
