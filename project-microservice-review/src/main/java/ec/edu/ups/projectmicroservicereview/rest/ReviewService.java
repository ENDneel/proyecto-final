package ec.edu.ups.projectmicroservicereview.rest;


import ec.edu.ups.projectmicroservicereview.entity.Category;
import ec.edu.ups.projectmicroservicereview.entity.Platform;
import ec.edu.ups.projectmicroservicereview.entity.Review;

import java.util.List;

public interface ReviewService {

    int ratingsCommunity(List<Platform> platforms,String token);




    double scorePlatformsByGame(List<Platform> platforms,String token);

    double ScoreCategoryByGame(List<Category> categories,String token) throws Exception;

    Review getScore(List<Category> categories, List<Platform> platforms,String token);


}
