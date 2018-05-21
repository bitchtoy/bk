package com.sequoia.baoku.activity.login_registration.service;

import com.sequoia.baoku.common.CoustomInterceptor;
import com.sequoia.baoku.activity.login_registration.bean.RegistrationBean;
import com.sequoia.baoku.common.Api;
import com.sequoia.baoku.common.OnRequest;
import com.sequoia.baoku.httpurl.HttpUrl;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Administrator.
 * @date 2018/4/24.
 * @funtion
 */

public class RegistrationService {
    private Call mCall;

    public static RegistrationService getInstanceRegistrationService() {
        return new RegistrationService();
    }

    public void requestRegistrationApi(final OnRequest loginListen) {
        final Call<RegistrationBean> loginCall = buildApi(buildClient()).getRegistrationMessage();
        loginCall.enqueue(new Callback<RegistrationBean>() {
            @Override
            public void onResponse(Call<RegistrationBean> call, Response<RegistrationBean> response) {
                if (loginListen != null) {
                    loginListen.OnRequestSuccess(call, response);
                }
            }

            @Override
            public void onFailure(Call<RegistrationBean> call, Throwable t) {
                if (loginListen != null) {
                    loginListen.OnRequestFail(call, t);
                }
            }
        });
        mCall = loginCall;

    }

    //关闭请求 在ondestory
    public void cancle() {
        if (mCall != null) {
            mCall.cancel();
        }
    }

    //build OkhttpClient
    private OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new CoustomInterceptor()).build();
    }

    //实例化 Api
    private Api buildApi(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(HttpUrl.BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Api.class);

    }

}
