package com.dem.restassure;

/**
 * Created by volod on 02-Apr-17.
 */
public class Car {
    private String model;
    private String id;

    public Car(){

    }

    public Car(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
