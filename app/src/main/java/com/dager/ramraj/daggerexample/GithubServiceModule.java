package com.dager.ramraj.daggerexample;

import com.dager.ramraj.daggerexample.network.DateTimeConverter;
import com.dager.ramraj.daggerexample.network.GithubService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ramraj on 20/2/17.
 * one of many modules in this app
 */

@Module(includes =  NetworkModule.class)
public class GithubServiceModule {

    @Provides
    @GithubApplicationScope
    public GithubService githubService(Retrofit gitHubRetrofit){

        return gitHubRetrofit.create(GithubService.class);
    }

    @Provides
    @GithubApplicationScope
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateTimeConverter());
        return gsonBuilder.create();

    }

    @Provides
    @GithubApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();
    }
}
