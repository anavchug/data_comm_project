package com.application.datacomm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class YoutubeApi {


    // Replace later
    String apiKey = "AIzaSyA-nMg2ZxQoSos_Z0GzEqk8MkQFAWVE70E";
    String apiUrl = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet&chart=mostPopular";


    YoutubeApi(String region,int maxResults){

        apiUrl+= "&maxResults=" + Integer.toString(maxResults);
        apiUrl+= "&regionCode=" + region;
        apiUrl+= "&key=" + this.apiKey;
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
