package com.test.testandroidproject.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.test.testandroidproject.BR;

public class Place extends BaseObservable {
    private int id;
    private String name;
    private DistanceData fromcentral;
    private LocationData location;

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }


    public DistanceData getFromcentral() {
        return fromcentral;
    }

    public void setFromcentral(DistanceData fromcentral) {
        this.fromcentral = fromcentral;
    }

    public LocationData getLocation() {
        return location;
    }

    public void setLocation(LocationData location) {
        this.location = location;
    }
}
