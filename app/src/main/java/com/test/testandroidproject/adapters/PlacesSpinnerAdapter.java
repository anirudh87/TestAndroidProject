package com.test.testandroidproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.test.testandroidproject.R;
import com.test.testandroidproject.models.Place;

public class PlacesSpinnerAdapter extends ArrayAdapter<Place> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private Place[] places;
    LayoutInflater inflater;

    public PlacesSpinnerAdapter(Context context, int textViewResourceId,
                                Place[] places) {
        super(context, textViewResourceId, places);
        this.context = context;
        this.places = places;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
        View row = inflater.inflate(R.layout.spinner_item, parent, false);

        TextView placename = (TextView) row.findViewById(R.id.placename);
        placename.setText(objPlace.getName());

        return row;
    }

}