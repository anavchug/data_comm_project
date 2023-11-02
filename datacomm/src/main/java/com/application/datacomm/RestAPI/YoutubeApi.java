package com.application.datacomm.RestAPI;

import org.json.JSONArray;
import org.json.JSONObject;

import com.application.datacomm.DataObject.Video;

import java.util.List;
import java.util.ArrayList;

public class YoutubeApi {
    private String apiKey = APIKeys.YOUTUBE_KEY;
    private String apiUrl = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet&chart=mostPopular";


    public YoutubeApi(String region,int maxResults){

        apiUrl+= "&maxResults=" + Integer.toString(maxResults);
        apiUrl+= "&regionCode=" + region;
        apiUrl+= "&videoCategoryId=25";
        apiUrl+= "&key=" + this.apiKey;
    }

    public static List<Video> parseJson(String jsonData){

        String videoStub = "https://www.youtube.com/watch?v=";
        
        JSONObject json = new JSONObject(jsonData);
        JSONArray items = json.getJSONArray("items");

        List<Video> videoItems = new ArrayList<>();


        for(int i = 0; i < items.length(); i++){

            JSONObject video = items.getJSONObject(i);
            JSONObject videoSnip = video.getJSONObject("snippet");
            JSONObject thumb = videoSnip.getJSONObject("thumbnails");
            JSONObject size = thumb.getJSONObject("medium");

            
            String videoUrl = videoStub + video.getString("id");
            String videoTitle = videoSnip.getString("title");
            //String videoDesc = videoSnip.getString("description");
            String thumbUrl = size.getString("url");


            videoItems.add(new Video(videoTitle, videoUrl, thumbUrl));

       }

       
       return videoItems;
    }

    public String getVideoAPIUrl(){
        return apiUrl;
    }

}
