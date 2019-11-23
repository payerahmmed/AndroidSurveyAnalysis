package com.example.surveyanalysis.service;

import com.example.surveyanalysis.model.UserInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SurveyanalysisService {
    @POST("register")
    Call<UserInfo> register(
            @Body UserInfo userInfo
    );
}
