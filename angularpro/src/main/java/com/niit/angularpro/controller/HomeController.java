package com.niit.angularpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.angularpro.dao.CategoryDAO;
import com.niit.angularpro.model.Category;

@RestController
public class HomeController
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLoad(Model model){
		System.out.println("on load");
		model.addAttribute("category", category);
		model.addAttribute("categoryList",this.categoryDAO.furnitureCategoryList());
		return "index";
	
}
	
	//for add and update category both
		@RequestMapping(value="/category/add", method=RequestMethod.POST)
		public ResponseEntity<Category> addFurnitureCategory(@RequestBody Category category)
		{
			categoryDAO.addFurnitureCategory(category);
			return new ResponseEntity<Category>(category,HttpStatus.OK);
			//return "category";

		}
		
		@RequestMapping("/category/remove/{c_ID}")
		public ResponseEntity<Category> deleteFurnitureCategory(@PathVariable("c_ID") String id, @RequestBody Category category) throws Exception {

			try {
				categoryDAO.deleteFurnitureCategory(id);
				//model.addAttribute("message", "Successfully Added");
			} catch (Exception e) {
				//model.addAttribute("message", e.getMessage());
				e.printStackTrace();
			}
			// redirectAttrs.addFlashAttribute(arg0, arg1)
			return new ResponseEntity<Category>(category,HttpStatus.OK);
		}
		

		@RequestMapping("/category/edit/{c_ID}")
		public ResponseEntity<Category> editFurnitureCategory(@PathVariable("c_ID") String id,@RequestBody Category category) {
			System.out.println("editCategory");
			
			//model.addAttribute("category", this.categoryDAO.getFurnitureCategory(id));
			//model.addAttribute("categoryList", this.categoryDAO.furnitureCategoryList());
			return new ResponseEntity<Category>(category,HttpStatus.OK);
		}
		
		
			@RequestMapping(value = "/category", method = RequestMethod.GET)
			public ResponseEntity<List<Category>> listFurnitureCategories(){
				
				
				List<Category> category=categoryDAO.furnitureCategoryList();
				
				
				//model.addAttribute("category", category);
				//model.addAttribute("categoryList",this.categoryDAO.furnitureCategoryList());
				return new ResponseEntity<List<Category>>(category,HttpStatus.OK);
			
		}
			

}
