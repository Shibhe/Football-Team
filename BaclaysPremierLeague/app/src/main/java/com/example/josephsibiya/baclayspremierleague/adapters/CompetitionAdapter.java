package com.example.josephsibiya.baclayspremierleague.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josephsibiya.baclayspremierleague.R;
import com.example.josephsibiya.baclayspremierleague.TeamsActivity;
import com.example.josephsibiya.baclayspremierleague.models.CompetitionModel;

import java.util.ArrayList;

/**
 * Created by josephsibiya on 2017/08/31.
 */

public class CompetitionAdapter extends RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder> {

    public ArrayList<CompetitionModel> competitionModels;
    private Context context;
    public int UrlID;

    public CompetitionAdapter(ArrayList<CompetitionModel> competitionModels, Context context) {
        this.competitionModels = competitionModels;
        this.context = context;
        //inflater = LayoutInflater.from(context);
    }

    @Override
    public CompetitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.competition_viewcard, parent, false);

        return new  CompetitionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CompetitionViewHolder holder, int position) {

       final CompetitionModel competitionModel = competitionModels.get(position);

        holder.year.setText("Year: " + competitionModel.getYear());
        holder.numberOfTeams.setText("Team No.: " + competitionModel.getNumberOfTeams());
        holder.numberOfGames.setText("Games No.: " + competitionModel.getNumberOfMatchDays());
        holder.caption.setText("Caption: " + competitionModel.getCaption());
        holder.gameID.setId(competitionModel.getId());


       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(context, TeamsActivity.class);
               intent.putExtra("URL", UrlID = competitionModel.getId());
               context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return competitionModels.size();
    }

    static class CompetitionViewHolder extends RecyclerView.ViewHolder
    {

        private TextView gameID;
        private TextView caption;
        private TextView year;
        private TextView numberOfTeams;
        private TextView numberOfGames;
        private CardView cardView;

        private CompetitionViewHolder(View itemView) {
            super(itemView);

            gameID = itemView.findViewById(R.id.gameID);
            caption = itemView.findViewById(R.id.caption);
            numberOfGames = itemView.findViewById(R.id.numGames);
            numberOfTeams = itemView.findViewById(R.id.numTeams);
            year = itemView.findViewById(R.id.gameYear);
            cardView = itemView.findViewById(R.id.cvCompetition);

        }
    }
}
