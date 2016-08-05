package com.promiseland.metraildesigndemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.promiseland.metraildesigndemo.bean.FragmentInfo;
import com.promiseland.metraildesigndemo.fragment.BooksFragment;
import com.promiseland.metraildesigndemo.fragment.HomeFragment;
import com.promiseland.metraildesigndemo.fragment.MoviesFragment;
import com.promiseland.metraildesigndemo.fragment.MusicFragment;
import com.promiseland.metraildesigndemo.fragment.MyFragment;
import com.promiseland.metraildesigndemo.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_BOOKS = 1;
    private static final int FRAGMENT_MUSIC = 2;
    private static final int FRAGMENT_MOVIES = 3;
    private static final int FRAGMENT_MY = 4;
    public static final String TAB_HOME = "Home";
    public static final String TAB_BOOKS = "Books";
    public static final String TAB_MUSIC = "Music";
    public static final String TAB_MOVIES_TV = "Movies & TV";
    public static final String TAB_MY = "My";

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private Map<Integer, FragmentInfo> mFragmentInfos = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);
        setupDrawerViews();
        setupContentViews();
    }

    private void setupDrawerViews() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                LogUtil.d(TAG, "onNavigationItemSelected " + item.getItemId());
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void setupContentViews() {
        final BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp,  TAB_HOME).setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, TAB_BOOKS))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, TAB_MUSIC))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, TAB_MOVIES_TV))
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp, TAB_MY))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
//                LogUtil.d(TAG, "onTabSelected " + position);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment;
                switch (position){
                    case FRAGMENT_HOME:
                        fragment = HomeFragment.newInstance(TAB_HOME);
                        transaction.replace(R.id.fragment_container, fragment);
                        break;
                    case FRAGMENT_BOOKS:
                        fragment = BooksFragment.newInstance(TAB_BOOKS);
                        transaction.replace(R.id.fragment_container, fragment);
                        break;
                    case FRAGMENT_MUSIC:
                        fragment = MusicFragment.newInstance(TAB_MUSIC);
                        transaction.replace(R.id.fragment_container, fragment);
                        break;
                    case FRAGMENT_MOVIES:
                        fragment = MoviesFragment.newInstance(TAB_MOVIES_TV);
                        transaction.replace(R.id.fragment_container, fragment);
                        break;
                    case FRAGMENT_MY:
                        fragment = MyFragment.newInstance(TAB_MY);
                        transaction.replace(R.id.fragment_container, fragment);
                        break;
                }

                transaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {
//                LogUtil.d(TAG, "onTabUnselected " + position);
            }

            @Override
            public void onTabReselected(int position) {
//                LogUtil.d(TAG, "onTabReselected " + position);
            }
        });

        setDefaultFragment();

    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fragment = HomeFragment.newInstance(TAB_HOME);
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}
