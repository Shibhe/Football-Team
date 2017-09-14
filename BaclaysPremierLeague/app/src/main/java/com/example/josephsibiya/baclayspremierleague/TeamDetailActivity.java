package com.example.josephsibiya.baclayspremierleague;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TeamDetailActivity extends AppCompatActivity {

    private Intent intent;
    //private RecyclerView recyclerView;
    //private TeamsAdapter teamAdapter;
    //private ArrayList<TeamsModel> teamModelArrayList = new ArrayList<>();
    private TextView txtName;
    public int Id;
    private TextView txtTeamCode;
    private ImageView imageView;
    private TextView txtShortName;
    private Button fixture;
    private Button players;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        intent = getIntent();

        final int urlID = intent.getIntExtra("Id", 57);
        String name = intent.getStringExtra("name");
        String code = intent.getStringExtra("code");
        String shortName = intent.getStringExtra("shortName");
        String squadMarketValue = intent.getStringExtra("squadMarketValue");
        String crestUrl = intent.getStringExtra("crestUrl");

        //recyclerView = (RecyclerView) findViewById(R.id.rvTeamDetails);
       // teamModelArrayList = new ArrayList<>();
        //teamAdapter = new TeamsAdapter(teamModelArrayList, this);
       // recyclerView.setAdapter(teamAdapter);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        txtName = (TextView) findViewById(R.id.teamName);
        txtShortName = (TextView) findViewById(R.id.teamShortName);
        txtTeamCode = (TextView) findViewById(R.id.teamCode);
        imageView = (ImageView) findViewById(R.id.logo);
        Glide.with(this).load(crestUrl).into(imageView);

        txtName.setText(name);
        txtTeamCode.setText(code);
        txtShortName.setText(shortName);


        players = (Button) findViewById(R.id.btnPlayers);
        fixture = (Button) findViewById(R.id.btnFixtures);


        players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), PlayersActivity.class);
                intent.putExtra("Id", Id = urlID);
                startActivity(intent);
            }
        });

        fixture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), FixtureActivity.class);
                intent.putExtra("Id", Id = urlID);
                startActivity(intent);
            }
        });
    }
}
