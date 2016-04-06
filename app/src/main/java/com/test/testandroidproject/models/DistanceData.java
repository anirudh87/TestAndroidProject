package com.test.testandroidproject.models;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.test.testandroidproject.BR;

public class DistanceData extends BaseObservable {
    private String car;
    private String train;

    public DistanceData(String car, String train) {
        this.car = car;
        this.train = train;
    }

    @Bindable
    public String getTrain() {
        return train;
    }


    public void setTrain(String train) {
        this.train = train;
        notifyPropertyChanged(BR.train);
    }

    @Bindable
    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
        notifyPropertyChanged(BR.car);

    }



}
