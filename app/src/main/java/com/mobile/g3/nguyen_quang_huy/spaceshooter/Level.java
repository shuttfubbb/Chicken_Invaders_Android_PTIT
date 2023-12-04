package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import java.io.Serializable;

public class Level implements Serializable {
    private int id;
    private String name;
    private double speedCoeff;
    private double quantityCoeff;

    public Level(int id, String name, double speedCoeff, double quantityCoeff) {
        this.id = id;
        this.name = name;
        this.speedCoeff = speedCoeff;
        this.quantityCoeff = quantityCoeff;
    }

    public Level() {
        this.id = 1;
        this.name = "Easy";
        this.speedCoeff = 1;
        this.quantityCoeff = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeedCoeff() {
        return speedCoeff;
    }

    public void setSpeedCoeff(double speedCoeff) {
        this.speedCoeff = speedCoeff;
    }

    public double getQuantityCoeff() {
        return quantityCoeff;
    }

    public void setQuantityCoeff(double quantityCoeff) {
        this.quantityCoeff = quantityCoeff;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
