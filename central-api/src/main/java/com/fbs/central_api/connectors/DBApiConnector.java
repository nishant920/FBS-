package com.fbs.central_api.connectors;

import com.fbs.central_api.dto.AllUserDto;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class DBApiConnector {

    RestTemplate restTemplate;

    public DBApiConnector(RestTemplate restTemplate){
        this.restTemplate=restTemplate;

    }

    @Value("${db.api.url}")
    String dbApiBaseUrl;

    public AppUser callCreateUserEndpoint(AppUser user){
        log.info("Inside callCreateUserEndpoint method with user object: " + user.toString());

        String url = dbApiBaseUrl + "/user/create";

        RequestEntity<AppUser> request = RequestEntity.post(url).body(user);
        log.info("Created request : " + request.toString());

        log.info("Calling dbApi create user endpoint");
        ResponseEntity<AppUser> response = restTemplate.exchange(url, HttpMethod.POST, request, AppUser.class);
        log.info("Responce: " + response.toString());
       return response.getBody();
    }

    public Airline callCreateAirlineEndpoint(Airline airline){
        log.info("Inside callCreateAirlineEndpoint with payload: " + airline.toString());
        // 1. Create url
        String url = dbApiBaseUrl + "/airline/create";
        // 2. create request
        RequestEntity request = RequestEntity.post(url).body(airline);
        // 3. Create resttemplate object
        // 4. By using restTemplate.exchange method to call this endpoint
        ResponseEntity<Airline> response = restTemplate.exchange(url, HttpMethod.POST, request, Airline.class);
        return response.getBody();
    }

    public List<AppUser> callGetAllUsersByUserType(String userType){
        String url = dbApiBaseUrl + "/user/get/"+ userType;

        RequestEntity request = RequestEntity.get(url).build();

        ResponseEntity<AllUserDto> response = restTemplate.exchange(url, HttpMethod.GET, request, AllUserDto.class);
        return response.getBody().getAppUsers();

    }
    public Airline callGetAirlineByIdEndpoint(UUID airlineId){
        String url = dbApiBaseUrl + "/airline/" + airlineId.toString();

        RequestEntity request = RequestEntity.get(url).build();
        ResponseEntity<Airline> resp = restTemplate.exchange(url, HttpMethod.GET, request, Airline.class);
        return resp.getBody();
    }

    public Airline callUpdateAirlineEndpoint(Airline airline){
        String url = dbApiBaseUrl + "/airline/update";
        RequestEntity request = RequestEntity.put(url).body(airline);
        ResponseEntity<Airline> response = restTemplate.exchange(url, HttpMethod.PUT, request, Airline.class);
        return response.getBody();
    }

    public AppUser callUpdateUserEndpoint(AppUser user){
        String url = dbApiBaseUrl + "/user/update";
        RequestEntity request = RequestEntity.put(url).body(user);

        ResponseEntity<AppUser> resp = restTemplate.exchange(url, HttpMethod.PUT, request, AppUser.class);
        return resp.getBody();
    }

    public AppUser callGetUserByEmailEndpoint(String email){
        // Are we having any endpoint related to this.
        String url = dbApiBaseUrl + "/user/email/" + email;
        RequestEntity request = RequestEntity.get(url).build();
        ResponseEntity<AppUser> resp = restTemplate.exchange(url, HttpMethod.GET, request, AppUser.class);
        return resp.getBody();
    }

 //  public AppUser callGetAirlineByAdminIdEndpoint(UUID adminId){
 //      String url = dbApiBaseUrl + "/airline/get/admin/" +  adminId.toString();
 //      RequestEntity request = RequestEntity.get(url).build();
 //      ResponseEntity<Airline> resp = restTemplate.exchange(url, HttpMethod.GET, request, Airline.class);
 //      return resp.getBody();
 //  }


}
