package com.sequoia.baoku.fragment.communityfragment.CommunityService;


import android.support.annotation.Nullable;

import com.sequoia.baoku.common.Api;
import com.sequoia.baoku.common.CoustomInterceptor;
import com.sequoia.baoku.common.OnRequest;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author Administrator.
 * @date 2018/4/26.
 * @funtion
 */

public class CommunityService {
    private Call communityCall;

    public static CommunityService getInstanceCommunityService() {
        return new CommunityService();
    }

    public void requestCommunityApi(final OnRequest request) {

        Call<String> communityBeanCall = buildApi(communityClient()).getCommunityMessage();
        communityBeanCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                request.OnRequestSuccess(call, response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                request.OnRequestFail(call, t);
            }

        });
        communityCall = communityBeanCall;
    }

    public void cancle() {
        if (communityCall != null) {
            communityCall.cancel();
        }
    }

    private static OkHttpClient communityClient() {

        return new OkHttpClient.Builder().addInterceptor(new CoustomInterceptor()).build();
    }

    private static Api buildApi(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl("https://www.baidu.com/").client(client)
                .addConverterFactory(new Converter.Factory() {
                    @Nullable
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return new Converter<ResponseBody, String>() {
                            @Override
                            public String convert(ResponseBody value) throws IOException {
                                return value.string();
                            }
                        };
                    }
                })
                .build().create(Api.class);
    }

}
