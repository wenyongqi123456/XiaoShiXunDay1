package com.example.xiaoshixunday1.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaoshixunday1.R;
import com.example.xiaoshixunday1.bean.DbBean;
import com.example.xiaoshixunday1.sql.SqlHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        SqlHelper sqlHelper = new SqlHelper(getActivity());

        for (int i = 0; i < 10; i++) {

            sqlHelper.insertXiao(new DbBean("张三" + i, i));
        }

        ArrayList<DbBean> query = sqlHelper.query();
        Log.e("tag", "initView: " + query);

        ArrayList<DbBean> queryCondition = sqlHelper.queryCondition("张三1");

        Log.e("tag", "initView: " + queryCondition);

    }

}
