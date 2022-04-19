package com.review.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReviewPageDto {
    List<ReviewProductDto> products = new ArrayList<>();
    private int totalProductCount;
    private int totalPageCount;
}
