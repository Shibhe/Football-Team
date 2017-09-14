package com.example.josephsibiya.baclayspremierleague;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.josephsibiya.baclayspremierleague.adapters.PlayersAdapter;
import com.example.josephsibiya.baclayspremierleague.models.PlayersModel;
import com.example.josephsibiya.baclayspremierleague.services.FetchPlayers;

import java.util.ArrayList;

public class PlayersActivity extends AppCompatActivity {

    private PlayersAdapter adapter;
    private Intent intent;
    private RecyclerView recyclerView;
    private ArrayList<PlayersModel> playersAdapters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        intent = getIntent();
        int urlID = intent.getIntExtra("Id", 0);

        recyclerView = (RecyclerView) findViewById(R.id.rvPlayers);
        playersAdapters = new ArrayList<>();
        adapter = new PlayersAdapter(playersAdapters);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new FetchPlayers(adapter, urlID, PlayersActivity.this).execute();
    }
}
