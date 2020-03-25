package com.huaxu.elasticsearch.mapper;

import com.huaxu.elasticsearch.bean.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemMapper extends ElasticsearchRepository<Item,String>{

    public List<Item> queryItemByName(String name);

    public List<Item> queryItemsByNameOrAttach(String name , String attach);

}
