package com.review.service;

import com.review.dto.ReviewPageDto;
import com.review.dto.ReviewProductDto;
import com.review.model.Comment;
import com.review.model.Product;
import com.review.repository.CommentDao;
import com.review.repository.ProductDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductReviewService {
    private ProductDao productDao;
    private CommentDao commentDao;

    public ReviewPageDto getByPageNumber(int pageNumber, int pageSize) {
        ReviewPageDto result = new ReviewPageDto();
        Page<Product> products = productDao.findAll(PageRequest.of(pageNumber, pageSize));
        result.setTotalPageCount(products.getTotalPages());
        result.setTotalProductCount((int) products.getTotalElements());
        products.getContent().stream().forEach(p -> result.getProducts().add(createReviewProductDto(p)));
        return result;
    }

    private ReviewProductDto createReviewProductDto(Product p) {
        List<Comment> comments = commentDao.find3TopCommentPerProduct(p.getId());
        int commentsCount = commentDao.getCountByProduct(p.getId());
        float avgVote = commentDao.getVoteAvgByProduct(p.getId());
        log.debug("ReviewDto created for product [{}:{}]", p.getId(), p.getName());
        return new ReviewProductDto(p, comments, commentsCount, avgVote);
    }
}
