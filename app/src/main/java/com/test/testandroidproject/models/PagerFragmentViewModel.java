package com.test.testandroidproject.models;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.test.testandroidproject.BR;

public class PagerFragmentViewModel extends BaseObservable {

    private String pagertext;

    @Bindable
    public String getPagertext() {
        return pagertext;
    }

    public void setPagertext(String pagertext) {
        this.pagertext = pagertext;
        notifyPropertyChanged(BR.pagertext);
    }
}
