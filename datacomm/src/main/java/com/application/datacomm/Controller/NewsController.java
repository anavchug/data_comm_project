package com.application.datacomm.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.datacomm.DataObject.News;
import com.application.datacomm.RestAPI.NewsAPI;
import com.application.datacomm.RestAPI.Request;

@RestController
public class NewsController {
    @GetMapping("/news")
    public List<News> getNews() {
        try {
            NewsAPI newsAPI = new NewsAPI("us", 12);
            String newsUrl = newsAPI.getNewsAPIUrl();
            
            // Make a request to the News API
            String jsonData = Request.makeRequest(newsUrl);

            // Parse the JSON data
            List<News> newsList = NewsAPI.parseJson(jsonData);

            return newsList;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}



