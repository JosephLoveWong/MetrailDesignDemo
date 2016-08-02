package com.promiseland.metraildesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.promiseland.metraildesigndemo.R;

/**
 * Created by joseph on 2016/8/2.
 */
public class MyFragment extends Fragment {
    private static final String TAG = "MyFragment";
    private static final String KEY_NAME = "name";

    public static MyFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putSerializable(KEY_NAME, name);

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        TextView tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        tv_name.setText(getArguments().getSerializable(KEY_NAME).toString());

        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Snackbar comes out", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(
                                        getActivity(),
                                        "Toast comes out",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        return rootView;
    }
}
