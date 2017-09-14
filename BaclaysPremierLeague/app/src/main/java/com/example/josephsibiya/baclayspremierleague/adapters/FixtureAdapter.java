package com.example.josephsibiya.baclayspremierleague.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josephsibiya.baclayspremierleague.R;
import com.example.josephsibiya.baclayspremierleague.models.FixtureModel;

import java.util.ArrayList;

/**
 * Created by josephsibiya on 2017/09/03.
 */

public class FixtureAdapter extends RecyclerView.Adapter<FixtureAdapter.FixtureViewHolder> {


    private Context context;
    public ArrayList<FixtureModel> fixtureModels;
    public java.text.DateFormat dateFormat;
    //?.,mnvcxprivate FixtureModel fixtureModel;

    public FixtureAdapter(Context context, ArrayList<FixtureModel> fixtureModels) {
        this.context = context;
        this.fixtureModels = fixtureModels;
        //dateFormat = DateFormat.getDateFormat(context).getDateTimeInstance(java.text.DateFormat.MEDIUM, java.text.DateFormat.SHORT);
    }

    @Override
    public FixtureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.fixture_cardview, parent, false);

        return new FixtureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FixtureViewHolder holder, int position) {

        FixtureModel fixture = fixtureModels.get(position);
        View view = null;

        holder.date.setText(dateFormat.format(fixture.getDate()));
        holder.awayTeam.setText(fixture.getAwayTeamName());
        //holder.awayScore.setText(fixture.getGameGoals().getGoalsAwayTeam());
        holder.homeTeam.setText(fixture.getHomeTeamName());
        //holder.homeScore.setText(fixture.getGameGoals().getGoalsHomeTeam());
        holder.status.setText(fixture.getStatus().toString());

        /**if (fixture.getStatus() == FixtureModel.Status.FINISHED)
        {
            view.setBackgroundColor(Color.GREEN);
        }
        else{
            view.setBackgroundColor(Color.YELLOW);
        }**/
    }

    @Override
    public int getItemCount() {
        return fixtureModels.size();
    }

    static class FixtureViewHolder extends RecyclerView.ViewHolder
    {
        private TextView date;
        private TextView status;
        private TextView homeTeam;
        private TextView awayTeam;
        private TextView homeScore;
        private TextView awayScore;

        public FixtureViewHolder(View itemView) {
            super(itemView);


            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
            homeScore = itemView.findViewById(R.id.homeScore);
            homeTeam = itemView.findViewById(R.id.homeTeam);
            awayScore = itemView.findViewById(R.id.awayScore);
            awayTeam = itemView.findViewById(R.id.awayTeam);

        }
    }
}
