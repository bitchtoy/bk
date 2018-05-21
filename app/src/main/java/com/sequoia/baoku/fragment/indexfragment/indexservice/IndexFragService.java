package com.sequoia.baoku.fragment.indexfragment.indexservice;

import android.support.annotation.Nullable;

import com.sequoia.baoku.common.Api;
import com.sequoia.baoku.common.CoustomInterceptor;
import com.sequoia.baoku.common.OnRequest;
import com.sequoia.baoku.fragment.indexfragment.indexfragmentbean.IndexFragBean;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Administrator.
 * @date 2018/4/27.
 * @funtion
 */

public class IndexFragService {
    private Call indexFragCall;

    public static IndexFragService getInstanceIndexFragService(){return new IndexFragService();}

    public void requestIndexFragApi(final OnRequest onRequest){
        Call<String> call = getApi(getClient()).getIndexMessage();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                onRequest.OnRequestSuccess(call,response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                 onRequest.OnRequestFail(call,t);
            }
        });
        indexFragCall = call;

    }
    public void cancle(){
        if (indexFragCall!=null){
            indexFragCall.cancel();
        }
    }
    private static OkHttpClient getClient(){
        return new OkHttpClient.Builder().addInterceptor(new CoustomInterceptor()).build();
    }

    private static Api getApi(OkHttpClient client){
        return new
                Retrofit.Builder().baseUrl("https://www.baidu.com/").client(client)
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
                }).build().create(Api.class);
    }

}
