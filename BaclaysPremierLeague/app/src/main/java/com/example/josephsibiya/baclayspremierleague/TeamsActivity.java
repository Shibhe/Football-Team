package com.example.josephsibiya.baclayspremierleague;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.josephsibiya.baclayspremierleague.adapters.FixtureAdapter;
import com.example.josephsibiya.baclayspremierleague.adapters.TeamsAdapter;
import com.example.josephsibiya.baclayspremierleague.models.TeamsModel;
import com.example.josephsibiya.baclayspremierleague.services.FetchTeam;

import java.util.ArrayList;

public class TeamsActivity extends AppCompatActivity {


    private Intent intent;
    private RecyclerView recyclerView;
    private TeamsAdapter teamAdapter;
    private ArrayList<TeamsModel> teamModelArrayList = new ArrayList<>();
    private Button fixtures;
    private FixtureAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);


        intent = getIntent();
        final int urlID = intent.getIntExtra("URL", 444);

        /**fixtures = (Button) findViewById(R.id.fixtures);

        fixtures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(TeamsActivity.this, FixtureActivity.class);
               new FetchFixture(adapter, urlID, TeamsActivity.this, "allTeams").execute();
                startActivity(intent);
            }
        });**/

        recyclerView = (RecyclerView) findViewById(R.id.rvTeams);
        teamModelArrayList = new ArrayList<>();
        teamAdapter = new TeamsAdapter(teamModelArrayList, this);
        recyclerView.setAdapter(teamAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        new FetchTeam(teamAdapter, urlID, TeamsActivity.this).execute();
    }
}
