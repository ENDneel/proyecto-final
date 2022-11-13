package ec.edu.ups.projectmicroservicereview.rest;

import ec.edu.ups.projectmicroservicereview.entity.Category;
import ec.edu.ups.projectmicroservicereview.entity.Platform;
import ec.edu.ups.projectmicroservicereview.entity.Review;
import ec.edu.ups.projectmicroservicereview.entity.request.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {
    private final String URI_GAME = "http://192.168.1.8:8080/games/";
    @Autowired
    RestTemplate restTemplate;

    @Override
    public int ratingsCommunity(List<Platform> platforms,String token) {

        List<GameDTO> list = getAllGamesToServer(token);
        int sumatoria= 0;
        for (GameDTO gameDTO: list) {
            if(gameDTO.getPlatforms().containsAll(platforms)){
                sumatoria = gameDTO.getRating()+sumatoria;
            }
        }
        return sumatoria;
    }

    @Override
    public double scorePlatformsByGame(List<Platform> platforms,String token) {
        List<GameDTO> list = getAllGamesToServer(token);
        int cont = 0;
        double sumatoria = 0.0;
        for (GameDTO gameDTO : list) {
            if (gameDTO.getPlatforms().containsAll(platforms)) {
                cont++;
                sumatoria = gameDTO.getScore() + sumatoria;
            }
        }
        return sumatoria / cont;
    }

    @Override
    public double ScoreCategoryByGame(List<Category> categories,String token) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        String nToken=token.split("Bearer")[1].trim();
        System.out.println(nToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(nToken);
        ResponseEntity<GameDTO[]> responseEntity = null;
        HttpEntity request = new HttpEntity(headers);
        responseEntity=  restTemplate.exchange(URI_GAME,HttpMethod.GET,request,GameDTO[].class);

        GameDTO[] userArray = responseEntity.getBody();
        List<GameDTO> list = Arrays.asList(userArray);
        System.out.println(list.size());
        double score=0;
        int count=0;

        for (GameDTO gameDTO : list) {
            if(gameDTO.categories.containsAll(categories)){
                score+=gameDTO.getScore();
                count++;
            }
        }

        return score/count;
    }

    @Override
    public Review getScore(List<Category> categories,List<Platform> platforms,String token) {
        double scoreCat = 0;
        try {
            scoreCat = ScoreCategoryByGame(categories,token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        double scorePlat=scorePlatformsByGame(platforms,token);
        int ratings =ratingsCommunity(platforms,token);
        Review review= new Review();
        review.setScoreCategory(scoreCat);
        review.setScorePlatform(scorePlat);
        if(ratings>=0 && ratings<100){
            review.setAcceptance("*");
        } else if (ratings>=100 && ratings<300) {
            review.setAcceptance("**");
        } else if (ratings>=300 && ratings<500) {
            review.setAcceptance("***");
        } else if (ratings>=500 && ratings<900) {
            review.setAcceptance("****");
        } else if (ratings>=900) {
            review.setAcceptance("*****");
        }else{
            review.setAcceptance("");
        }

        return review;
    }

public List<GameDTO> getAllGamesToServer(String token){
    HttpHeaders headers = new HttpHeaders();
    String nToken=token.split("Bearer")[1].trim();
    System.out.println(nToken);
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(nToken);
    ResponseEntity<GameDTO[]> responseEntity = null;
    HttpEntity request = new HttpEntity(headers);
    responseEntity=  restTemplate.exchange(URI_GAME,HttpMethod.GET,request,GameDTO[].class);
    GameDTO[] userArray = responseEntity.getBody();
    List<GameDTO> list = Arrays.asList(userArray);
    return list;
}
}
