package pl.coderslab.charity.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }
    @Override
    public Optional<Category> get(Long id) {
        return categoryRepository.findById(id);
    }
    @Override
    public void delete(Long id) {
        categoryRepository.deleteCategoryById(id);
    }
}
