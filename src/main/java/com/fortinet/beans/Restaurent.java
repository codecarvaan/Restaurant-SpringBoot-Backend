package com.fortinet.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Table(name = "restaurent")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Restaurent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Basic
    @Enumerated(EnumType.STRING)
    @Type(type = "org.hibernate.type.EnumType")
    @Column(name = "HasTableBooking", nullable = false, columnDefinition = "enum('Yes','No')")
    private HasTableBooking hasTableBooking;


    @Basic
    @Enumerated(EnumType.STRING)
    @Type(type = "org.hibernate.type.EnumType")
    @Column(name = "HasOnline", nullable = false, columnDefinition = "enum('Yes','No')")
    private HasOnline hasOnline;


    @Column(name = "RatingColor", nullable = false)
    private String ratingColor;


    @Column(name = "RatingText", nullable = false)
    private String ratingText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HasTableBooking getHasTableBooking() {
        return hasTableBooking;
    }

    public void setHasTableBooking(HasTableBooking hasTableBooking) {
        this.hasTableBooking = hasTableBooking;
    }

    public HasOnline getHasOnline() {
        return hasOnline;
    }

    public void setHasOnline(HasOnline hasOnline) {
        this.hasOnline = hasOnline;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCuisines() {
        return Cuisines;
    }

    public void setCuisines(String cuisines) {
        Cuisines = cuisines;
    }

    public int getAverageCostforTwo() {
        return AverageCostforTwo;
    }

    public void setAverageCostforTwo(int averageCostforTwo) {
        AverageCostforTwo = averageCostforTwo;
    }

    public float getAggregaterating() {
        return Aggregaterating;
    }

    public void setAggregaterating(float aggregaterating) {
        Aggregaterating = aggregaterating;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public int getVotes() {
        return Votes;
    }

    public void setVotes(int votes) {
        Votes = votes;
    }

    @Column(name = "RestaurantName", nullable = false)
    private String Name;

    @Column(name = "Cuisines", nullable = false)
    private String Cuisines;

    @Column(name="AverageCostfortwo")
    private int AverageCostforTwo;

    @Column(name="Aggregaterating")
    private float Aggregaterating;

    @Column(name="Currency")
    private String  Currency;

    @Column(name="Votes")
    private int Votes;

    public int getVisitors() {
        return Visitors;
    }

    public void setVisitors(int visitors) {
        Visitors = visitors;
    }

    @Column(name="Visitors")
    private int Visitors;

    public enum HasTableBooking {
        Yes,No
    }
    public enum HasOnline{
        Yes,No
    }



}
