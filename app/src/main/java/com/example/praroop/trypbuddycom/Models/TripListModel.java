package com.example.praroop.trypbuddycom.Models;

/**
 * Created by PRAROOP on 30-12-2018.
 */

public class TripListModel {
    String id;
    String forgroup;
    String trip_name;
    String trip_image;
    String trip_days;
    String trip_fare;
    String category_id;
    String trip_discount;
    String trip_from;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForgroup() {
        return forgroup;
    }

    public void setForgroup(String forgroup) {
        this.forgroup = forgroup;
    }

    public String getTrip_name() {
        return trip_name;
    }

    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }

    public String getTrip_image() {
        return trip_image;
    }

    public void setTrip_image(String trip_image) {
        this.trip_image = trip_image;
    }

    public String getTrip_days() {
        return trip_days;
    }

    public void setTrip_days(String trip_days) {
        this.trip_days = trip_days;
    }

    public String getTrip_fare() {
        return trip_fare;
    }

    public void setTrip_fare(String trip_fare) {
        this.trip_fare = trip_fare;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getTrip_discount() {
        return trip_discount;
    }

    public void setTrip_discount(String trip_discount) {
        this.trip_discount = trip_discount;
    }

    public String getTrip_from() {
        return trip_from;
    }

    public void setTrip_from(String trip_from) {
        this.trip_from = trip_from;
    }

    public String getTrip_to() {
        return trip_to;
    }

    public void setTrip_to(String trip_to) {
        this.trip_to = trip_to;
    }

    String trip_to;
}
