package com.iastech.services;

import java.util.List;

import com.iastech.entities.Category;
import com.iastech.payloads.CategoryDto;

public interface CategoryService {
	public CategoryDto createCategory(CategoryDto categoryDto);

	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	public void deleteCategory(Integer categoryId);

	public CategoryDto getCategory(Integer categoryId);

	public List<CategoryDto> getCategories();
}
