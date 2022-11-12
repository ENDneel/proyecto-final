package ec.edu.ups.projectmicroservicereview.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String acceptance;
    @ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<DistributionPlatform> distributionPlatforms;
    @ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)

    private List<Category> categories ;
    @ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @Column(name = "platforms_id")
    private List<Platform> platforms ;


    public Review(Long id, String acceptance, List<DistributionPlatform> distributionPlatforms, List<Category> categories, List<Platform> platforms) {
        this.id = id;
         this.acceptance = acceptance;
        this.distributionPlatforms = distributionPlatforms;
        this.categories = categories;
        this.platforms = platforms;
    }

    public Review() {
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

    public List<DistributionPlatform> getDistributionPlatforms() {
        return distributionPlatforms;
    }

    public void setDistributionPlatforms(List<DistributionPlatform> distributionPlatforms) {
        this.distributionPlatforms = distributionPlatforms;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }
}
