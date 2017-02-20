package com.dager.ramraj.daggerexample.screens;

import com.dager.ramraj.daggerexample.GitHubApplicationComponent;
import com.dager.ramraj.daggerexample.network.GithubService;
import com.dager.ramraj.daggerexample.screens.home.AdapterRepos;

import dagger.Component;

/**
 * Created by ramraj on 20/2/17.
 */
@HomeActivityScope
@Component(modules = HomeActivityModule.class,
        dependencies = GitHubApplicationComponent.class)
public interface HomeActivityComponent {
    HomeActivity injectHomeActivity(HomeActivity homeActivity);
}
