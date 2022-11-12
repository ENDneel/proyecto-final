package ec.edu.ups.projectmicroservicereview.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class DistributionPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int likes;
    @ManyToMany(mappedBy = "distributionPlatforms",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> review;

    public DistributionPlatform(Long id, String name, int likes, List<Review> review) {
        this.id = id;
        this.name = name;
        this.likes = likes;
        this.review = review;
    }

    public DistributionPlatform() {
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
}
