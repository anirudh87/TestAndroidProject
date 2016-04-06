package com.test.testandroidproject.models;

public class Place {
    private int id;
    private String name;
    private DistanceData fromcentral;
    private LocationData location;

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
