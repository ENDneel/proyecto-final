package ec.edu.ups.projectmicroservicereview.rest;

import ec.edu.ups.projectmicroservicereview.entity.Category;
import ec.edu.ups.projectmicroservicereview.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class CategoryServiceImpl implements  CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

}
