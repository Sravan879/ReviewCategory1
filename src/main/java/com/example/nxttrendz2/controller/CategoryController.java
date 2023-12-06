/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz2.controller;

import com.example.nxttrendz2.model.*;
import com.example.nxttrendz2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CategoryController {
    @Autowired
    private CategoryJpaService categoryJpaService;

    @GetMapping("/categorys")
    public ArrayList<Category> getCategorys() {
        return categoryJpaService.getCategorys();
    }

    @GetMapping("/categorys/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") int id) {
        return categoryJpaService.getCategoryById(id);
    }

    @PostMapping("/categorys")
    public Category addCategory(@RequestBody Category category) {
        return categoryJpaService.addCategory(category);
    }

    @PutMapping("/categorys/{categoryId}")
    public Category updateCategory(@PathVariable("categoryId") int id, @RequestBody Category category) {
        return categoryJpaService.updateCategory(id, category);
    }

    @DeleteMapping("/categorys/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") int id) {
        categoryJpaService.deleteCategory(id);
    }
}