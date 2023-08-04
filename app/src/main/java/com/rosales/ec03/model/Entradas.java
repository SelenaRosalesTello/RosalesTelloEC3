package com.rosales.ec03.model;

public class Entradas extends Principal {

    private String sagaName ;
    public Entradas(String name, String imgUrl, String sagaName) {
        super(name, imgUrl);
        this.sagaName = sagaName;
    }

    public String getSagaName() {
        return sagaName;
    }

    public void setSagaName(String sagaName) {
        this.sagaName = sagaName;
    }
}
