package com.android.football.api;

import com.android.football.model.Match;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
 
    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of Matches
    */
    @GET("/v1/soccerseasons/424/fixtures")
    Call<Match> getMyJSON();
}