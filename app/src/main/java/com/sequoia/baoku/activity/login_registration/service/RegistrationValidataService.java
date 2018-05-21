package com.sequoia.baoku.activity.login_registration.service;

import com.sequoia.baoku.common.CoustomInterceptor;
import com.sequoia.baoku.activity.login_registration.bean.RegistrationValiDataBean;
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

public class RegistrationValidataService {
    private Call mCall;

    public static RegistrationValidataService getInstanceRegistrationValidataService() {
        return new RegistrationValidataService();
    }

    public void requestRegistrationValidataApi(final OnRequest valiDataListen) {
        final Call<RegistrationValiDataBean> loginCall = buildApi(buildClient()).getRegistrationValidataCode();
        loginCall.enqueue(new Callback<RegistrationValiDataBean>() {
            @Override
            public void onResponse(Call<RegistrationValiDataBean> call, Response<RegistrationValiDataBean> response) {
                if (valiDataListen != null) {
                    valiDataListen.OnRequestSuccess(call, response);
                }
            }

            @Override
            public void onFailure(Call<RegistrationValiDataBean> call, Throwable t) {
                if (valiDataListen != null) {
                    valiDataListen.OnRequestFail(call, t);
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
