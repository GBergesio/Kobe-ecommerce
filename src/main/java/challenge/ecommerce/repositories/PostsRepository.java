package challenge.ecommerce.repositories;

import challenge.ecommerce.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {
}
