package com.thejoa703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.ReviewDto;
import com.thejoa703.service.ReviewService;


@Controller
@RequestMapping("/reviews/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 🔹 리뷰 작성 폼
    @GetMapping("/comment")
    public String commentForm(@RequestParam int recipeId, Model model) {
        model.addAttribute("recipeId", recipeId);
        return "reviews/comment";
    }

    // 🔹 리뷰 저장
    @PostMapping("/comment")
    public String commentPost(ReviewDto dto, RedirectAttributes rttr) {
        reviewService.writeReview(dto);
        rttr.addFlashAttribute("success", "리뷰 등록 완료");
        return "redirect:/recipes/detail?id=" + dto.getRecipeId();
    }

    // 🔹 리뷰 목록 조회 (추가!)
    @GetMapping("/list")
    public String reviewList(
            @RequestParam int recipeId,
            Model model
    ) {
        model.addAttribute(
                "reviewList",
                reviewService.getReviewsByRecipeId(recipeId)
        );
        model.addAttribute("recipeId", recipeId);
        return "reviews/list";
    }
}