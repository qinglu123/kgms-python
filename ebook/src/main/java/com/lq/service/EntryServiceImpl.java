package com.lq.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lq.entity.Entry;
import com.lq.mapper.EntryMapper;
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
public class EntryServiceImpl implements EntryService {

    @Autowired
    EntryMapper entryMapper;


    @Override
    public PageInfo<Entry> getAll(Integer pageNum,Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Entry> list = entryMapper.getAll();
        PageInfo<Entry> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Entry> getEntryByCategoryId(Integer pageNum,Integer pageSize,Integer categoryId) {
       PageHelper.startPage(pageNum,pageSize);
        List<Entry> list = entryMapper.getEntryByCategoryId(categoryId);
        PageInfo<Entry> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int delById(Long id) {
        return entryMapper.delById(id);
    }

    @Override
    public int updateById(Entry entry) {
        return entryMapper.updateById(entry);
    }

    @Override
    public int add(Entry entry) {
        return entryMapper.add(entry);
    }

    @Override
    public Entry getById(Long id) {
        return entryMapper.getById(id);
    }
}
