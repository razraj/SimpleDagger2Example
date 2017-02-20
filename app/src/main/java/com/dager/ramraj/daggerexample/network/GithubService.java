package com.dager.ramraj.daggerexample.network;

import com.dager.ramraj.daggerexample.models.GithubRepo;
import com.dager.ramraj.daggerexample.models.GithubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ramraj on 20/2/17.
 */

public interface GithubService {
    @GET("users/{username}/repos")
    Call<List<GithubRepo>> getReposForUser(@Path("username") String username);

    @GET("repositories")
    Call<List<GithubRepo>> getAllRepos();

    @GET("users/{username}")
    Call<GithubUser> getUser(@Path("username") String username);
}
