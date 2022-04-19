package com.review.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    @Column(name = "other_attributes")
    private String otherAttributes;
    @Column(name = "public_reviewable")
    private Boolean publicReviewable;
    @ManyToOne
    @JoinColumn(name = "provider_fk")
    private Provider provider;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Comment> comments;
}
