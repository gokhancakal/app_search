package com.cakal.cloud.appsearch.controller;

import com.cakal.cloud.appsearch.model.Query;
import com.cakal.cloud.appsearch.model.QueryResponse;
import com.cakal.cloud.appsearch.repository.AppSearchClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(path = "/")
public class SearchController {
    private final AppSearchClient appSearchClient;

    public SearchController(AppSearchClient appSearchClient) {
        this.appSearchClient = appSearchClient;
    }

    @GetMapping("/search")
    public String main(@RequestParam(value = "q", required = false) String q, Model model) {
        if (q != null && !q.trim().isEmpty()) {
            model.addAttribute("q", q);
            final QueryResponse response = appSearchClient.search(Query.of(q));
            model.addAttribute("results", response.getResults());
        }
        return "main";
    }

}