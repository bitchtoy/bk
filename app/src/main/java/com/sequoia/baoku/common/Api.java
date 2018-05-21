package com.sequoia.baoku.common;

import com.sequoia.baoku.activity.login_registration.bean.LoginBean;
import com.sequoia.baoku.activity.login_registration.bean.RegistrationBean;
import com.sequoia.baoku.activity.login_registration.bean.RegistrationValiDataBean;
import com.sequoia.baoku.fragment.indexfragment.indexfragmentbean.IndexFragBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author Administrator.
 * @date 2018/4/26.
 * @funtion
 */

public interface Api {
    //登录
    @POST("/")
    Call<LoginBean> getLoginMessage();

    //注册验证码
    @POST("index/sendcode")
    Call<RegistrationValiDataBean> getRegistrationValidataCode();

    //注册
    @POST("index/register")
    Call<RegistrationBean> getRegistrationMessage();

    //社区
    @GET("/")
    Call<String> getCommunityMessage();
    //shou ye
    @GET("/")
    Call<String> getIndexMessage();
}
