package com.melon.melontest.service;

import com.melon.melontest.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GirlsService {

    @GET("random/data/福利/20")
    Observable<Response> getCall();
}
