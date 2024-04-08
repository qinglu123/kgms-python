package com.lq;

import com.lq.entity.Category;
import com.lq.entity.Entry;
import com.lq.mapper.CategoryMapper;
import com.lq.mapper.EntryMapper;
import com.lq.service.EntryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class EbookApplicationTests {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    EntryMapper entryMapper;

    @Autowired
    EntryService entryService;

    /**
     * 类运行前执行
     */
    @BeforeAll
    static void beforeAll(){
//        log.info("====beforeAll===");
        System.out.println("====beforeAll===");
    }

    /**
     * 类结束前执行
     */
    @AfterAll
    static void afterAll(){
        log.info("===afterAll===");
    }

    /**
     * 方法执行前执行
     */
    @BeforeEach
    void beforeEach(){
        log.info("===beforeEach===");
        System.out.println("===beforeEach===");
    }

    /**
     * 方法结束前执行
     */
    @AfterEach
    void afterEach(){
        log.debug("===afterEach===");
    }


    @Test
    @DisplayName("CategoryTest1")
    public void CategoryTest1() {
        List<Category> list = categoryMapper.getAll();
        Stream<Category> stream = list.stream();
        stream.forEach(l -> System.out.println(l));
    }

    @Test
    public void EntryTest1() {
        List<Entry> list = entryMapper.getAll();
        Stream<Entry> stream = list.stream();
        stream.forEach(l -> System.out.println(l));
    }

    /**
     * 添加
     */
//    @Test
//    public void EntryTest2() {
//        Entry entry = new Entry();
//        entry.setCategoryId(1L);
//        entry.setCreateDate("2020-11-11");
//        entry.setSummary("啊啊啊");
//        entry.setTitle("哦哦哦");
//        entry.setUploadUser("阿萨德");
//        entryMapper.add(entry);
//        System.out.println(entry.getId());
//    }

    /**
     * 修改
     */
//    @Test
//    public void EntryTest3() {
//        Entry entry = new Entry();
//        entry.setId(6L);
//        entry.setCategoryId(4L);
//        entry.setSummary("嘿嘿嘿");
//        entry.setUploadUser("嘿嘿嘿");
//        entryMapper.updateById(entry);
//        Entry entry1 = entryMapper.getById(entry.getId());
//        System.out.println(entry1);
//    }

//    @Test
//    public void EntryTest4() {
//        PageInfo<Entry> pageInfo = entryService.getAll(1, 2);
//        System.out.println(pageInfo);
//    }
//
//    @Test
//    public void EntryTest5() {
//        PageInfo<Entry> pageInfo = entryService.getEntryByCategoryId(1, 2,0);
//        System.out.println(pageInfo);
//    }
}
