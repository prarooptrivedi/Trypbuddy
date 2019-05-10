package com.example.praroop.trypbuddycom.Models;

public class HotelProfileModel {
    private Integer hpimg;
    private String hpname,hpnotxt;

    public String getHpnotxt() {
        return hpnotxt;
    }

    public void setHpnotxt(String hpnotxt) {
        this.hpnotxt = hpnotxt;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }

    public Integer getHpimg() {
        return hpimg;
    }

    public void setHpimg(Integer hpimg) {
        this.hpimg = hpimg;
    }

    public String getHpname() {
        return hpname;
    }

    public void setHpname(String hpname) {
        this.hpname = hpname;
    }


    String transport,food,activity,guide,accomodation;
}
