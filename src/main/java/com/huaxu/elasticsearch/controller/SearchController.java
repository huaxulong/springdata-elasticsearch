package com.huaxu.elasticsearch.controller;

import com.huaxu.elasticsearch.bean.Item;
import com.huaxu.elasticsearch.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("huaxu")
public class SearchController {

    @Autowired
    private ItemMapper itemMapper;

    @RequestMapping("queryItem")
    public List<Item> queryItem(String name){
        List<Item> items = itemMapper.queryItemsByNameOrAttach(name , name);
        return items;

    }

}
