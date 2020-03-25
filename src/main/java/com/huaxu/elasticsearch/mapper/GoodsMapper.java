package com.huaxu.elasticsearch.mapper;

import com.huaxu.elasticsearch.bean.Goods;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface GoodsMapper extends ElasticsearchRepository<Goods, String> {
    List<Goods> findByName(String name);


    List<Goods> findByName(String name, Pageable pageable);
}
