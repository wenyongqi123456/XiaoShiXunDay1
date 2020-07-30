package com.example.xiaoshixunday1.net;

import com.example.xiaoshixunday1.bean.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BaseUrl = "http://www.qubaobei.com/ios/cf/";

    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Observable<FoodBean> getData();
}
