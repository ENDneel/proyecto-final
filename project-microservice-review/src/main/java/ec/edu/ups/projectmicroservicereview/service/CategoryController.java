package ec.edu.ups.projectmicroservicereview.service;

import ec.edu.ups.projectmicroservicereview.entity.Category;
import ec.edu.ups.projectmicroservicereview.entity.request.CategoryDTO;
import ec.edu.ups.projectmicroservicereview.rest.CategoryService;
import ec.edu.ups.projectmicroservicereview.rest.ReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryDTO saveCategory(@RequestBody CategoryDTO categoryDTO){
        Category category= new Category();
        category.setId(categoryDTO.getId());
        category.setName(category.getName());
        category.setValue(categoryDTO.getValue());

       return convertCategoryToCategoryDTO(categoryService.saveCategory(category));
    }








    private CategoryDTO convertCategoryToCategoryDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category, categoryDTO);
        return categoryDTO;
    }

}
