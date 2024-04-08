package com.lq.mapper;

import com.lq.entity.Entry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EntryMapper {
    List<Entry> getAll();
    List<Entry> getEntryByCategoryId(@Param("categoryId") Integer categoryId);
    int delById(@Param("id") Long id);
    int updateById(@Param("entry") Entry entry);
    int add(@Param("entry") Entry entry);
    Entry getById(Long id);
}
