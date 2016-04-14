package com.test.testandroidproject.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.test.testandroidproject.R;
import com.test.testandroidproject.activity.MainActivity;
import com.test.testandroidproject.adapters.PlacesSpinnerAdapter;
import com.test.testandroidproject.databinding.SecondFragmentBinding;
import com.test.testandroidproject.interfaces.CallBack;
import com.test.testandroidproject.managers.CommunicationManager;
import com.test.testandroidproject.models.Place;
import com.test.testandroidproject.utility.Constants;

public class SecondFragment extends Fragment implements CallBack, View.OnClickListener{
    Context mContext;
    CommunicationManager commObj;
    Place[] arPlaces;
    private Spinner placesSpinner;
    TextView car, train;
    private Button navigateBtn;
    int selectedPosition;
    ProgressDialog pd;
    SecondFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        commObj = new CommunicationManager(mContext);
        binding = DataBindingUtil.inflate(inflater, R.layout.second_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        placesSpinner = (Spinner) view.findViewById(R.id.places);
        binding.navigateBtn.setOnClickListener(this);
        loadLocationsData();
    }

    public void loadLocationsData() {
        pd = new ProgressDialog(mContext);
        pd.setMessage("Fetching Locations..");
        pd.setCancelable(false);
        pd.show();
        commObj.CallWebService(mContext, Constants.WEBSERVICE_URL, this, Constants.TaskID);
    }

    @Override
    public void onResult(String data, int tasksID) {
        if(pd.isShowing()) {
            pd.dismiss();
            pd.cancel();
        }
        if(tasksID == Constants.TaskID) {
            Gson objgson = new Gson();
            try {
                arPlaces = objgson.fromJson(data, Place[].class);
                placesSpinner.setAdapter(new PlacesSpinnerAdapter(mContext, R.layout.spinner_item, arPlaces));
                placesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                        selectedPosition = position;
                        Place objPlace = arPlaces[position];
                        binding.setDistancedata(objPlace.getFromcentral());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parentView) {
                    }

                });
            }
            catch(Exception e) {
                Toast.makeText(mContext, getString(R.string.errormsg), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.navigate_btn) {
            Fragment newFragment = new LocationFragment();
            Bundle locationData = new Bundle();
            if(arPlaces != null && arPlaces.length > 0) {
                locationData.putDouble(Constants.LATITUDE, arPlaces[selectedPosition].getLocation().getLatitude());
                locationData.putDouble(Constants.LONGITUDE, arPlaces[selectedPosition].getLocation().getLongitude());
                locationData.putString(Constants.PLACE, arPlaces[selectedPosition].getName());
            }
            newFragment.setArguments(locationData);
            ((MainActivity) getActivity()).replaceFragment(newFragment);
        }
    }
}
