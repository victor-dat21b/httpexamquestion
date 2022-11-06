package com.example.httpprotocol.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HttpDemoController {

    @GetMapping("/redirect")
    void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("redirect.html");
    }

    @GetMapping("/uups")
    void ups(HttpServletResponse response) throws IOException {
        int x = 100/0;
    }

    @GetMapping("/listHeaders")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        String foundHeaders = headers.keySet().stream().map(key -> key + " : "+headers.get(key)).
                collect(Collectors.joining("<br/>"));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_HTML);
        return new ResponseEntity<String>(foundHeaders,responseHeaders, HttpStatus.OK);
    }


}
