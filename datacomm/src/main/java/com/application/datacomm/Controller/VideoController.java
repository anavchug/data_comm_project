package com.application.datacomm.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.datacomm.DataObject.Video;
import com.application.datacomm.RestAPI.Request;
import com.application.datacomm.RestAPI.YoutubeApi;

import java.util.List;


@RestController
public class VideoController {


    @GetMapping("/video")
    public List<Video> video(@RequestParam(value ="category", defaultValue = "25") String videoCategory) throws Exception{

       YoutubeApi request = new YoutubeApi("US",videoCategory,12);
       String videoUrl = request.getVideoAPIUrl();
       String result = Request.makeRequest(videoUrl);

       // Parses json and returns Video record
       return YoutubeApi.parseJson(result);


    }


    
}
