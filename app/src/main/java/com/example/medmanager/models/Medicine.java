package com.example.medmanager.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "medicines")
public class Medicine {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "medicineId")
    private int id;
    @NonNull
    private String name;

    private String validity;

    private int quantity;

    private Double unityPrice;

    @Ignore
    public Medicine(int id, String name, String validity, int quantity, Double unityPrice) {
        this.id = id;
        this.name = name;
        this.validity = validity;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
    }

    public Medicine(@NonNull String name, String validity, int quantity, Double unityPrice) {
        this.name = name;
        this.validity = validity;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
    }

    @Ignore
    public Medicine() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
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

    /*
    public void setId(int id) {
        this.id = id;
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
    }*/
}
