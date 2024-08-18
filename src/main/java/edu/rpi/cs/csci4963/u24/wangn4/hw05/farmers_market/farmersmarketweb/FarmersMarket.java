package edu.rpi.cs.csci4963.u24.wangn4.hw05.farmers_market.farmersmarketweb;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class FarmersMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int FMID;
    private String MarketName;
    private String Website;
    private String Facebook;
    private String Twitter;
    private String Youtube;
    private String OtherMedia;
    private String street;
    private String city;
    private String County;
    private String State;
    private String zip;
    private String Season1Date;
    private String Season1Time;
    private String Season2Date;
    private String Season2Time;
    private String Season3Date;
    private String Season3Time;
    private String Season4Date;
    private String Season4Time;
    private double x;
    private double y;
    private String Location;
    private boolean Credit;
    private boolean WIC;
    private boolean WICcash;
    private boolean SFMNP;
    private boolean SNAP;
    private boolean Organic;
    private boolean Bakedgoods;
    private boolean Cheese;
    private boolean Crafts;
    private boolean Flowers;
    private boolean Eggs;
    private boolean Seafood;
    private boolean Herbs;
    private boolean Vegetables;
    private boolean Honey;
    private boolean Jams;
    private boolean Maple;
    private boolean Meat;
    private boolean Nursery;
    private boolean Nuts;
    private boolean Plants;
    private boolean Poultry;
    private boolean Prepared;
    private boolean Soap;
    private boolean Trees;
    private boolean Wine;
    private boolean Coffee;
    private boolean Beans;
    private boolean Fruits;
    private boolean Grains;
    private boolean Juices;
    private boolean Mushrooms;
    private boolean PetFood;
    private boolean Tofu;
    private boolean WildHarvested;
    private String updateTime;
    private int review_count;
    private double average_rating;

    // No-argument constructor
    public FarmersMarket() {}

    // Getters
    public int getFMID() {
        return FMID;
    }

    public String getMarketName() {
        return MarketName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return County;
    }

    public String getState() {
        return State;
    }

    public String getZip() {
        return zip;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAverage_rating() {
        return average_rating;
    }

    public int getReview_count() {

        return review_count;
    }

    // Setters
    public void setFMID(int FMID) {
        this.FMID = FMID;
    }

    public void setMarketName(String MarketName) {
        this.MarketName = MarketName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCounty(String County) {
        this.County = County;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setAverage_rating(double average_rating) {
        this.average_rating = average_rating;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }
}