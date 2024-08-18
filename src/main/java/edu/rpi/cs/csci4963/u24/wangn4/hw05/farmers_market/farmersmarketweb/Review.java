package edu.rpi.cs.csci4963.u24.wangn4.hw05.farmers_market.farmersmarketweb;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;
    private int FMID;
    private String username;
    private String review;
    private int rating;

    // Getters
    public int getReview_id() {
        return review_id;
    }

    public int getFMID() {
        return FMID;
    }

    public String getUsername() {
        return username;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    // Setters
    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public void setFMID(int FMID) {
        this.FMID = FMID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}