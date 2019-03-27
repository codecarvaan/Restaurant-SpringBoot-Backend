package com.fortinet.controller;

import com.fortinet.beans.Restaurent;
import com.fortinet.beans.RestaurentAddress;
import com.fortinet.validator.RestaurentsValidator;
import org.hibernate.Criteria;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = {"Api/restaurents"})
public class RestaurantController {
    @Autowired
    RestaurentsValidator restaurentValidator;

    @GetMapping(value = "/status", headers = "Accept=application/json")
    public String getAllCompany() {
        return "Restaurant API Running ";
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurent> getAllRestaurents(){
        return restaurentValidator.validGetAllRestaurents();
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurent getRestaurentByName(@PathVariable("name") String RestaurentName){
        return restaurentValidator.validgetRestaurentByName(RestaurentName);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurent getRestaurentById(@PathVariable("id") int RestaurentId){
        return restaurentValidator.validgetRestaurentById(RestaurentId);
    }

    @GetMapping(value = "/cusines", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurent> getRestaurentByCuisines(@RequestBody String RestaurantCuisines){


        JSONObject js=new JSONObject(RestaurantCuisines);
        return restaurentValidator.validgetRestaurentByCuisines(js);
    }

    @PostMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurent> getCategoryRestaurents(@RequestBody String RestaurantTop){
        JSONObject js=new JSONObject(RestaurantTop);
        return restaurentValidator.validgetCategoryRestaurents(js);
    }

    @GetMapping(value = "/address/{restraunt}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestaurentAddress getAddress(@PathVariable("restraunt") int RestaurantId){

        return restaurentValidator.validgetAddress(RestaurantId);
    }
    @GetMapping(value = "/cusines/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public List getRestaurentByCuisines() {

        return restaurentValidator.validgetRestaurentByCuisines();
    }

}
