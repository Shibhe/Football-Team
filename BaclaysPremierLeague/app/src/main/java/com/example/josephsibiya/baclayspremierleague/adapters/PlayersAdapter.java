package com.example.josephsibiya.baclayspremierleague.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josephsibiya.baclayspremierleague.R;
import com.example.josephsibiya.baclayspremierleague.models.PlayersModel;

import java.util.ArrayList;

/**
 * Created by josephsibiya on 2017/08/31.
 */

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayersViewHolder> {

    public ArrayList<PlayersModel> playersModelArrayList = new ArrayList<>();

    public PlayersAdapter(ArrayList<PlayersModel> playersModelArrayList) {
        this.playersModelArrayList = playersModelArrayList;
    }

    @Override
    public PlayersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.players_cardview, parent, false);

        return new PlayersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayersViewHolder holder, int position) {

        PlayersModel playersModel = playersModelArrayList.get(position);

        holder.setName(playersModel.getName());
        holder.setJerseyNumber(playersModel.getJerseyNumber());
        holder.setPosition(playersModel.getPosition());

    }

    @Override
    public int getItemCount() {
        return playersModelArrayList.size();
    }

    static class PlayersViewHolder extends RecyclerView.ViewHolder
    {

        private TextView name;
        private TextView position;
        private TextView jerseyNumber;

        public PlayersViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            position = itemView.findViewById(R.id.position);
            jerseyNumber = itemView.findViewById(R.id.jerseyNumber);
        }

        public void setName(String name)
        {
            this.name.setText(name);
        }

        public void setPosition(String position)
        {
            this.position.setText(position);
        }

        public void setJerseyNumber(String jerseyNumber)
        {
            this.jerseyNumber.setText(jerseyNumber);
        }
    }
}
