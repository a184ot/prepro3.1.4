package com.example.demo314;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class Post_postForEntity_Example {




    static final String URL_CREATE_EMPLOYEE = "http://91.241.64.178:7081/api/users";


    public Post_postForEntity_Example(List<String> myCookie) {

    }

    public static void main(String[] args) {


        User newUser = new User(3, "James", "Brown",44);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return XML format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");



        // Data attached to the request.
        HttpEntity<User> requestBody = new HttpEntity<>(newUser);

        // Send request with POST method.
        ResponseEntity<User> result
                = restTemplate.postForEntity(URL_CREATE_EMPLOYEE, requestBody, User.class);

        System.out.println("Status code:" + result.getStatusCode());

        // Code = 200.
        if (result.getStatusCode() == HttpStatus.OK) {
            User e = result.getBody();
            System.out.println("(Client Side) Employee Created: "+ e.getId());
        }

    }

}