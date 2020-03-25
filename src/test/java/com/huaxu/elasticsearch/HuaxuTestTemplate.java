package com.huaxu.elasticsearch;

import com.alibaba.fastjson.JSONObject;
import com.huaxu.elasticsearch.bean.Item;
import com.huaxu.elasticsearch.fastdfs.DfsService;
import com.huaxu.elasticsearch.mapper.ItemMapper;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@SpringBootTest
public class HuaxuTestTemplate {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private DfsService dfsService;

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void addIndex(){
        boolean index = elasticsearchTemplate.createIndex(Item.class);
        System.out.println("输出结果："+index);
    }

    @Test
    public void queryItem(){
        String name = "技术";
        List<Item> items = itemMapper.queryItemsByNameOrAttach(name , name);
        System.out.println("输出结果："+JSONObject.toJSONString(items));
    }

    @Test
    public void uploadFile(){

    }




}
