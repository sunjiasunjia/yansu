package com.jk.service;

import com.jk.model.User;
import com.jk.repository.OrderRepository;
import com.jk.util.PageResult;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: es
 * @description:
 * @author: 孙佳
 * @create: 2019-01-17 11:32
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private OrderRepository OrderRepository;

    @Autowired
    private ElasticsearchTemplate esTemplate;
    @Override
    public PageResult  queryListUser(User user, Integer page, Integer rows) {
        PageResult pageResult = new PageResult();
        //查询数据
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        //判断条查内容是否空
        //Name 查询，
        if(user.getUsername() != null && user.getUsername() != ""){
            //单个字符匹配字段
            //boolQueryBuilder.must(QueryBuilders.termQuery("username", order.getUsername()));
            //匹配所有字段
            boolQueryBuilder.must(QueryBuilders.matchQuery("username",user.getUsername()));
            //
            //boolQueryBuilder.must(QueryBuilders.queryStringQuery(order.getUsername()));
        }

        //高亮显示
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("username");
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        //使用client设置搜索条件及属性
        SearchRequestBuilder response  = esTemplate.getClient().prepareSearch("sunjia")//搜索名称
                //类型
                .setTypes("user")
                //搜索类型
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                //搜索条件
                .setQuery(boolQueryBuilder)
                //高亮设置
                .highlighter(highlightBuilder)
                .setExplain(true)//设置是否按照查询匹配度排列
                //分页条数
                .setFrom((page-1)*rows)
                .setSize(rows)
                .setExplain(true);
        //.execute()
//                .actionGet();
        //获取搜索后的信息
        SearchResponse response1 = response.get();
        SearchHits hits = response1.getHits();
        int totalHits = (int) hits.totalHits;
        List<User> order2 = new ArrayList<User>();
        for (SearchHit searchHit: hits) {
            User order1= new User();
            order1.setUsername(searchHit.getSourceAsMap().get("username").toString());
            //获取高亮字段，将高亮处理后内容，替换原有的内容，可能会出现不匹配
            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
            HighlightField username = highlightFields.get("username");
            //如果高亮字段为空set普通得值
            order1.setId(Integer.parseInt(searchHit.getSourceAsMap().get("id").toString()));

            // 判断 username是否是高亮字段

            if(username == null){
                //普通字段
                order1.setUsername(searchHit.getSourceAsMap().get("username").toString());
            }else {
                //高亮字段
                order1.setUsername(username.fragments()[0].toString());
            }
            order1.setUsersex(Integer.parseInt(searchHit.getSourceAsMap().get("usersex").toString()));
            order1.setUserage(Integer.parseInt(searchHit.getSourceAsMap().get("userage").toString()));
            order1.setBirthday(searchHit.getSourceAsMap().get("birthday").toString());
            order1.setUrl(searchHit.getSourceAsMap().get("url").toString());
            order1.setDescription(searchHit.getSourceAsMap().get("description").toString());
            order1.setHobby(searchHit.getSourceAsMap().get("hobby").toString());
            order2.add(order1);
        }
        pageResult.setTotal(totalHits);
        pageResult.setRows(order2);
        return pageResult;
    }

}
