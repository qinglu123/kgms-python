package com.lq.service;

import com.github.pagehelper.PageInfo;
import com.lq.entity.Entry;

public interface EntryService {
    PageInfo<Entry> getAll(Integer pageNum,Integer pageSize);
    PageInfo<Entry> getEntryByCategoryId(Integer pageNum,Integer pageSize,Integer categoryId);
    int delById(Long id);
    int updateById(Entry entry);
    int add(Entry entry);
    Entry getById(Long id);

}
