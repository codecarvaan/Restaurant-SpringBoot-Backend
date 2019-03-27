package com.fortinet.service;

import com.fortinet.beans.Restaurent;
import com.fortinet.beans.RestaurentAddress;
import com.fortinet.dao.RestaurentDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RestaurentsServiceImp implements RestaurentsService{
    @Autowired
    private RestaurentDao restaurentDao;
    @Override
    public List<Restaurent> ServiceGetAllRestaurents() {
        return restaurentDao.DAOGetAllRestaurents();
    }

    @Override
    public Restaurent ServiceGetRestaurentByName(String restaurentName) {
        return restaurentDao.DAOGetRestaurentByName(restaurentName);
    }

    @Override
    public Restaurent ServiceGetRestaurentById(int restaurentId) {
        return restaurentDao.DAOGetRestaurentById(restaurentId);
    }

    @Override
    public List<Restaurent> ServiceGetRestaurentByCuisines(JSONObject restaurentCuisines) {
        return restaurentDao.DAOGetRestaurentByCuisines(restaurentCuisines);
    }

    @Override
    public List<Restaurent> ServicegetCategoryRestaurents(JSONObject restaurentTop) {
        return restaurentDao.DAOgetCategoryRestaurents(restaurentTop);
    }

    @Override
    public RestaurentAddress ServicegetAddress(int restaurentId) {
        return restaurentDao.getAddress(restaurentId);
    }

    @Override
    public List ServicegetRestaurentByCuisines() {
        return restaurentDao.DAOgetgetRestaurentByCuisines();
    }
}
