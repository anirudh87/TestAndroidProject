package com.test.testandroidproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.test.testandroidproject.R;

public class PagerFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    public static final PagerFragment newInstance(String message)
    {
        PagerFragment f = new PagerFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.pager_item_layout, container, false);

        LinearLayout pagerOuter = (LinearLayout) v.findViewById(R.id.pager_outer);
        pagerOuter.setTag(R.string.layouttag, message);
        pagerOuter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = (String) v.getTag(R.string.layouttag);
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });
        TextView messageTextView = (TextView)v.findViewById(R.id.tv_pagertext);
        messageTextView.setText(message);

        return v;
    }
}
