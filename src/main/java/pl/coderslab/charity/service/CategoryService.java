package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategories();
    public void add(Category category);
    public Optional<Category> get(Long id);
    public void delete(Long id);
}
