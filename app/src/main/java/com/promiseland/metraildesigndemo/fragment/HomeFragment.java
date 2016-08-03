package com.promiseland.metraildesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.promiseland.metraildesigndemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 2016/8/2.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "MyFragment";
    private static final String KEY_NAME = "name";

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private TabLayout mTabLayout;
    private List<String> mDatas;

    public static HomeFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putSerializable(KEY_NAME, name);

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPagerAdapter = new HomePagerAdapter(getActivity().getSupportFragmentManager());

        mDatas = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            mDatas.add("Fragment " + i);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        mViewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        mViewPager.setAdapter(mPagerAdapter);

        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

        return rootView;
    }

    private class HomePagerAdapter extends FragmentStatePagerAdapter{

        public HomePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mDatas.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return BaseFragment.newInstance(mDatas.get(position));
        }

        @Override
        public int getCount() {
            if(mDatas != null){
                return mDatas.size();
            }
            return 0;
        }
    }
}
