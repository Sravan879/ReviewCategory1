/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz2.repository;

import com.example.nxttrendz2.model.Category;
import java.util.ArrayList;

public interface CategoryRepository {
    ArrayList<Category> getCategorys();

    Category getCategoryById(int id);

    Category addCategory(Category category);

    Category updateCategory(int id, Category category);

    void deleteCategory(int id);
}
