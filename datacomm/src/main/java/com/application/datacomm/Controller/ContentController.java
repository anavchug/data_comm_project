package com.application.datacomm.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

@RestController
public class ContentController {

    @GetMapping("/")
    public ResponseEntity<InputStreamResource> main() throws IOException {
        ClassPathResource htmlFile = new ClassPathResource("templates/index.html");
        String htmlContent = new String(htmlFile.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        return ResponseEntity
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(new InputStreamResource(new ByteArrayInputStream(htmlContent.getBytes())));
    }
     @GetMapping("/about")
    public ResponseEntity<InputStreamResource> about() throws IOException {
        ClassPathResource htmlFile = new ClassPathResource("templates/about.html");
        String htmlContent = new String(htmlFile.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        return ResponseEntity
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(new InputStreamResource(new ByteArrayInputStream(htmlContent.getBytes())));
    }
}
