package com.review.repository;

import com.review.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {

    @Query("SELECT coalesce(avg(c.vote), 0) FROM Comment c INNER JOIN c.product as p WHERE p.id = :product_id and c.isApproved = true")
    Float getVoteAvgByProduct(@Param("product_id") int productId);

    @Query("SELECT count(c) FROM Comment c INNER JOIN c.product as p WHERE p.id = :product_id and c.isApproved = true")
    Integer getCountByProduct(@Param("product_id") int productId);

    @Query(value = "SELECT * FROM comment c join product p on c.product_fk=p.id where c.is_approved is true and p.id=:product_id order by c.creation_date limit 3", nativeQuery = true)
    List<Comment> find3TopCommentPerProduct(@Param("product_id") int productId);
}
