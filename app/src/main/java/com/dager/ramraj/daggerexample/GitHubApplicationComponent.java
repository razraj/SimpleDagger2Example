package com.dager.ramraj.daggerexample;

import com.dager.ramraj.daggerexample.network.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by ramraj on 20/2/17.
 * this is a dagger component which contain top level component used by activity
 * modules tells the component to use that particular module in this component
 */
@GithubApplicationScope
@Component(modules = {GithubServiceModule.class,PicassoModule.class})
public interface GitHubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();
}
