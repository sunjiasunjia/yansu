package com.jk.repository;

import com.jk.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @program: es
 * @description:
 * @author: 孙佳
 * @create: 2019-01-17 11:23
 **/
public interface OrderRepository extends ElasticsearchCrudRepository<User,Integer> {

}
