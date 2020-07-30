package com.example.xiaoshixunday1.presenter;

import com.example.xiaoshixunday1.bean.FoodBean;
import com.example.xiaoshixunday1.model.ImpMainModel;
import com.example.xiaoshixunday1.view.MainCallBack;
import com.example.xiaoshixunday1.view.MainView;

public class ImpMainPresenter implements MainPresenter, MainCallBack {
    private MainView mainView;
    private final ImpMainModel impMainModel;

    public ImpMainPresenter(MainView mainView) {
        this.mainView = mainView;
        impMainModel = new ImpMainModel();
    }

    @Override
    public void getData() {
        impMainModel.getData(this);

    }

    @Override
    public void onSuccess(FoodBean foodBean) {
        mainView.onSuccess(foodBean);
    }

    @Override
    public void onFail(String error) {
        mainView.onFail(error);
    }
}
