package com.xmgl.blog.controller.back.category;

import com.xmgl.blog.entity.Category;
import com.xmgl.blog.service.CategoryService;
import com.xmgl.blog.util.Result;
import com.xmgl.blog.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 郭秦平
 * @data: 2019/04/14
 **/

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("list")
    @ResponseBody
    private Result<List<Category>> getcategoryList(String categoryName, Integer page, Integer limit){
        System.out.println(1);
        return categoryService.selectcategoryList(categoryName, page, limit);
    }

    @PostMapping("add")
    @ResponseBody
    private ServerResponse addcategory(@RequestBody Map<String,Object> map){
        categoryService.insertcategory((String)map.get("categoryName"));
        return ServerResponse.createBySuccess();
    }

    @PostMapping("delete")
    @ResponseBody
    private ServerResponse deletecategory(@RequestBody Map<String,Object> map){
        categoryService.deletecategory((Integer)map.get("categoryId"));
        return ServerResponse.createBySuccess();
    }

    @PostMapping("update")
    @ResponseBody
    private ServerResponse updatecategory(@RequestBody Map<String,Object> map){
        Category category = new Category();
        try {
            int categoryId = (Integer)map.get("categoryId");
            String categoryName = (String)map.get("categoryName");
            category.setCategoryId(categoryId);
            category.setCategoryName(categoryName);
        }catch (Exception e){
            return ServerResponse.createByFailure(e.getMessage());
        }
        categoryService.updatecategory(category);
        return ServerResponse.createBySuccess();
    }
}
