package ec.edu.ups.projectmicroservicereview.entity;

import javax.persistence.*;
import java.util.List;

@Entity

public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int value;
    @ManyToMany(mappedBy = "platforms",fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private List<Review> review;

    public Platform(Long id, String name, int value, List<Review> review) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.review = review;
    }

    public Platform() {
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
}
