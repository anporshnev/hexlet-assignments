@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
page = page,
content = @`
	<div>
		<div class="mb-3">
			<a href="${NamedRoutes.buildPostPath()}">Создать новый пост</a>
		</div>
		@for(var post : page.getPosts())
			<div class="card mb-2" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title">${post.getName()}</h5>
					<p class="card-text">${post.getBody()}</p>
				</div>
			</div>
		@endfor

	</div>


`
)
