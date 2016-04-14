package com.test.testandroidproject.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.test.testandroidproject.R;
import com.test.testandroidproject.databinding.PagerItemLayoutBinding;
import com.test.testandroidproject.models.PagerFragmentViewModel;

public class PagerFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private PagerItemLayoutBinding mBinding;
    String message;

    public static PagerFragment newInstance(String message) {
        PagerFragment f = new PagerFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        message = getArguments().getString(EXTRA_MESSAGE);
        PagerFragmentViewModel pagerViewModel = new PagerFragmentViewModel();
        mBinding = DataBindingUtil.inflate(inflater, R.layout.pager_item_layout, container, false);
        mBinding.setPagerfragmentVM(pagerViewModel);
        View v = mBinding.getRoot();

        pagerViewModel.setPagertext(message);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.pagerOuter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });





    }
}
