package com.example.xiaoshixunday1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.xiaoshixunday1.adapter.FragmentAdapter;
import com.example.xiaoshixunday1.adapter.RecyAdapter;
import com.example.xiaoshixunday1.bean.FoodBean;
import com.example.xiaoshixunday1.fragment.HomeFragment;
import com.example.xiaoshixunday1.fragment.MyFragment;
import com.example.xiaoshixunday1.presenter.ImpMainPresenter;
import com.example.xiaoshixunday1.view.MainView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MyFragment());
        fragments.add(new HomeFragment());

        ArrayList<String> titles = new ArrayList<>();
        titles.add("首页");
        titles.add("我的");
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(fragmentAdapter);

        tab.setupWithViewPager(vp);

    }


}
