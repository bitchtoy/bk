package com.sequoia.baoku.activity.login_registration.service;

import com.sequoia.baoku.common.CoustomInterceptor;
import com.sequoia.baoku.activity.login_registration.bean.LoginBean;
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
//登录接口处理
public class LoginService {
    private Call mCall;

    public static LoginService getInstanceLoginService() {
        return new LoginService();
    }

    public void requestLoginApi(final OnRequest loginListen) {
        final Call<LoginBean> loginCall = buildApi(buildClient()).getLoginMessage();
        loginCall.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                if (loginListen != null) {
                    loginListen.OnRequestSuccess(call, response);
                }
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                if (loginListen != null) {
                    loginListen.OnRequestFail(call, t);
                }
            }
        });
        mCall = loginCall;

    }

    public void cancle() {
        if (mCall != null) {
            mCall.cancel();
        }
    }

    private OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new CoustomInterceptor()).build();
    }

    private Api buildApi(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(HttpUrl.BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Api.class);

    }

}
