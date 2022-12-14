package ec.edu.ups.projectmicroservicereview.entity;
import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String acceptance;
    private double scoreCategory;
    private double scorePlatform;

    public Review(Long id, String acceptance, double scoreCategory, double scorePlatform) {
        this.id = id;
        this.acceptance = acceptance;
        this.scoreCategory = scoreCategory;
        this.scorePlatform = scorePlatform;
    }

    public Review() {
    }

    public Review(String acceptance, int scoreCategory, int scorePlatform) {
        this.acceptance = acceptance;
        this.scoreCategory = scoreCategory;
        this.scorePlatform = scorePlatform;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
