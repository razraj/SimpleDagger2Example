package com.dager.ramraj.daggerexample;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by ramraj on 20/2/17.
 */

@Module(includes = {ContextModule.class,NetworkModule.class})
public class PicassoModule {

    @Provides
    @GithubApplicationScope
    public Picasso picasso(Context context, OkHttp3Downloader okHttpClient){
        return new Picasso.Builder(context)
                .downloader(okHttpClient)
                .build();
    }

    @Provides
    @GithubApplicationScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient ){
        return new OkHttp3Downloader(okHttpClient);
    }
}
