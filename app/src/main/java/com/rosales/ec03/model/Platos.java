package com.rosales.ec03.model;

public class Platos extends Principal {
    private int season;


    public Platos(String name, String imgUrl, int season) {
        super(name, imgUrl);
        this.season = season;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
