package com.review.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_fk")
    private Product product;
    @Column(name = "is_approved")
    private Boolean isApproved;
    private String title;
    private String content;
    @Column(name = "creation_date")
    @CreationTimestamp
    private Date creationDate;
    private Float vote;
}
