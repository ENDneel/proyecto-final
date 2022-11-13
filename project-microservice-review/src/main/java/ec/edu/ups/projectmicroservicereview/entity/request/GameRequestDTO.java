package ec.edu.ups.projectmicroservicereview.entity.request;

import ec.edu.ups.projectmicroservicereview.entity.Category;
import ec.edu.ups.projectmicroservicereview.entity.Platform;

import java.util.List;

public class GameRequestDTO {

    public Long id;
    public String name;
    public List<Category> category;
    public List<Platform>platform;

    public GameRequestDTO(Long id, String name, List<Category> category, List<Platform> platform) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.platform = platform;
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

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Platform> getPlatform() {
        return platform;
    }

    public void setPlatform(List<Platform> platform) {
        this.platform = platform;
    }
}
