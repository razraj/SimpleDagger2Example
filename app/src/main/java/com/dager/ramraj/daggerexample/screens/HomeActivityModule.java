package com.dager.ramraj.daggerexample.screens;

import com.dager.ramraj.daggerexample.screens.home.AdapterRepos;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramraj on 20/2/17.
 */

@Module
public class HomeActivityModule {
    private final HomeActivity homeActivity;

    public HomeActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides
    @HomeActivityScope
    public HomeActivity adapterRepos(){
        return homeActivity;
    }
}
