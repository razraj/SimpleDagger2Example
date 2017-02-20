package com.dager.ramraj.daggerexample;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramraj on 20/2/17.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @GithubApplicationScope
    public Context context() {
        return context;
    }
}
