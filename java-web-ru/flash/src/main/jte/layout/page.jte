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
</head>
<body>
  <div class="alert alert-success" role="alert">
      @if(page != null && page.getNotifyMessage() != null)
          ${page.getNotifyMessage()}
      @endif
  </div>

  ${content}
</body>
</html>
<!-- END -->
