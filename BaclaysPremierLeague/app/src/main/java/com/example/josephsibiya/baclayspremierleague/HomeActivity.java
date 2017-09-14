package com.example.josephsibiya.baclayspremierleague;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.josephsibiya.baclayspremierleague.adapters.CompetitionAdapter;
import com.example.josephsibiya.baclayspremierleague.models.CompetitionModel;
import com.example.josephsibiya.baclayspremierleague.services.FetchCompetition;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity{


    private Intent intent;
    private RecyclerView recyclerView;
    private CompetitionAdapter competitionAdapter;
    private ArrayList<CompetitionModel> competitionModelArrayList = new ArrayList<>();
    private Context context;


    /**private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.fixtures:
                    intent = new Intent(HomeActivity.this, FixtureActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.competition:
                    //intent = new Intent(HomeActivity.this, CompActivity.class);
                    //startActivity(intent);
                    return true;
            }
            return false;
        }

    };**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /**BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getItemBackgroundResource();**/

        recyclerView = (RecyclerView) findViewById(R.id.rvCompetition);
        competitionModelArrayList = new ArrayList<>();
        competitionAdapter = new CompetitionAdapter(competitionModelArrayList, HomeActivity.this);
        recyclerView.setAdapter(competitionAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        new FetchCompetition(competitionAdapter, HomeActivity.this).execute();

    }
}
