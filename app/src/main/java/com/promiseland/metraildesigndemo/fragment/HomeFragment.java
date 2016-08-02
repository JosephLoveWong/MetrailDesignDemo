package com.promiseland.metraildesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.promiseland.metraildesigndemo.R;

/**
 * Created by joseph on 2016/8/2.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "MyFragment";
    private static final String KEY_NAME = "name";

    public static HomeFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putSerializable(KEY_NAME, name);

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        TextView tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        tv_name.setText(getArguments().getSerializable(KEY_NAME).toString());

        return rootView;
    }
}
