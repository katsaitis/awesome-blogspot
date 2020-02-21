package com.owl.awesomeblogspot.domain.repository;


import com.owl.awesomeblogspot.domain.entity.Comment;
import com.owl.awesomeblogspot.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAll();

    Optional<Comment> findById(Long id);

    List<Comment> findByPost(Post post);
}
