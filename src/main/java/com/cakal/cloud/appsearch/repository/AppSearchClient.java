package com.cakal.cloud.appsearch.repository;

import com.cakal.cloud.appsearch.model.Query;
import com.cakal.cloud.appsearch.model.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "appsearch", url="${appsearch.url}")
public interface AppSearchClient {
    @Bean
    @Autowired
    @GetMapping("/api/as/v1/engines/${appsearch.engine}/search")
    QueryResponse search(@RequestBody Query query);

    @GetMapping("/api/as/v1/engines/${appsearch.engine}/query_suggestion")
    QueryResponse suggest(@RequestBody Query query);

}
