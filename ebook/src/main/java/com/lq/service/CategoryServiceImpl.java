package com.lq.service;

import com.lq.entity.Category;
import com.lq.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.service
 * @Author: LuQing
 * @CreateTime: 2023-02-11  22:42
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> getAll() {
        return categoryMapper.getAll();
    }
}
