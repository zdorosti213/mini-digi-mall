package com.review.dto;

import com.review.model.Comment;
import lombok.Data;

@Data
public class CommentDto {
    private Integer uid;
    private String title;
    private String content;
    private Float vote;

    public CommentDto(Comment comment) {
        this.uid = comment.getId();
        this.title = comment.getTitle();
        this.content = comment.getContent();
        this.vote = comment.getVote();
    }
}
