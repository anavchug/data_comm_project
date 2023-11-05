package com.application.datacomm.RestAPI;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import com.application.datacomm.DataObject.News;

public class NewsAPI {
    private String apiKey = APIKeys.NEWS_KEY;
    private String apiUrl = "https://newsapi.org/v2/top-headlines";

    public NewsAPI(String country, int pageSize){
        apiUrl += "?country=" + country;
        apiUrl += "&pageSize=" + pageSize;
        apiUrl += "&apiKey="+this.apiKey;
    }

    public static List<News> parseJson(String jsonData) {
        List<News> news = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray articlesArray = jsonObject.getJSONArray("articles");
    
            for (int i = 0; i < articlesArray.length(); i++) {
                JSONObject articleObject = articlesArray.getJSONObject(i);
    
                if (articleObject.has("title") && articleObject.has("urlToImage")) {
                    String title = articleObject.getString("title");
                    String description = articleObject.optString("description", "No Description");
                    String url = articleObject.getString("url");
                    String content = articleObject.optString("content", "");
                    String imageUrl = articleObject.optString("urlToImage", "");
    
                    // Check if the imageUrl and title are not empty
                    if (!imageUrl.isEmpty() && !title.isEmpty()) {
                        News newsObject = new News();
                        newsObject.setTitle(title);
                        newsObject.setDescription(description);
                        newsObject.setContent(content);
                        newsObject.setUrl(url);
                        newsObject.setImageUrl(imageUrl);
    
                        news.add(newsObject);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }
    

    public String getNewsAPIUrl(){
        return apiUrl;
    }
    
}
