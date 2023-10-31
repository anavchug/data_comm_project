package com.application.datacomm.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.datacomm.Video;
import com.application.datacomm.YoutubeApi;


@RestController
public class VideoController {


    @GetMapping("/video")
    public Video video() throws Exception{

       YoutubeApi request = new YoutubeApi("US",10);
       String result = request.makeRequest();

       // Parses json and returns Video record
       return YoutubeApi.parseJson(result);


    }


    
}
