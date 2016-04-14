package com.test.testandroidproject.models;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class FirstFragmentViewModel extends BaseObservable {
    private String lefttextview;
    private String midtextview;
    private String righttextview;
    private String selectedtextview;

    @Bindable
    public String getLefttextview() {
        return lefttextview;
    }


    public void setLefttextview(String lefttextview) {
        this.lefttextview = lefttextview;
        notifyPropertyChanged(com.test.testandroidproject.BR.lefttextview);
    }

    @Bindable
    public String getMidtextview() {
        return midtextview;
    }

    public void setMidtextview(String midtextview) {
        this.midtextview = midtextview;
        notifyPropertyChanged(com.test.testandroidproject.BR.midtextview);
    }

    @Bindable
    public String getRighttextview() {
        return righttextview;
    }

    public void setRighttextview(String righttextview) {
        this.righttextview = righttextview;
        notifyPropertyChanged(com.test.testandroidproject.BR.righttextview);
    }

    @Bindable
    public String getSelectedtextview() {
        return selectedtextview;
    }

    public void setSelectedtextview(String selectedtextview) {
        this.selectedtextview = selectedtextview;
        notifyPropertyChanged(com.test.testandroidproject.BR.selectedtextview);
    }

}
