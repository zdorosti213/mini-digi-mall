package com.review.dto;

import com.review.model.Comment;
import com.review.model.Product;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ReviewProductDto {
    private Integer uid;
    private String name;
    private Double price;
    private List<CommentDto> comments;
    private Integer voteCount;
    private int commentsCount;
    private float avgVotes;

    public ReviewProductDto(Product product, List<Comment> comments, int commentsCount, float avgVotes) {
        this.uid = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.comments = comments.stream().map(CommentDto::new).collect(Collectors.toList());
        this.commentsCount = commentsCount;
        this.avgVotes = avgVotes;
    }
}
