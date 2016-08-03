package com.promiseland.metraildesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.promiseland.metraildesigndemo.R;
import com.promiseland.metraildesigndemo.utils.LogUtil;

/**
 * Created by 960100 on 2016/8/3.
 */
public class BooksFragment extends Fragment{
    private static final String TAG = "BooksFragment";
    private static final String KEY_NAME = "name";

    public static BooksFragment newInstance(String name) {
        
        Bundle args = new Bundle();
        args.putSerializable(KEY_NAME, name);
        
        BooksFragment fragment = new BooksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_books, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setTitle(getArguments().getSerializable(KEY_NAME).toString());
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
                LogUtil.d(TAG, "action_delete");
                break;
            case R.id.action_search:
                LogUtil.d(TAG, "action_search");
                break;
            case R.id.action_share:
                LogUtil.d(TAG, "action_share");
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
