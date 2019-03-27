package com.fortinet.validator;

import com.fortinet.beans.Restaurent;

import com.fortinet.beans.RestaurentAddress;
import com.fortinet.service.RestaurentsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class RestaurentsValidator {
    @Autowired
    RestaurentsService restaurentsService;
    public List<Restaurent> validGetAllRestaurents() {

        List<Restaurent> restaurent=  restaurentsService.ServiceGetAllRestaurents();
        return restaurent;
    }

    public Restaurent validgetRestaurentByName(String restaurentName) {
        Restaurent restaurents=  restaurentsService.ServiceGetRestaurentByName(restaurentName);
        return restaurents;

    }

    public Restaurent validgetRestaurentById(int restaurentId) {
        Restaurent restaurents=  restaurentsService.ServiceGetRestaurentById(restaurentId);
        return restaurents;
    }

    public List<Restaurent> validgetRestaurentByCuisines(JSONObject restaurentCuisines) {
        List<Restaurent> restaurents=  restaurentsService.ServiceGetRestaurentByCuisines(restaurentCuisines);
        return restaurents;
    }

    public List<Restaurent> validgetCategoryRestaurents(JSONObject restaurentTop) {
        List<Restaurent> restaurents=  restaurentsService.ServicegetCategoryRestaurents(restaurentTop);
        return restaurents;
    }

    public RestaurentAddress validgetAddress(int restaurentId) {
        return restaurentsService.ServicegetAddress(restaurentId);
    }

    public List validgetRestaurentByCuisines() {
        return restaurentsService.ServicegetRestaurentByCuisines();
    }
}
