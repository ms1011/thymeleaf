package org.personal.thymeleaf.controller;

import lombok.AllArgsConstructor;
import org.personal.thymeleaf.entity.Review;
import org.personal.thymeleaf.repository.ReviewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {

    private ReviewRepository reviewRepository;

    @GetMapping
    public String listReviews(Model model) {
        List<Review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);
        return "reviews/list";
    }

    @GetMapping("/new")
    public String newReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "reviews/form";
    }

    @PostMapping
    public String saveReview(@ModelAttribute Review review) {
        review.setCreatedDate(LocalDate.now());
        reviewRepository.save(review);
        return "redirect:/reviews";
    }

    @GetMapping("/{id}/edit")
    public String editReviewForm(@PathVariable Long id, Model model) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid review ID: " + id));
        model.addAttribute("review", review);
        return "reviews/form";
    }

    @PostMapping("/{id}")
    public String updateReview(@PathVariable Long id, @ModelAttribute Review updatedReview) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid review ID: " + id));
        review.setTitle(updatedReview.getTitle());
        review.setContent(updatedReview.getContent());
        review.setAuthor(updatedReview.getAuthor());
        review.setRating(updatedReview.getRating());
        reviewRepository.save(review);
        return "redirect:/reviews";
    }

    @PostMapping("/{id}/delete")
    public String deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        return "redirect:/reviews";
    }
}
