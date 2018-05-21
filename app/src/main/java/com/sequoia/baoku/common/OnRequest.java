package com.sequoia.baoku.common;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author Administrator.
 * @date 2018/4/26.
 * @funtion
 */
//网络请求的监听  泛型
public interface OnRequest<T> {
    void OnRequestSuccess(Call<T> call, Response<T> response);

    void OnRequestFail(Call<T> call, Throwable throwable);
}
