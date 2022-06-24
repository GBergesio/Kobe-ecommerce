package challenge.ecommerce.repositories;

import challenge.ecommerce.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PostsRepository extends JpaRepository<Post, Long> {
}
