package com.test.testandroidproject.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.test.testandroidproject.R;
import com.test.testandroidproject.databinding.SpinnerItemBinding;
import com.test.testandroidproject.models.Place;

public class PlacesSpinnerAdapter extends ArrayAdapter<Place> {

    private Context context;
    private Place[] places;
    LayoutInflater inflater;
    private SpinnerItemBinding mBinding;

    public PlacesSpinnerAdapter(Context context, int textViewResourceId,
                                Place[] places) {
        super(context, textViewResourceId, places);
        this.context = context;
        this.places = places;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount(){
        return places.length;
    }

    public Place getItem(int position){
        return places[position];
    }

    public long getItemId(int position){
        return position;
    }


    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        Place objPlace = places[position];
        mBinding = DataBindingUtil.inflate(inflater, R.layout.spinner_item, parent, false);
        mBinding.setPlace(objPlace);
        return mBinding.getRoot();
    }
}