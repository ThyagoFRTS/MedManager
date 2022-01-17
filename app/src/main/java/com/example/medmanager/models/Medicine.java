package com.example.medmanager.models;

public class Medicine {
    private String id;
    private String name;
    private String validity;
    private int quantity;
    private Double unityPrice;

    public Medicine(String id, String name, String validity, int quantity, Double unityPrice) {
        this.id = id;
        this.name = name;
        this.validity = validity;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
    }

    public Medicine(String name, String validity, int quantity, Double unityPrice) {
        this.name = name;
        this.validity = validity;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
    }

    public Medicine() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnityPrice() {
        return unityPrice;
    }

    public void setUnityPrice(Double unityPrice) {
        this.unityPrice = unityPrice;
    }
}
