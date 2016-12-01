package com.niit.angularpro.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.angularpro.model.Category;


	@EnableTransactionManagement
	@SuppressWarnings("deprecation")
	@Repository("categoryDAO")
	public class CategoryDAOImpl implements CategoryDAO 
	{
		@Autowired
		private SessionFactory sessionFactory; 
		
		public CategoryDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		
		@Transactional
		public void addFurnitureCategory(Category category)
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		}
		
		@Transactional
		public void deleteFurnitureCategory(String id)
		{
			Category category=new Category();
			category.setc_ID(id);
			sessionFactory.getCurrentSession().delete(category);
		}
		
		@Transactional
		public Category getFurnitureCategory(String id)
		{
			String hql="from Category where c_ID="+"'"+id+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Category> list=(List<Category>) query.list();
			if(list!=null&& !list.isEmpty())
			{
				return list.get(0);
			}
			return null;
			
		}
		
		@Transactional
		public Category getFurnitureCategoryName(String name)
		{
			String hql="from Category where c_Name="+"'"+ name +"'";
			@SuppressWarnings("rawtypes")
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Category> list= query.list();
			if(list!=null && !list.isEmpty())
			{
				return list.get(0);
			}
			return null;
			
		}
		
		@Transactional
		public List<Category> furnitureCategoryList()
		{
			List<Category> list= (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
					
		}
}
