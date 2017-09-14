package com.example.josephsibiya.baclayspremierleague;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.josephsibiya.baclayspremierleague.adapters.FixtureAdapter;
import com.example.josephsibiya.baclayspremierleague.models.FixtureModel;
import com.example.josephsibiya.baclayspremierleague.services.FetchFixture;

import java.util.ArrayList;

public class FixtureActivity extends AppCompatActivity {

    private Intent intent;
    private RecyclerView recyclerView;
    //private int Id;
    private FixtureAdapter fixtureAdapter;
    private ArrayList<FixtureModel> fixture = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture);

        intent = getIntent();
        int urlID = intent.getIntExtra("strUrl", 0);

        recyclerView = (RecyclerView) findViewById(R.id.rvFixture);
        fixture = new ArrayList<>();
        fixtureAdapter = new FixtureAdapter(this, fixture);
        recyclerView.setAdapter(fixtureAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new FetchFixture(fixtureAdapter, urlID, FixtureActivity.this).execute();
    }
}
