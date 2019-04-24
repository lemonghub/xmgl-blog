package com.xmgl.blog.controller.fore.category;

import com.xmgl.blog.entity.Category;
import com.xmgl.blog.service.CategoryService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by linbin
 * on 2019/4/21 22:37
 */
@RestController
@RequestMapping("category")
public class CategoryForeController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CategoryService categoryService;

    @PostMapping("allcategory")
    @ResponseBody
    private List<Category> getCategoryAll(){
        List<Category> list = new ArrayList<>();
        list = categoryService.selectCategoryListAll();
        if (list != null){
            logger.info("分类查询成功!");
        }
        return list;
    }
}
