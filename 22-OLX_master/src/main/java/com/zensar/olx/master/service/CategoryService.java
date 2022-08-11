package com.zensar.olx.master.service;



import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.zensar.olx.master.bean.Category;
import com.zensar.olx.master.db.CategoryDAO;



@Service
public class CategoryService {

@Autowired
CategoryDAO dao;

public Category addCategory(Category category) {
return this.dao.save(category);
}

public List<Category> getAllCategories(){
return this.dao.findAll();
}

public Category findCategoryById(int id) {

Optional<Category> optional;
optional=this.dao.findById(id);
if(optional.isPresent())
return optional.get();
else
return null;
}



}