package com.fortinet.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "restaurentAddress")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RestaurentAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "RestaurantID", nullable = false)
    private int RestaurantID;
    @Column(name = "CountryCode", nullable = false)
    private String CountryCode;
    @Column(name = "City")
    private String City;
    @Column(name = "Address")
    private String Address;
    @Column(name = "LocalityVerbose")
    private String LocalityVerbose;
    @Column(name = "Longitude")
    private String Longitude;
    @Column(name = "Latitude")
    private String Latitude;

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        RestaurantID = restaurantID;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLocalityVerbose() {
        return LocalityVerbose;
    }

    public void setLocalityVerbose(String localityVerbose) {
        LocalityVerbose = localityVerbose;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }


}
