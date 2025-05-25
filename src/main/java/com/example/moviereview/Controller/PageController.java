package com.example.moviereview.Controller;

import com.example.moviereview.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final ReviewService reviewService;

    @GetMapping("/reviews/page")
    public String reviewPage(Model model) {
        model.addAttribute("reviews", reviewService.getAllReviews());
        return "reviewList";
    }
}
