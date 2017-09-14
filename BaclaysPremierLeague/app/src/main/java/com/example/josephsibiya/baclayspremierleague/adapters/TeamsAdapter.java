package com.example.josephsibiya.baclayspremierleague.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.josephsibiya.baclayspremierleague.R;
import com.example.josephsibiya.baclayspremierleague.TeamDetailActivity;
import com.example.josephsibiya.baclayspremierleague.models.TeamsModel;

import java.util.ArrayList;

/**
 * Created by josephsibiya on 2017/08/31.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>{


    public ArrayList<TeamsModel> teamModels;
    private Context context;
    public int Id;
    public String name;
    public String code;
    public  String shortName;
    public  String squadMarketValue;
    public String crestUrl;


    public TeamsAdapter(ArrayList<TeamsModel> teamModels, Context context) {
        this.teamModels = teamModels;
        this.context = context;
    }


    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teams_cardview, parent, false);

        return new TeamViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final TeamViewHolder holder, int position)
    {
        final TeamsModel teamModel = teamModels.get(position);

        holder.setShortName(teamModel.getShortName());
        holder.setName(teamModel.getName());
        Glide.with(context).load(teamModel.getCrestUrl()).into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TeamDetailActivity.class);
                intent.putExtra("Id", Id = teamModel.getId());
                intent.putExtra("name", name = teamModel.getName());
                intent.putExtra("crestUrl", crestUrl = teamModel.getCrestUrl());
                intent.putExtra("shortName", shortName = teamModel.getShortName());
                intent.putExtra("code", code = teamModel.getCode());
                intent.putExtra("squadMarketValue", squadMarketValue = teamModel.getSquadMarketValue());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamModels.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder
    {

        private TextView name;
        private ImageView imageView;
        private TextView shortName;
        private CardView cardView;

        private TeamViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.teamName);
            imageView = itemView.findViewById(R.id.logo);
            shortName = itemView.findViewById(R.id.teamShortName);
            cardView = itemView.findViewById(R.id.teamsCardView);
        }


        public void setName(String name)
        {
            this.name.setText(name);
        }

        public void setShortName(String shortName)
        {
            this.shortName.setText(shortName);
        }
    }
}
