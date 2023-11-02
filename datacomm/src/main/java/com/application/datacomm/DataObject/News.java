package com.application.datacomm.DataObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class News {
    private String title;
    private String description;
    private String content;
    private String url;

    @JsonProperty("urlToImage")
    private String urlToImage;
    
    // Getters
    public String getTitle(){
        return title;
    }
      public String getDescription(){
        return description;
    }
     public String getContent(){
        return content;
    }
    public String getUrl(){
        return url;
    }
    public String getImageUrl(){
        return urlToImage;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    // public void setA

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImageUrl(String urlToImage) {
        this.urlToImage = urlToImage;
    }

}

