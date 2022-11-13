package ec.edu.ups.projectmicroservicereview.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.projectmicroservicereview.entity.Category;
import ec.edu.ups.projectmicroservicereview.entity.Platform;
import ec.edu.ups.projectmicroservicereview.entity.Review;
import ec.edu.ups.projectmicroservicereview.entity.request.GameRequestDTO;
import ec.edu.ups.projectmicroservicereview.entity.request.ReviewDTO;
import ec.edu.ups.projectmicroservicereview.rest.ReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/category")
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseBody
    public double scoreCategoryByGame(HttpServletRequest request, @RequestBody List<Category> categories) {
        String TOKEN = request.getHeader("Authorization");
        try {
            return reviewService.ScoreCategoryByGame(categories, TOKEN);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found", e);
        }
    }

    @GetMapping("/platform")
    public double getScorePlatformByGame(HttpServletRequest request, @RequestBody List<Platform> platforms) {
        String TOKEN = request.getHeader("Authorization");
        try {
            return reviewService.scorePlatformsByGame(platforms, TOKEN);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found", e);
        }
    }

    @GetMapping("/rating")
    public int getRatingCommunity(HttpServletRequest request, List<Platform> platforms) {
        String TOKEN = request.getHeader("Authorization");
        try {
            return reviewService.ratingsCommunity(platforms, TOKEN);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found", e);
        }

    }

    @GetMapping("/score")
    @JsonProperty
    public ReviewDTO getScore(HttpServletRequest request, @RequestBody GameRequestDTO gameRequestDTO){
        String TOKEN = request.getHeader("Authorization");

        try {
            return convertedReviewToReviewDTO(reviewService.getScore(gameRequestDTO.getCategory(),gameRequestDTO.getPlatform(),TOKEN));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found", e);
        }
    }
    public ReviewDTO convertedReviewToReviewDTO(Review review){
        ReviewDTO reviewDTO = new ReviewDTO();
        BeanUtils.copyProperties(review, reviewDTO);
        return  reviewDTO;
    }
}
