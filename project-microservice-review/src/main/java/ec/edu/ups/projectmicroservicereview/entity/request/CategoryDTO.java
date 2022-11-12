package ec.edu.ups.projectmicroservicereview.entity.request;

import ec.edu.ups.projectmicroservicereview.entity.Review;

import javax.persistence.*;
import java.util.List;


public class CategoryDTO {

    private Long id;
    private String name;
    private int value;
    private List<Long> review;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name, int value, List<Long> review) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.review = review;
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

    public List<Long> getReview() {
        return review;
    }

    public void setReview(List<Long                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         > review) {
        this.review = review;
    }
}
