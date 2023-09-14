<!-- BEGIN -->
@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

<div class="card" style="width: 50vw;">
  <div class="card-body">
    <h5 class="card-title">${page.getPost().getName()}</h5>
    <p class="card-text">${page.getPost().getBody()}</p>
    <a href="${NamedRoutes.rootPath()}" class="card-link">Back</a>
  </div>
</div>
<!-- END -->
