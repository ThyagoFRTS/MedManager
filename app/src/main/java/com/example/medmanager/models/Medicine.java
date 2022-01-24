package com.example.medmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "medicines")
public class Medicine implements Parcelable {
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

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", validity='" + validity + '\'' +
                ", quantity=" + quantity +
                ", unityPrice=" + unityPrice +
                '}';
    }

    protected Medicine(Parcel in) {
        id = in.readInt();
        name = in.readString();
        validity = in.readString();
        quantity = in.readInt();
        if (in.readByte() == 0) {
            unityPrice = null;
        } else {
            unityPrice = in.readDouble();
        }
    }

    public static final Creator<Medicine> CREATOR = new Creator<Medicine>() {
        @Override
        public Medicine createFromParcel(Parcel in) {
            return new Medicine(in);
        }

        @Override
        public Medicine[] newArray(int size) {
            return new Medicine[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(validity);
        dest.writeInt(quantity);
        if (unityPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(unityPrice);
        }
    }
}
