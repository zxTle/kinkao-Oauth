package th.ac.ku.eateat.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.eateat.model.Restuarant;

import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantServices {

    @Autowired
    private RestTemplate restTemplate;

    public List<Restuarant> getAll() {
        String url = "http://localhost:8090/restaurant";
        ResponseEntity<Restuarant[]> response =
                restTemplate.getForEntity(url, Restuarant[].class);
        Restuarant[] restaurants = response.getBody();
        return Arrays.asList(restaurants);
    }

    public void addRestaurant(Restuarant restaurant) {
        String url = "http://localhost:8090/restaurant";

        restTemplate.postForObject(url, restaurant, Restuarant.class);
    }
}