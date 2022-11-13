package ec.edu.ups.projectgames.entitty;

import javax.persistence.*;
import java.util.List;


@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public String description;
    public int ranking;
    @ElementCollection(targetClass = Category.class)
    @Enumerated(EnumType.STRING)
    public List<Category> categories;
    public String classification;
    @ElementCollection(targetClass = Platform.class)
    @Enumerated(EnumType.STRING)
    public List<Platform> platforms;
    public int rating;
    public Double score;
    public String payment;

    public Game(Long id, String name, String description, int ranking, List<Category> categories, String classification, List<Platform> platforms, int rating, Double score, String payment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ranking = ranking;
        this.categories = categories;
        this.classification = classification;
        this.platforms = platforms;
        this.rating = rating;
        this.score = score;
        this.payment = payment;
    }

    public Game(String name, String description, int ranking, List<Category> categories, String classification, List<Platform> platforms, int rating, Double score, String payment) {
        this.name = name;
        this.description = description;
        this.ranking = ranking;
        this.categories = categories;
        this.classification = classification;
        this.platforms = platforms;
        this.rating = rating;
        this.score = score;
        this.payment = payment;
    }

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
