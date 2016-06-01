package br.com.john.kimberlyclark;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.john.kimberlyclark.ConnectionAPI.ConnectionFromAPI;
import br.com.john.kimberlyclark.Services.AllActivitys;
import br.com.john.kimberlyclark.Services.AppSectionsPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;
    ViewPager mViewPagerHome;
    Toolbar toolbar;
    public static LinearLayout linearInfo;
    public static TextView textInfoMachine, textInfoSystem, textInfoGroup, textCancel, textInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        ImageView imgBack = (ImageView) findViewById(R.id.imgview_back_toolbar_default);
        LinearLayout linearBack = (LinearLayout) findViewById(R.id.linear_back_button);
        linearBack.setVisibility(View.GONE);
        imgBack.setVisibility(View.GONE);
        setSupportActionBar(toolbar);

        linearInfo = (LinearLayout) findViewById(R.id.linear_show_info);
        textInfoGroup = (TextView) findViewById(R.id.text_info_group);
        textInfoMachine = (TextView) findViewById(R.id.text_info_machine);
        textInfoSystem = (TextView) findViewById(R.id.text_info_system);
        textCancel = (TextView) findViewById(R.id.text_cancel);
        textInit = (TextView) findViewById(R.id.text_init);

        linearInfo.setOnClickListener(hideInfo);
        textCancel.setOnClickListener(hideInfo);

        AllActivitys.mainActivity = MainActivity.this;

        Fragment fragments[] = new Fragment[]{new ProcessFragment(),
                new HistoricFragment(), new UploadsFragment()};

        String tabIcons[] = {getResources().getString(R.string.processos),
                getResources().getString(R.string.historico),
                getResources().getString(R.string.uploads)};

        String tabTitles[] = new String[]{"Tab1", "Tab2", "Tab3"};

        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
        mAppSectionsPagerAdapter.setTabIcons(tabIcons);
        mAppSectionsPagerAdapter.setTabTitles(tabTitles);
        mAppSectionsPagerAdapter.setFragments(fragments);

        mViewPagerHome = (ViewPager) findViewById(R.id.pager);
        mViewPagerHome.setOffscreenPageLimit(3);
        mViewPagerHome.setAdapter(mAppSectionsPagerAdapter);


        final PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);

        tabs.setViewPager(mViewPagerHome);
        tabs.setSmoothScrollingEnabled(true);
        tabs.setHorizontalFadingEdgeEnabled(true);
        tabs.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }
        });

        if (mAppSectionsPagerAdapter != null) {
            for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            }
        }


        ConnectionFromAPI conn = new ConnectionFromAPI();
        conn.getProcess();
    }

    public static View.OnClickListener hideInfo = new View.OnClickListener() {
        public void onClick(View v) {
            linearInfo.setVisibility(View.GONE);
        }
    };

    public static void cleanInfos(){
        textInfoGroup.setText("");
        textInfoMachine.setText("");
        textInfoSystem.setText("");
    }

    @Override
    public void onBackPressed() {
        int position = mViewPagerHome.getCurrentItem();
        if (position == 0) {
            MainActivity.this.finish();
        } else {
            mViewPagerHome.setCurrentItem(0);
        }
    }
}
