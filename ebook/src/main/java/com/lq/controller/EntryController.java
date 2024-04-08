package com.lq.controller;

import com.github.pagehelper.PageInfo;
import com.lq.entity.Entry;
import com.lq.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.controller
 * @Author: LuQing
 * @CreateTime: 2023-02-11  23:25
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    EntryService entryService;

    @GetMapping("/index")
    public String index() {
        return "index";

    }
    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/getEntryAll")
    @ResponseBody
    public PageInfo<Entry> getEntryAll(Integer pageNum, Integer pageSize) {
//        System.out.println("pageNum--->"+pageNum);
        if (pageNum == null || pageNum < 1)
            pageNum = 1;
        if (pageSize == null || pageSize < 1)
            pageSize = 2;
        PageInfo<Entry> pageInfo = entryService.getAll(pageNum, pageSize);
//        System.out.println(pageInfo);
        return pageInfo;
    }

    @GetMapping("/getEntryByCategoryId")
    @ResponseBody
    public PageInfo<Entry> getEntryByCategoryId(Integer pageNum,Integer pageSize,Integer categoryId) {
        if (pageNum == null || pageNum < 1)
            pageNum = 1;
        if (pageSize == null || pageSize < 1)
            pageSize = 2;
        PageInfo<Entry> pageInfo = entryService.getEntryByCategoryId(pageNum, pageSize, categoryId);
        return pageInfo;
    }

    @PostMapping("/insert")
    public String insertEntry(Entry entry){
        System.out.println(entry);
        try {
            entryService.add(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @PostMapping("/del")
    public String del(Long id){
        entryService.delById(id);
        return "index";
    }

    @PostMapping("/update")
    public String update(Entry entry){
        System.out.println("====  "+entry);
        entryService.updateById(entry);
        return "index";
    }

    @GetMapping("/getById")
    public String getById(Long id, Model model){
        Entry entry = entryService.getById(id);
        model.addAttribute("entry",entry);
        return "toUpdate";
    }

}
