package com.zensar.olx.master.rest;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.zensar.olx.master.bean.Category;
import com.zensar.olx.master.service.CategoryService;



@RestController

public class CategoryController {

@Autowired
CategoryService service;

@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/advertise/addCategory")
public Category addCategory(@RequestBody Category category) {
return this.service.addCategory(category);
}

@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/advertise/category")
public List<Category> getAllCategories(){
return this.service.getAllCategories();
}

@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/advertise/getCategoryById/{id}")
public Category getCategory(@PathVariable(name="id") int id) {
return this.service.findCategoryById(id);
}



}