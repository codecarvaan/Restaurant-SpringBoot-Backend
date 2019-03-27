package com.fortinet.dao;


import com.fortinet.beans.Cuisines;
import com.fortinet.beans.Restaurent;
import com.fortinet.beans.RestaurentAddress;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestaurentDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurent> DAOGetAllRestaurents() {

        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Restaurent.class);
        List<Restaurent> restaurent = cr.list();

        return restaurent;
    }

    public Restaurent DAOGetRestaurentByName(String restaurentName) {
        Session session = sessionFactory.getCurrentSession();
        Restaurent restaurent;
        Criteria cr = session.createCriteria(Restaurent.class);
        System.out.println("restaurentName"+restaurentName);
        cr.add(Restrictions.like("Name", restaurentName));
        restaurent = (Restaurent) cr.list().get(0);
        restaurent.setVisitors(restaurent.getVisitors() + 1);
        session.saveOrUpdate(restaurent);
        return restaurent;


    }

    public Restaurent DAOGetRestaurentById(int restaurentId) {
        Session session = sessionFactory.getCurrentSession();
        Restaurent restaurent = session.get(Restaurent.class, restaurentId);

        return DAOGetRestaurentByName(restaurent.getName());

    }

    public List<Restaurent> DAOGetRestaurentByCuisines(JSONObject restaurentCuisines) {
        String cuisines = restaurentCuisines.get("cuisines").toString();

        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Restaurent.class);
        cr.add(Restrictions.like("Cuisines", "%" + cuisines + "%"));

        String orderby = restaurentCuisines.get("orderBy").toString();
        String order = restaurentCuisines.get("order").toString();
        if (order.equals("asc")) {
            cr.addOrder(Order.asc(orderby));
        } else {
            cr.addOrder(Order.desc(orderby));
        }

//Votes AverageCostforTwo Aggregaterating

        List<Restaurent> restaurent = cr.list();
        return restaurent;
    }

    public List<Restaurent> DAOgetCategoryRestaurents(JSONObject restaurentTop) {
        int limit = Integer.parseInt(restaurentTop.get("limit").toString());
        String orderBy = restaurentTop.get("orderBy").toString();

        String cuisines[] = restaurentTop.get("cuisines").toString().split(",");
        String hasTableBooking=restaurentTop.get("hasTableBooking").toString();
        String hasOnline=restaurentTop.get("hasOnline").toString();

        String order = restaurentTop.get("order").toString();
        System.out.println("comingh");
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Restaurent.class);

        if(!hasTableBooking.equals("both")) {
            Restaurent.HasTableBooking tableval= Restaurent.HasTableBooking.valueOf(hasTableBooking);
            cr.add(Restrictions.eq("hasTableBooking",tableval));
        }
        if(!hasOnline.equals("both")) {
            Restaurent.HasOnline tableval= Restaurent.HasOnline.valueOf(hasOnline);
            cr.add(Restrictions.eq("hasOnline",tableval));
        }
        if(order.equals("desc")){
            cr.addOrder(Order.desc(orderBy));
        }
        else if(order.equals("asc")){
            cr.addOrder(Order.asc(orderBy));
        }
       if(limit!=0){
        cr.setMaxResults(limit);
       }
       if(cuisines.length!=0) {

           Disjunction objDisjunction = Restrictions.disjunction();
           for (int i = 0; i < cuisines.length; i++) {

               Criterion cui = Restrictions.like("Cuisines", "%" + cuisines[i] + "%");
               objDisjunction.add(cui);
           }
           cr.add(objDisjunction);
       }
        return cr.list();
    }

    public RestaurentAddress getAddress(int restaurentId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(RestaurentAddress.class);
        cr.add(Restrictions.eq("RestaurantID", restaurentId));
        return (RestaurentAddress) cr.list().get(0);
    }

    public List DAOgetgetRestaurentByCuisines() {
        Session session=sessionFactory.getCurrentSession();
        Criteria cr=session.createCriteria(Cuisines.class);
        List<HashMap> countlist=new ArrayList();
        List ls=cr.list();
        for(int i=0;i<ls.size();i++){
            Criteria ResCr=session.createCriteria(Restaurent.class);
            String nameC=new JSONObject(cr.list().get(i)).getString("cuisineName");
            ResCr.add(Restrictions.like("Cuisines","%" +nameC + "%"));
            ResCr.setProjection(Projections.rowCount());
            HashMap jb=new HashMap();
            jb.put("Name",nameC);
            jb.put("CountRestaurants",ResCr.uniqueResult());
            countlist.add(jb);
        }
        return  countlist;
    }
}
