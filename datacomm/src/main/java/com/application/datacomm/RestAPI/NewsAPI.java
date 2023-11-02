package com.application.datacomm.RestAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NewsAPI {
    String apiKey = ""; //Put your api key here
    String apiUrl = "https://newsapi.org/v2/top-headlines";

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
    
                // Handle exceptions when extracting data
                try {
                    String title = articleObject.getString("title");
                    String description = articleObject.optString("description", "No Description");
                    String url = articleObject.getString("url");
                    String content = articleObject.optString("content", "");
                    String imageUrl = articleObject.optString("urlToImage", "");
    
                    News newsObject = new News();
                    newsObject.setTitle(title);
                    newsObject.setDescription(description);
                    newsObject.setContent(content);
                    newsObject.setUrl(url);
                    newsObject.setImageUrl(imageUrl);
    
                    news.add(newsObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }
    
     public String makeRequest() throws Exception{

        URL request = new URL(this.apiUrl);
        HttpURLConnection con = (HttpURLConnection) request.openConnection();
        con.setRequestMethod("GET");
        
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        con.disconnect();

        return content.toString();

    }
}
