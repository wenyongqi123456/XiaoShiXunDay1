package com.example.xiaoshixunday1.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xiaoshixunday1.R;
import com.example.xiaoshixunday1.adapter.RecyAdapter;
import com.example.xiaoshixunday1.bean.FoodBean;
import com.example.xiaoshixunday1.presenter.ImpMainPresenter;
import com.example.xiaoshixunday1.view.MainView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements MainView {


    private RecyclerView rv_home;
    private ImpMainPresenter impMainPresenter;
    private ArrayList<FoodBean.DataBean> list;
    private RecyAdapter recyAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (list != null) {
                list.clear();
                initData();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        impMainPresenter = new ImpMainPresenter(this);
        initView(view);
       // initData();

        return view;
    }

    private void initData() {
        impMainPresenter.getData();

    }

    private void initView(View view) {
        rv_home = view.findViewById(R.id.rv_home);
        list = new ArrayList<>();
        recyAdapter = new RecyAdapter(list, getActivity());
        rv_home.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_home.setAdapter(recyAdapter);

    }

    @Override
    public void onSuccess(FoodBean foodBean) {
        list.addAll(foodBean.getData());
        recyAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();

    }
}
