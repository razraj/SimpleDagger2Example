package com.dager.ramraj.daggerexample.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.dager.ramraj.daggerexample.R;
import com.dager.ramraj.daggerexample.GithubApplication;
import com.dager.ramraj.daggerexample.models.GithubRepo;
import com.dager.ramraj.daggerexample.network.GithubService;
import com.dager.ramraj.daggerexample.screens.home.AdapterRepos;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.repo_home_list)
    ListView listView;

    @Inject
    GithubService githubService;

    @Inject
    AdapterRepos adapterRepos;

    Call<List<GithubRepo>> reposCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        HomeActivityComponent component = DaggerHomeActivityComponent.builder()
                .homeActivityModule(new HomeActivityModule(this))
                .gitHubApplicationComponent(GithubApplication.get(this).component())
                .build();

        component.injectHomeActivity(this);

        listView.setAdapter(adapterRepos);


        reposCall = githubService.getAllRepos();
        reposCall.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                adapterRepos.swapData(response.body());
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Error getting repos " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (reposCall != null)
            reposCall.cancel();
    }
}
