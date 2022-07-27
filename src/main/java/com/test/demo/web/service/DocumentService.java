package com.test.demo.web.service;

import com.alibaba.fastjson.JSON;
import com.test.demo.web.constant.Constant;
import com.test.demo.web.dto.UserCityDTO;
import com.test.demo.web.entity.UserDocument;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/20 16:32
 */
@Service
public class DocumentService {

    @Autowired
    RestHighLevelClient client;

    /**
     * 创建文档
     * @param document
     * @return
     * @throws Exception
     */
    public Boolean createUserDocument(UserDocument document) throws Exception {
        UUID uuid = UUID.randomUUID();
        document.setId(uuid.toString());
        IndexRequest indexRequest = new IndexRequest(Constant.USER)
                .id(document.getId())
                .source(JSON.toJSONString(document), XContentType.JSON);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        return indexResponse.status().equals(RestStatus.OK);
    }

    /**
     * 批量创建文档
     * @param documents
     * @return
     * @throws IOException
     */
    public Boolean bulkCreateUserDocument(List<UserDocument> documents) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        for (UserDocument document : documents) {
            String id = UUID.randomUUID().toString();
            document.setId(id);
            IndexRequest indexRequest = new IndexRequest(Constant.USER)
                    .id(id)
                    .source(JSON.toJSONString(document), XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        return bulkResponse.status().equals(RestStatus.OK);
    }

    /**
     * 获取文档
     * @param id
     * @return
     * @throws IOException
     */
    public UserDocument getUserDocument(String id) throws IOException {
        GetRequest getRequest = new GetRequest(Constant.USER, id);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        UserDocument result = new UserDocument();
        if (getResponse.isExists()) {
            String sourceAsString = getResponse.getSourceAsString();
            result = JSON.parseObject(sourceAsString, UserDocument.class);
        } else {
            System.out.println("没有找到该 id 的文档");
        }
        return result;
    }

    /**
     * 更新文档
     * @param document
     * @return
     * @throws Exception
     */
    public Boolean updateUserDocument(UserDocument document) throws Exception {
        UserDocument resultDocument = getUserDocument(document.getId());
        UpdateRequest updateRequest = new UpdateRequest(Constant.USER, resultDocument.getId());
        updateRequest.doc(JSON.toJSONString(document), XContentType.JSON);
        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        return updateResponse.status().equals(RestStatus.OK);
    }

    /**
     * 删除文档
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteUserDocument(String id) throws Exception {
        DeleteRequest deleteRequest = new DeleteRequest(Constant.USER, id);
        DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);
        return response.getResult().name();
    }

    public List<UserDocument> searchUserByCity(String city) throws Exception {
        SearchRequest searchRequest = new SearchRequest(Constant.USER);
//        searchRequest.indices(Constant.USER);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("city", city);
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("city", city);
        searchSourceBuilder.query(matchQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        return getSearchResult(searchResponse);
    }

    public List<UserCityDTO> aggregationsSearchUser() throws Exception {
        SearchRequest searchRequest = new SearchRequest(Constant.USER);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        TermsAggregationBuilder aggregation = AggregationBuilders.terms("by_city")
                .field("city")
                .subAggregation(AggregationBuilders
                        .avg("average_age")
                        .field("age"));
        searchSourceBuilder.aggregation(aggregation);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        Aggregations aggregations = searchResponse.getAggregations();
        Terms byCityAggregation = aggregations.get("by_city");
        List<UserCityDTO> userCityList = new ArrayList<>();
        for (Terms.Bucket buck : byCityAggregation.getBuckets()) {
            UserCityDTO userCityDTO = new UserCityDTO();
            userCityDTO.setCity(buck.getKeyAsString());
            userCityDTO.setCount(buck.getDocCount());
            // 获取子聚合
            Avg averageBalance = buck.getAggregations().get("average_age");
            userCityDTO.setAvgAge(averageBalance.getValue());
            userCityList.add(userCityDTO);
        }
        return userCityList;
    }

    private List<UserDocument> getSearchResult(SearchResponse response) {
        SearchHit[] searchHit = response.getHits().getHits();
        List<UserDocument> userDocuments = new ArrayList<>();
        for (SearchHit hit : searchHit) {
            userDocuments.add(JSON.parseObject(hit.getSourceAsString(), UserDocument.class));
        }
        return userDocuments;
    }

}
