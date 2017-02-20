package com.dager.ramraj.daggerexample;

import android.app.Activity;
import android.app.Application;

import timber.log.Timber;


/**
 * Created by ramraj on 20/2/17.
 */

public class GithubApplication extends Application {

    private String TAG = GithubApplication.class.getSimpleName();
    private GitHubApplicationComponent component;

    public static GithubApplication get(Activity activity) {
        return (GithubApplication) activity.getApplication();
    }

    /*graph*/

    //          Activity

    //GithubService             picasso

    //retrofit              OkHttp3Downloader
    //   |     |->--------|      |
    //gson             -->    okhttp

    //                  logger    cache

    //                 timber           file

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        /*context is must othere are not */
        component = DaggerGitHubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
//                .githubServiceModule(new GithubServiceModule())
//                .networkModule(new NetworkModule())
//                .picassoModule(new PicassoModule())
                .build();


    }

    public GitHubApplicationComponent component() {
        return component;
    }

}
