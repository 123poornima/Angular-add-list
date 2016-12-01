package com.niit.angularpro.dao;

import java.util.List;

import com.niit.angularpro.model.Category;

public interface CategoryDAO {

	public void addFurnitureCategory(Category category);
	public Category getFurnitureCategory(String id);
	public void deleteFurnitureCategory(String id);
	public List<Category> furnitureCategoryList();
	public Category getFurnitureCategoryName(String name);
}
