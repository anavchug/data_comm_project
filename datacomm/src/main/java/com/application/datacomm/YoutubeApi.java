package com.application.datacomm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class YoutubeApi {


    // Replace later
    String apiKey = "AIzaSyA-nMg2ZxQoSos_Z0GzEqk8MkQFAWVE70E";
    String apiUrl = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet&chart=mostPopular";


    public YoutubeApi(String region,int maxResults){

        apiUrl+= "&maxResults=" + Integer.toString(maxResults);
        apiUrl+= "&regionCode=" + region;
        apiUrl+= "&key=" + this.apiKey;
    }

    public static Video parseJson(String jsonData){

        String videoStub = "https://www.youtube.com/watch?v=";
        
        JSONObject json = new JSONObject(jsonData);
        JSONArray items = json.getJSONArray("items");

        Item[] videoItems = new Item[items.length()];


        for(int i = 0; i < items.length(); i++){

            JSONObject video = items.getJSONObject(i);
            JSONObject videoSnip = video.getJSONObject("snippet");
            JSONObject thumb = videoSnip.getJSONObject("thumbnails");
            JSONObject size = thumb.getJSONObject("medium");

            
            String videoUrl = videoStub + video.getString("id");
            String videoTitle = videoSnip.getString("title");
            String videoDesc = videoSnip.getString("description");
            String thumbUrl = size.getString("url");


            videoItems[i] = new Item(videoTitle, videoDesc, videoUrl, thumbUrl);


       }

       return new Video(videoItems);


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
