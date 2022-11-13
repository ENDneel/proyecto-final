package ec.edu.ups.projectmicroservicereview.entity.request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ReviewDTO {

    private String acceptance;
    private double scoreCategory;
    private double scorePlatform;

    public ReviewDTO(Long id, String acceptance, double scoreCategory, double scorePlatform) {

        this.acceptance = acceptance;
        this.scoreCategory = scoreCategory;
        this.scorePlatform = scorePlatform;
    }

    public ReviewDTO() {
    }

    public ReviewDTO(String acceptance, int scoreCategory, int scorePlatform) {
        this.acceptance = acceptance;
        this.scoreCategory = scoreCategory;
        this.scorePlatform = scorePlatform;
    }




    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public double getScoreCategory() {
        return scoreCategory;
    }

    public void setScoreCategory(double scoreCategory) {
        this.scoreCategory = scoreCategory;
    }

    public double getScorePlatform() {
        return scorePlatform;
    }

    public void setScorePlatform(double scorePlatform) {
        this.scorePlatform = scorePlatform;
    }
}
