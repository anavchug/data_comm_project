package com.application.datacomm.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.datacomm.RestAPI.Video;
import com.application.datacomm.RestAPI.YoutubeApi;

import java.util.List;


@RestController
public class VideoController {


    @GetMapping("/video")
    public List<Video> video() throws Exception{

       YoutubeApi request = new YoutubeApi("US",10);
       String result = request.makeRequest();

       // Parses json and returns Video record
       return YoutubeApi.parseJson(result);


    }


    
}
