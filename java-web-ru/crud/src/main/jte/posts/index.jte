<!-- BEGIN -->
@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
  @for(var post : page.getPosts())
    <div class="card" style="width: 80vw;">
      <div class="card-body">
        <h5 class="card-title">${post.getName()}</h5>
        <p class="card-text">${post.getBody()}</p>
        <a href="${NamedRoutes.postPath(post.getId())}" class="card-link">Перейти</a>
      </div>
    </div>
  @endfor
  <nav>
    <ul class="pagination">
      <li class="page-item ${page.getPageNumber() <=1 ? "disabled" : ""}">
        <a class="page-link" href="/posts/?page=${page.getPageNumber() - 1}">Previous</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="/posts/?page=${page.getPageNumber() + 1}">Next</a>
        <div></div>
      </li>
    </ul>
  </nav>
`
)
<!-- END -->
