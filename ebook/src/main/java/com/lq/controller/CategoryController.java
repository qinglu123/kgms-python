package com.lq.controller;

import com.lq.entity.Category;
import com.lq.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.controller
 * @Author: LuQing
 * @CreateTime: 2023-02-11  23:29
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll(Model model){
        List<Category> list = categoryService.getAll();
//        Stream<Category> stream = list.stream();
//        stream.forEach(s -> System.out.println(s));
        return list;
    }


}
