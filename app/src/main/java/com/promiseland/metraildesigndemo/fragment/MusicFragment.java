package com.promiseland.metraildesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.promiseland.metraildesigndemo.R;
import com.promiseland.metraildesigndemo.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 960100 on 2016/8/3.
 */
public class MusicFragment extends Fragment{
    private static final String TAG = "MusicFragment";
    private static final String KEY_NAME = "name";

    private List<String> mDatas;

    public static MusicFragment newInstance(String name) {
        
        Bundle args = new Bundle();
        args.putSerializable(KEY_NAME, name);
        
        MusicFragment fragment = new MusicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mDatas = new ArrayList<>();
        for(int i = 0; i< 100; i++){
            mDatas.add("position " + i);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_music, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setTitle(getArguments().getSerializable(KEY_NAME).toString());
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recycleView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleView.setAdapter(new BooksAdapter());

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

    /**
     * RecyclerAdapter
     */
    class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder>{

        @Override
        public BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            BooksViewHolder holder = new BooksViewHolder(getActivity().getLayoutInflater().inflate(R.layout.recycler_item_books, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(BooksViewHolder holder, int position) {
            holder.textView.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            if(mDatas != null){
                return mDatas.size();
            }
            return 0;
        }

        class BooksViewHolder extends RecyclerView.ViewHolder{
            public TextView textView;
            public BooksViewHolder(View itemView) {
                super(itemView);

                textView = (TextView) itemView.findViewById(R.id.tv);
            }
        }
    }


}
