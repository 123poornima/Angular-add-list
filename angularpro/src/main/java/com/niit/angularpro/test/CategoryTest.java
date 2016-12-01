package com.niit.angularpro.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.angularpro.dao.CategoryDAO;
import com.niit.angularpro.model.Category;

public class CategoryTest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		CategoryDAO categoryDAO= (CategoryDAO) context.getBean("categoryDAO");

		Category category=(Category) context.getBean("category");
		
		
		category.setc_ID("789");
		category.setc_Name("poohhh");
		category.setC_Description("fihhh");
		
		
		categoryDAO.addFurnitureCategory(category);

	}

}
