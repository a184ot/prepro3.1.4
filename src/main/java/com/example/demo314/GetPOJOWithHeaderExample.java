package com.example.demo314;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class GetPOJOWithHeaderExample {


    static final String URL_EMPLOYEES = "http://91.241.64.178:7081/api/users";

    public static void main(String[] args) {

        String levelCode="";
        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return XML format
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HttpEntity<Employee[]>: To get result as Employee[].
        HttpEntity<User[]> entity = new HttpEntity<User[]>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers.
        ResponseEntity<User[]> response = restTemplate.exchange(URL_EMPLOYEES,
                HttpMethod.GET, entity, User[].class);

        HttpStatus statusCode = response.getStatusCode();
        System.out.println("Response Satus Code: " + statusCode);
        List<String> myCookie = response.getHeaders().get("Set-Cookie");
        HttpHeaders myHeader = response.getHeaders();
        System.out.println(response.getHeaders().get("Set-Cookie"));
        System.out.println(myCookie);

        // Status Code: 200
        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            User[] list = response.getBody();

            if (list != null) {
                for (User e : list) {
                    System.out.println("Employee: " + e.getId() + " - " +
                            e.getName() + " - " + e.getLastName() + " - " + e.getAge());
                }
            }
        }

        System.out.println("-------------------------GET is over-------------------------------");
//----------------------POST-----------------vvvvvvvvvvvvvvvvvvvvvvvvvvvvv---------------------------
        System.out.println("-------------------------POST start--------------------------------- ");
        System.out.println(myHeader);
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return XML format
        headers.setContentType(MediaType.APPLICATION_JSON);
        String cook = myCookie.get(0);
        System.out.println("cookies"+cook);
        headers.set("COOKIE",cook);
        System.out.println("header>>>"+ headers);
        User newUser = new User(3, "James", "Brown",44);
        HttpEntity<User> entity2 = new HttpEntity<User>(newUser,headers);
        ResponseEntity<String> response2 = restTemplate.exchange(URL_EMPLOYEES,
                HttpMethod.POST, entity2, String.class);
        HttpStatus statusCode2 = response2.getStatusCode();
        System.out.println("Response Satus Code: " + statusCode2);
        List<String> myCookie2 = response.getHeaders().get("Set-Cookie");
        System.out.println("response2 headers");
        System.out.println(response2.getHeaders());
        System.out.println("response2 (first part of code)");
        System.out.println(response2.getBody());
        levelCode = levelCode.concat(response2.getBody());
        System.out.println("--------------POST is over________________________________");
//        --------------------------------POST---------------AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA_________________

        //----------------------PUT-----------------vvvvvvvvvvvvvvvvvvvvvvvvvvvvv---------------------------
        System.out.println("------------------------PUT start-----------------------------");
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");
        List<String> myCookie3 = response2.getHeaders().get("Set-Cookie");
        System.out.println(myCookie3);
        headers.set("COOKIE",cook);
        System.out.println("header>>>"+ headers);
        System.out.println("cookies"+cook);
        User editUser = new User(3, "Thomas", "Shelby",44);
        HttpEntity<User> entity3 = new HttpEntity<User>(editUser,headers);
        ResponseEntity<String> response3 = restTemplate.exchange(URL_EMPLOYEES,
                HttpMethod.PUT, entity3, String.class);
        HttpStatus statusCode3 = response3.getStatusCode();
        System.out.println("Response Satus Code: " + statusCode3);
        List<String> myCookie4 = response3.getHeaders().get("Set-Cookie");
        System.out.println("response3 headers");
        System.out.println(response3.getHeaders());
        System.out.println("response3 (second part of code)");
        System.out.println(response3.getBody());
        levelCode = levelCode.concat(response3.getBody());

        System.out.println("-----------------------PUT is over-------------------------");
//        --------------------------------PUT---------------AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA_________________

        //----------------------DELETE-----------------vvvvvvvvvvvvvvvvvvvvvvvvvvvvv---------------------------
        System.out.println("------------------------DELETE start-----------------------------");
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");
        System.out.println(myCookie3);
        headers.set("COOKIE",cook);
        System.out.println("header>>>"+ headers);
        System.out.println("cookies"+cook);
        HttpEntity<User> entity4 = new HttpEntity<User>(editUser,headers);
        final String URL_EMPLOYEES_DEL = URL_EMPLOYEES.concat("/3");
        ResponseEntity<String> response4 = restTemplate.exchange(URL_EMPLOYEES_DEL,
                HttpMethod.DELETE, entity4, String.class);
        HttpStatus statusCode4 = response4.getStatusCode();
        System.out.println("Response Satus Code: " + statusCode4);
        System.out.println("response4 headers");
        System.out.println(response4.getHeaders());
        System.out.println("response4 (third part of code)");
        System.out.println(response4.getBody());
        levelCode = levelCode.concat(response4.getBody());
        System.out.println("-----------------------DELETE is over-------------------------");
//        --------------------------------DELETE---------------AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA_________________


        System.out.println("code for JM platform: "+ levelCode);
    }

}





