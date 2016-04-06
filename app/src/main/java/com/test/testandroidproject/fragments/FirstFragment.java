package com.test.testandroidproject.fragments;

import android.content.Context;
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


public class FirstFragment extends Fragment implements View.OnClickListener{

    private TabLayout tabLayout;
    Context mContext;
    private ViewPager pager;
    private TextView selectedText;
    private LinearLayout bottomBtnsContainer;
    Button redBtn, greenBtn, blueBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        return inflater.inflate(R.layout.firstfragment_layout, container, false);
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

        selectedText = (TextView) view.findViewById(R.id.selected_textview);
        bottomBtnsContainer = (LinearLayout) view.findViewById(R.id.bottom_btns_container);
        redBtn = (Button) view.findViewById(R.id.red_btn);
        greenBtn = (Button) view.findViewById(R.id.green_btn);
        blueBtn = (Button) view.findViewById(R.id.blue_btn);
        redBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        blueBtn.setOnClickListener(this);
    }

    public void setTabs() {
        for(int i = 1; i<=5; i++) {
            tabLayout.addTab(tabLayout.newTab().setText("Item "+i));
        }
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(mContext, tab.getText().toString(), Toast.LENGTH_SHORT).show();
                selectedText.setText(tab.getText());
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
