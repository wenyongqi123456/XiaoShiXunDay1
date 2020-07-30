package com.example.xiaoshixunday1.view;

import com.example.xiaoshixunday1.bean.FoodBean;

public interface MainView {
    void onSuccess(FoodBean foodBean);
    void onFail(String error);
}
