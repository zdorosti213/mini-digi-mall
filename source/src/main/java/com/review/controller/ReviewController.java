package com.review.controller;

import com.review.dto.ReviewPageDto;
import com.review.service.ProductReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ReviewController {

    private ProductReviewService productReviewService;

    @GetMapping
    public ReviewPageDto getProductList(@RequestParam(name = "page_number") int pageNumber,
                                        @RequestParam(name = "page_size", defaultValue = "10") int pageSize) {
        log.info("RestApi called for \"/products?page_number={}&page_size={}\"", pageNumber, pageSize);
        return productReviewService.getByPageNumber(pageNumber, pageSize);
    }
}
