package com.test.testandroidproject.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.test.testandroidproject.R;
import com.test.testandroidproject.adapters.CustomViewPagerAdapter;
import com.test.testandroidproject.databinding.FirstfragmentLayoutBinding;
import com.test.testandroidproject.models.FirstFragmentViewModel;


public class FirstFragment extends Fragment implements View.OnClickListener{

    private TabLayout tabLayout;
    Context mContext;
    private ViewPager pager;
    private TextView selectedText;
    private LinearLayout bottomBtnsContainer;
    Button redBtn, greenBtn, blueBtn;
    private FirstfragmentLayoutBinding mBinding;
    FirstFragmentViewModel firstFragmentViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        firstFragmentViewModel = new FirstFragmentViewModel();
        mBinding = DataBindingUtil.inflate(inflater, R.layout.firstfragment_layout, container, false);
        mBinding.setFirstfragmentVM(firstFragmentViewModel);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeViews(view);
    }

    public void initializeViews(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        setTabs();

        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(new CustomViewPagerAdapter(getActivity().getSupportFragmentManager()));

        bottomBtnsContainer = (LinearLayout) view.findViewById(R.id.bottom_btns_container);

        firstFragmentViewModel.setLefttextview(getResources().getString(R.string.textview1));
        firstFragmentViewModel.setMidtextview(getResources().getString(R.string.textview2));
        firstFragmentViewModel.setRighttextview(getResources().getString(R.string.textview3));
        mBinding.redBtn.setOnClickListener(this);
        mBinding.greenBtn.setOnClickListener(this);
        mBinding.blueBtn.setOnClickListener(this);
    }

    public void setTabs() {
        for(int i = 1; i<=5; i++) {
            tabLayout.addTab(tabLayout.newTab().setText("Item "+i));
        }
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String selectedTabValue = tab.getText().toString();
                if(selectedTabValue != null) {
                    firstFragmentViewModel.setSelectedtextview(selectedTabValue);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void setTVBackgroundColor(View container, int bgColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            container.setBackgroundColor(getActivity().getResources().getColor(bgColor, getActivity().getTheme()));
        }else {
            container.setBackgroundColor(getActivity().getResources().getColor(bgColor));
        }
    }

    @Override
    public void onClick(View clickedView) {
        switch (clickedView.getId()) {
            case R.id.red_btn:
                setTVBackgroundColor(bottomBtnsContainer, R.color.redColor);
                break;
            case R.id.green_btn:
                setTVBackgroundColor(bottomBtnsContainer, R.color.greenColor);
                break;

            case R.id.blue_btn:
                setTVBackgroundColor(bottomBtnsContainer, R.color.blueColor);
                break;
        }
    }
}
