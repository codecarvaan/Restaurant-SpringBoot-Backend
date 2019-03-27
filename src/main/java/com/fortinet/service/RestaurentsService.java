package com.fortinet.service;


import com.fortinet.beans.Restaurent;
import com.fortinet.beans.RestaurentAddress;
import org.json.JSONObject;

import java.util.List;

public interface RestaurentsService {
    List<Restaurent> ServiceGetAllRestaurents();

    Restaurent ServiceGetRestaurentByName(String restaurentName);

    Restaurent ServiceGetRestaurentById(int restaurentId);

    List<Restaurent> ServiceGetRestaurentByCuisines(JSONObject restaurentCuisines);

    List<Restaurent> ServicegetCategoryRestaurents(JSONObject restaurentTop);

    RestaurentAddress ServicegetAddress(int restaurentId);

    List ServicegetRestaurentByCuisines();
}
